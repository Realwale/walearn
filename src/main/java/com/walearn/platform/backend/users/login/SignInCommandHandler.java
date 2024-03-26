package com.walearn.platform.backend.users.login;


import com.walearn.platform.backend.common.exception.UnprocessableEntityException;
import com.walearn.platform.backend.security.JwtService;
import com.walearn.platform.backend.users.Role;
import com.walearn.platform.backend.users.UserRepository;
import com.walearn.platform.backend.users.response.APIResponse;
import lombok.RequiredArgsConstructor;

import org.axonframework.commandhandling.CommandHandler;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import java.util.Collections;
import java.util.Set;

/**
 * Represents Sign In command handler.
 */
@RequiredArgsConstructor
@Component
public class SignInCommandHandler {

    private final JwtService jwtTokenProvider;
    private final UserRepository repository;
    private final Validator validator;
    private final AuthenticationManager authenticationManager;

    /**
     * Handles sign in command. Authenticates and returns token.
     *
     * @param command command
     * @return token
     * @throws ConstraintViolationException validation errors
     * @throws UnprocessableEntityException invalid username/password
     */
    @CommandHandler
    @NonNull
    public APIResponse handle(SignInCommand command) {
        try {
            final Set<ConstraintViolation<SignInCommand>> violations = validator.validate(command);
            if (!violations.isEmpty()) {
                throw new ConstraintViolationException(violations);
            }

            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(command.getUsername(), command.getPassword()));
            String token = jwtTokenProvider.createToken(command.getUsername(), Collections.singletonList(Role.from(repository.findByUsername(command.getUsername()).get().toDTO().getRole())));
            return APIResponse.builder()
                    .status("SUCCESS")
                    .message("Account created successfully")
                    .data(token)
                    .build();
        } catch (AuthenticationException e) {
            throw new UnprocessableEntityException("Invalid username/password");
        }
    }
}

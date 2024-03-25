package com.walearn.platform.backend.users.service;


import com.walearn.platform.backend.users.login.SignInCommand;
import com.walearn.platform.backend.users.registration.UserRegistrationCommand;
import com.walearn.platform.backend.users.request.SignInRequest;
import com.walearn.platform.backend.users.request.SignUpRequest;
import com.walearn.platform.backend.users.response.APIResponse;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService{

    private final CommandGateway commandGateway;

    @Override
    public APIResponse signup(SignUpRequest signUpRequest){
        UserRegistrationCommand command = UserRegistrationCommand
                .builder()
                .role(signUpRequest.getRole())
                .email(signUpRequest.getEmail())
                .username(signUpRequest.getUsername())
                .password(signUpRequest.getPassword())
                .build();

         return APIResponse.builder()
                 .status("SUCCESS")
                 .message("Account created successfully")
                 .data(commandGateway.sendAndWait(command))
                 .build();
    }

    @Override
    public APIResponse signIn(SignInRequest signInRequest) {
        SignInCommand command = SignInCommand
                .builder()
                .username(signInRequest.getUsername())
                .password(signInRequest.getPassword())
                .build();

        return APIResponse.builder()
                .status("SUCCESS")
                .message("Sign-in successful")
                .data(commandGateway.sendAndWait(command))
                .build();
    }
}

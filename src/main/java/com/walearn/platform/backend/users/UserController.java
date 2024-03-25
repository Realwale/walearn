package com.walearn.platform.backend.users;

import com.walearn.platform.backend.users.login.SignInCommand;
import com.walearn.platform.backend.users.registration.UserRegistrationCommand;
import com.walearn.platform.backend.users.request.SignInRequest;
import com.walearn.platform.backend.users.request.SignUpRequest;
import jakarta.validation.Valid;



import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
@Validated
public class UserController {

	private final CommandGateway commandGateway;

	@PostMapping("/sign-up")
	public String signUp(@Valid @RequestBody SignUpRequest signUpRequest) {
		UserRegistrationCommand command = UserRegistrationCommand
				.builder()
				.role(signUpRequest.getRole())
				.email(signUpRequest.getEmail())
				.username(signUpRequest.getUsername())
				.password(signUpRequest.getPassword())
				.build();

		return commandGateway.sendAndWait(command);
	}

	@PostMapping("/sign-in")
	public String signIn(@Valid @RequestBody SignInRequest signInRequest) {
		SignInCommand command = SignInCommand
				.builder()
				.username(signInRequest.getUsername())
				.password(signInRequest.getPassword())
				.build();

		return commandGateway.sendAndWait(command);
	}
}

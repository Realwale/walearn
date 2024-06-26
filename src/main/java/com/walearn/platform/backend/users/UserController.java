package com.walearn.platform.backend.users;

import com.walearn.platform.backend.users.login.SignInCommand;
import com.walearn.platform.backend.users.registration.UserRegistrationCommand;
import com.walearn.platform.backend.users.request.SignInRequest;
import com.walearn.platform.backend.users.request.SignUpRequest;
import com.walearn.platform.backend.users.response.APIResponse;
import jakarta.validation.Valid;



import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<APIResponse> signUp(@Valid @RequestBody SignUpRequest signUpRequest) {
		UserRegistrationCommand command = UserRegistrationCommand
				.builder()
				.role(signUpRequest.getRole())
				.email(signUpRequest.getEmail())
				.username(signUpRequest.getUsername())
				.password(signUpRequest.getPassword())
				.build();

		APIResponse response = commandGateway.sendAndWait(command);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	@PostMapping("/sign-in")
	public ResponseEntity<APIResponse> signIn(@Valid @RequestBody SignInRequest signInRequest) {
		SignInCommand command = SignInCommand
				.builder()
				.username(signInRequest.getUsername())
				.password(signInRequest.getPassword())
				.build();

		APIResponse response = commandGateway.sendAndWait(command);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}

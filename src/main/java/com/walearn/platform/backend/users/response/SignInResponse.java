package com.walearn.platform.backend.users.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * Represents the response after sign in operation.
 */
@Builder
@Data
@AllArgsConstructor
public class SignInResponse {

    private final String token;

}

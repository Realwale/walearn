package com.walearn.platform.backend.users.request;

import com.walearn.platform.backend.users.RoleDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


/**
 * Represents Course Create Request.
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUpRequest {

    @NotNull
    private RoleDTO role;

    @NotBlank
    private String username;

    @NotBlank
    private String email;

    @NotBlank
    private String password;

}

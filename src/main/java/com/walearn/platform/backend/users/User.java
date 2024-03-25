package com.walearn.platform.backend.users;


import com.walearn.platform.backend.common.domain.AggregateRoot;
import com.walearn.platform.backend.users.registration.UserRegistrationCommand;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collections;

/**
 * Represents User domain model.
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "app_user")
public class User implements AggregateRoot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;
    private String email;
    private String password;
    private Role role;

    public User(UserRegistrationCommand command, PasswordEncoder passwordEncoder) {
        this.username = command.getUsername();
        this.email = command.getEmail();
        this.password = passwordEncoder.encode(command.getPassword());
        this.role = Role.from(command.getRole());
    }

    public UserDTO toDTO() {
        return UserDTO.builder()
                .username(username)
                .email(email)
                .role(role.toDTO())
                .build();
    }

    public UserDetails toUserDetails() {
        return org.springframework.security.core.userdetails.User
                .withUsername(username)
                .password(password)
                .authorities(Collections.singletonList(role))
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(false)
                .build();
    }
}

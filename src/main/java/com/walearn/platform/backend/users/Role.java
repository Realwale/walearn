package com.walearn.platform.backend.users;

import org.springframework.security.core.GrantedAuthority;

/**
 * Represents possible roles in the system.
 */
public enum Role implements GrantedAuthority {

    ROLE_ADMIN,
    ROLE_STUDENT,
    ROLE_TEACHER;

    public static Role from(RoleDTO role) {
        return switch (role) {
            case ROLE_STUDENT -> ROLE_STUDENT;
            case ROLE_TEACHER -> ROLE_TEACHER;
        };

    }

    public String getAuthority() {
        return name();
    }

    public RoleDTO toDTO() {
        return switch (this) {
            case ROLE_STUDENT -> RoleDTO.ROLE_STUDENT;
            case ROLE_TEACHER -> RoleDTO.ROLE_TEACHER;
            default -> null;
        };

    }
}

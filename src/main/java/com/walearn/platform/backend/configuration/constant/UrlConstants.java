package com.walearn.platform.backend.configuration.constant;

public class UrlConstants {

    public static final String[] WHITE_LIST_URLS = new String[]{
            "/",
            "/api/v1/auth/**",
            "/v3/api-docs.yaml",
            "/v3/api-docs/**",
            "/swagger-ui/**",
            "/webjars/**",
            "/swagger-ui.html",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/api/v1/account/registration/verify",
            "/api/v1/account/registration/resend-link",
            "/users/sign-up",
            "/users/sign-in",
            "/api/v1/reset-password/init",
            "/api/v1/reset-password/verify",
            "/api/v1/reset-password/complete",
            "/api/v1/account/refresh-token"

    };

    public static final String[] ADMIN_ONLY_URLS = new String[]{

    };

    public static final String ADMIN_AUTHORITY = "ADMIN";

}

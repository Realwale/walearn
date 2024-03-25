package com.walearn.platform.backend.users.response;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class APIResponse {

    private String status;
    private String message;
    private Object data;
}

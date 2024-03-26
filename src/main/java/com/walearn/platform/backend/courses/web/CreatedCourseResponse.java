package com.walearn.platform.backend.courses.web;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

/**
 * Represents Course API DTO which used as response for create operation.
 */
@Builder
@Data
@AllArgsConstructor
public class CreatedCourseResponse {

    private final UUID uuid;

}

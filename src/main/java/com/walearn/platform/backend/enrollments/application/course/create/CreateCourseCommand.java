package com.walearn.platform.backend.enrollments.application.course.create;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

/**
 * Represents Create Course Command.
 */
@Data
@AllArgsConstructor
public class CreateCourseCommand {

    private final UUID uuid;

}

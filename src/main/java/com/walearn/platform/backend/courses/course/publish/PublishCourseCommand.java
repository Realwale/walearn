package com.walearn.platform.backend.courses.course.publish;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

/**
 * Publish course command.
 */
@Data
@AllArgsConstructor
public class PublishCourseCommand {

    private final UUID uuid;

}

package com.walearn.platform.backend.courses.course.query;

import java.util.UUID;

import lombok.Value;

/**
 * Represents course query for retrieving course by uuid.
 */
@Value
public class CourseByUUIDQuery {

	UUID uuid;
}

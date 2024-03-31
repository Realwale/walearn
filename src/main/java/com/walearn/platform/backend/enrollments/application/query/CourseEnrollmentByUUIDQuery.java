package com.walearn.platform.backend.enrollments.application.query;

import java.util.UUID;

import lombok.Value;

/**
 * Represents course enrollment query for retrieving course enrollment by uuid.
 */
@Value
public class CourseEnrollmentByUUIDQuery {

	UUID uuid;
}

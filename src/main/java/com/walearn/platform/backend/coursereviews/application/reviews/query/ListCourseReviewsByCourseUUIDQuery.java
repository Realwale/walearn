package com.walearn.platform.backend.coursereviews.application.reviews.query;

import java.util.UUID;

import lombok.Value;

/**
 * Represents list course reviews by course uuid query.
 */
@Value
public class ListCourseReviewsByCourseUUIDQuery {

	UUID uuid;
}

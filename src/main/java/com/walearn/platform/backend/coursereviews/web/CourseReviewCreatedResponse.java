package com.walearn.platform.backend.coursereviews.web;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

/**
 * Represents response model for new created course review.
 */
@Builder
@Data
@AllArgsConstructor
public class CourseReviewCreatedResponse {

    private final UUID uuid;

}

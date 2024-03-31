package com.walearn.platform.backend.coursereviews.application.reviews;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;


/**
 * Represents course review dto.
 */
@Builder
@AllArgsConstructor
@Value
public class CourseReviewDTO {

	 UUID uuid;
	 UUID course;
	 String username;
	 String comment;
	 double rating;

}

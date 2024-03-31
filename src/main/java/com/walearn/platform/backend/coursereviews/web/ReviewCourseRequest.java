package com.walearn.platform.backend.coursereviews.web;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

/**
 * Represents review course request.
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewCourseRequest {

    @Max(5)
    @PositiveOrZero
    @NotNull
    private Double rating;
    private String comment;

}

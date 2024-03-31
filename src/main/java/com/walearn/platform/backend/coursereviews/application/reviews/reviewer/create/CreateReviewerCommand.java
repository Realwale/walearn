package com.walearn.platform.backend.coursereviews.application.reviews.reviewer.create;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Represents Create Reviewer Command.
 */
@Data
@AllArgsConstructor
public class CreateReviewerCommand {

    private final String username;

}

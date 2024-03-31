package com.walearn.platform.backend.coursereviews.application.reviews.reviewer.create;


import com.walearn.platform.backend.coursereviews.application.reviews.reviewer.Reviewer;
import com.walearn.platform.backend.coursereviews.application.reviews.reviewer.ReviewerRepository;
import lombok.RequiredArgsConstructor;

import org.axonframework.commandhandling.CommandHandler;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Command handler for {@link CreateReviewerCommand} creates a reviewer.
 */
@RequiredArgsConstructor
@Component
@Transactional
public class CreateReviewerCommandHandler {

    private final ReviewerRepository reviewerRepository;

    /**
     * Creates reviewer from command.
     *
     * @param command command
     */
    @CommandHandler
    public void handle(CreateReviewerCommand command) {
        final Reviewer reviewer = new Reviewer(command);
        reviewerRepository.save(reviewer);
    }
}

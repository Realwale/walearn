package com.walearn.platform.backend.coursereviews.application.reviews.create;


import com.walearn.platform.backend.coursereviews.application.reviews.CourseReview;
import com.walearn.platform.backend.coursereviews.application.reviews.CourseReviewFactory;
import com.walearn.platform.backend.coursereviews.application.reviews.CourseReviewRepository;
import lombok.RequiredArgsConstructor;

import org.axonframework.commandhandling.CommandHandler;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import jakarta.validation.ConstraintViolationException;
import java.util.UUID;

/**
 * Command handler for {@link ReviewCourseCommand} creates a course review.
 */
@RequiredArgsConstructor
@Component
@Transactional
public class ReviewCourseCommandHandler {

    private final CourseReviewRepository courseReviewRepository;
    private final CourseReviewFactory courseReviewFactory;

    /**
     * Creates course review from command.
     *
     * @param command command
     * @return uuid
     * @throws ConstraintViolationException          in the case of validation issues
     */


    @CommandHandler
    @NonNull
    public UUID handle(ReviewCourseCommand command) {
        final CourseReview courseReview = courseReviewFactory.createFrom(command);
        courseReviewRepository.save(courseReview);

        return courseReview.toIdentifier();
    }

}

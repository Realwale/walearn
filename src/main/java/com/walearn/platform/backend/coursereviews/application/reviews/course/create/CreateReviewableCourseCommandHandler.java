package com.walearn.platform.backend.coursereviews.application.reviews.course.create;



import com.walearn.platform.backend.coursereviews.application.reviews.course.ReviewableCourse;
import com.walearn.platform.backend.coursereviews.application.reviews.course.ReviewableCourseRepository;
import lombok.RequiredArgsConstructor;

import org.axonframework.commandhandling.CommandHandler;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Command handler for {@link CreateReviewableCourseCommand} creates a reviewable course.
 */
@RequiredArgsConstructor
@Component
@Transactional
public class CreateReviewableCourseCommandHandler {

    private final ReviewableCourseRepository reviewableCourseRepository;

    /**
     * Creates reviewable course from command.
     *
     * @param command command
     */
    @CommandHandler
    public void handle(CreateReviewableCourseCommand command) {
        final ReviewableCourse reviewableCourse = new ReviewableCourse(command);
        reviewableCourseRepository.save(reviewableCourse);
    }
}

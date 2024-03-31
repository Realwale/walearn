package com.walearn.platform.backend.coursereviews.application.reviews;


import com.walearn.platform.backend.common.exception.RelatedResourceIsNotResolvedException;
import com.walearn.platform.backend.coursereviews.application.reviews.course.ReviewableCourseRepository;
import com.walearn.platform.backend.coursereviews.application.reviews.create.ReviewCourseCommand;
import jakarta.validation.ConstraintViolation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import java.util.Set;

/**
 * Represents Course Review Factory.
 */
@RequiredArgsConstructor
@Component
public class CourseReviewFactory {

    private final Validator validator;
    private final CurrentUserAsReviewer currentUserAsReviewer;
    private final ReviewableCourseRepository reviewableCourseRepository;

    /**
     * Creates course review from command.
     *
     * @param reviewCourseCommand review course command
     * @return course review
     * @throws ConstraintViolationException          in the case of validation issues
     * @throws RelatedResourceIsNotResolvedException if course or reviewer is not found by relation
     */
    public CourseReview createFrom(ReviewCourseCommand reviewCourseCommand) {
        final Set<ConstraintViolation<ReviewCourseCommand>> violations = validator.validate(reviewCourseCommand);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }

        var course = reviewableCourseRepository.findByOriginalCourseId(reviewCourseCommand.getCourseId())
                .orElseThrow(() -> new RelatedResourceIsNotResolvedException("Course cannot be found by uuid = " + reviewCourseCommand.getCourseId()));

        var reviewer = currentUserAsReviewer.userAsReviewer();

        return new CourseReview(reviewCourseCommand, course, reviewer);
    }

}


package com.walearn.platform.backend.coursereviews.application.reviews;





import com.walearn.platform.backend.common.domain.AggregateRoot;
import com.walearn.platform.backend.coursereviews.application.reviews.course.ReviewableCourse;
import com.walearn.platform.backend.coursereviews.application.reviews.create.ReviewCourseCommand;
import com.walearn.platform.backend.coursereviews.application.reviews.edit.UpdateCourseReviewCommand;
import com.walearn.platform.backend.coursereviews.application.reviews.reviewer.Reviewer;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

/**
 * Represents Course Review domain model.
 */
@Entity
@Getter
@Setter
public class CourseReview implements AggregateRoot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private UUID uuid;

    @ManyToOne
    @JoinColumn(name = "reviewer_id")
    private Reviewer reviewer;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private ReviewableCourse course;

    private CourseRating rating;
    private Comment comment;

    // for JPA
    public CourseReview() {
    }

    public CourseReview(ReviewCourseCommand command, ReviewableCourse course, Reviewer reviewer) {
        this.uuid = UUID.randomUUID();
        this.course = course;
        this.reviewer = reviewer;
        this.rating = new CourseRating(command.getRating());
        this.comment = new Comment(command.getComment());
    }

    public void update(UpdateCourseReviewCommand command) {
        this.rating = new CourseRating(command.getRating());
        this.comment = new Comment(command.getComment());
    }

    public UUID toIdentifier() {
        return this.uuid;
    }
}


package com.walearn.platform.backend.coursereviews.application.reviews.course;



import com.walearn.platform.backend.common.domain.AggregateRoot;
import com.walearn.platform.backend.coursereviews.application.reviews.course.create.CreateReviewableCourseCommand;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

import java.util.UUID;

/**
 * Represents Reviewable Course domain model.
 */
@Entity
@Getter
public class ReviewableCourse implements AggregateRoot {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private UUID originalCourseId;

    // for JPA
    public ReviewableCourse() {
    }

    public ReviewableCourse(CreateReviewableCourseCommand createReviewableCourseCommand) {
        this.originalCourseId = createReviewableCourseCommand.getUuid();
    }

}

package com.walearn.platform.backend.enrollments.application.course;



import com.walearn.platform.backend.common.domain.AggregateRoot;
import com.walearn.platform.backend.enrollments.application.course.create.CreateCourseCommand;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

import java.util.UUID;

/**
 * Represents course domain model.
 */
@Entity(name = "enroll_course")
@Getter
public class EnrollCourse implements AggregateRoot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private UUID uuid;

    // for JPA
    public EnrollCourse() {

    }

    public EnrollCourse(CreateCourseCommand createCourseCommand) {
        this.uuid = createCourseCommand.getUuid();
    }

    public UUID toReference() {
        return uuid;
    }
}

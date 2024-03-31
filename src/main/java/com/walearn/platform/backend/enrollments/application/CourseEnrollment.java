package com.walearn.platform.backend.enrollments.application;



import com.walearn.platform.backend.common.domain.AggregateRoot;
import com.walearn.platform.backend.enrollments.application.course.EnrollCourse;
import com.walearn.platform.backend.enrollments.application.student.Student;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

/**
 * Represents course enrollment domain model.
 */
@Entity
@Getter
@AllArgsConstructor
public class CourseEnrollment implements AggregateRoot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private UUID uuid;

//    private Integer course;
//
//    private Integer student;

    private CompletionStatus completionStatus;

    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    private EnrollCourse course;

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;

    // for JPA
    public CourseEnrollment() {
    }

    public CourseEnrollment(EnrollCourse course, Student student) {
        this.uuid = UUID.randomUUID();
        this.completionStatus = CompletionStatus.IN_PROGRESS;
        this.course = course;
        this.student = student;
    }

    public void complete() {
        this.completionStatus = CompletionStatus.COMPLETED;
    }



    //    public CourseEnrollment(Integer course, Integer student) {
//        this.uuid = UUID.randomUUID();
//        this.course = course;
//        this.student = student;
//        this.completionStatus = CompletionStatus.IN_PROGRESS;
//    }



}

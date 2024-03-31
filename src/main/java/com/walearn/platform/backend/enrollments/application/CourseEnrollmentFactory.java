package com.walearn.platform.backend.enrollments.application;



import com.walearn.platform.backend.common.exception.RelatedResourceIsNotResolvedException;
import com.walearn.platform.backend.enrollments.application.course.EnrollCourse;
import com.walearn.platform.backend.enrollments.application.course.EnrollCourseRepository;
import com.walearn.platform.backend.enrollments.application.register.RegisterStudentToCourseCommand;
import com.walearn.platform.backend.enrollments.application.student.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import java.util.Set;

/**
 * Represents course enrollment factory.
 */
@RequiredArgsConstructor
@Component
public class CourseEnrollmentFactory {

    private final Validator validator;
    private final EnrollCourseRepository courseRepository;
    private final CurrentUserAsStudent currentUserAsStudent;

    /**
     * Creates course enrollment from command.
     *
     * @param command command.
     * @return course enrollment.
     * @throws ConstraintViolationException          in the case of validation issues
     * @throws RelatedResourceIsNotResolvedException if student or course is not found by id
     */
    public CourseEnrollment createFrom(RegisterStudentToCourseCommand command) {
        final Set<ConstraintViolation<RegisterStudentToCourseCommand>> violations = validator.validate(command);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }

        final EnrollCourse course = courseRepository.findByUuid(command.getCourseId())
                .orElseThrow(() -> new RelatedResourceIsNotResolvedException("Course cannot be found by uuid = " + command.getCourseId()));

        final Student student = currentUserAsStudent.userAsStudent();

        return new CourseEnrollment(course, student);
    }
}

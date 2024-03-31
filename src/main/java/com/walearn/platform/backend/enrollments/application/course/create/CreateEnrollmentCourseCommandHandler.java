package com.walearn.platform.backend.enrollments.application.course.create;


import com.walearn.platform.backend.enrollments.application.course.EnrollCourse;
import com.walearn.platform.backend.enrollments.application.course.EnrollCourseRepository;
import lombok.RequiredArgsConstructor;

import org.axonframework.commandhandling.CommandHandler;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Command handler for {@link CreateCourseCommand} creates a course.
 */
@RequiredArgsConstructor
@Component
@Transactional
public class CreateEnrollmentCourseCommandHandler {

    private final EnrollCourseRepository courseRepository;

    /**
     * Creates course from command.
     *
     * @param command command
     */
    @CommandHandler
    public void handle(CreateCourseCommand command) {
        final EnrollCourse course = new EnrollCourse(command);
        courseRepository.save(course);
    }
}

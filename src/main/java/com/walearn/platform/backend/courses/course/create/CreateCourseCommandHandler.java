package com.walearn.platform.backend.courses.course.create;



import com.walearn.platform.backend.courses.course.Course;
import com.walearn.platform.backend.courses.course.CourseFactory;
import com.walearn.platform.backend.courses.course.CourseRepository;
import lombok.RequiredArgsConstructor;

import org.axonframework.commandhandling.CommandHandler;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import jakarta.validation.ConstraintViolationException;
import java.util.UUID;

/**
 * Command handler for {@link CreateCourseCommand} creates a course.
 */
@RequiredArgsConstructor
@Component
@Transactional
public class CreateCourseCommandHandler {

    private final CourseRepository courseRepository;
    private final CourseFactory courseFactory;

    /**
     * Creates course from command.
     *
     * @param command command
     * @throws ConstraintViolationException in the case of validation issues
     */
    // todo move to factory
    @CommandHandler
    @NonNull
    public UUID handle(CreateCourseCommand command) {
        final Course course = courseFactory.createFrom(command);
        courseRepository.save(course);

        return course.toIdentity();
    }

}

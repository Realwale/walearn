package com.walearn.platform.backend.courses.course.rating.update;

import com.walearn.platform.backend.common.exception.ResourceNotFoundException;
import com.walearn.platform.backend.courses.course.Course;
import com.walearn.platform.backend.courses.course.CourseRepository;
import lombok.RequiredArgsConstructor;

import org.axonframework.commandhandling.CommandHandler;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Command handler for {@link UpdateCourseRatingCommand} updates a rating course.
 */
@RequiredArgsConstructor
@Component
@Transactional
public class UpdateCourseRatingCommandHandler {

    private final CourseRepository repository;

    @CommandHandler
    public void handle(UpdateCourseRatingCommand command) {
        final Optional<Course> dbResult = repository.findByUuid(command.getUuid());
        if (dbResult.isEmpty()) {
            throw new ResourceNotFoundException(String.format("Course with uuid: %s not found", command.getUuid()));
        }

        final Course course = dbResult.get();
        course.updateRating(command.getRating());
        repository.save(course);
    }

}

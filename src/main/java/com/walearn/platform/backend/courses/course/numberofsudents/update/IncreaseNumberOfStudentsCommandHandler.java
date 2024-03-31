package com.walearn.platform.backend.courses.course.numberofsudents.update;



import com.walearn.platform.backend.common.exception.ResourceNotFoundException;
import com.walearn.platform.backend.courses.course.Course;
import com.walearn.platform.backend.courses.course.CourseRepository;
import lombok.RequiredArgsConstructor;

import org.axonframework.commandhandling.CommandHandler;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Command handler for {@link IncreaseNumberOfStudentsCommand} increases a number of students.
 */
@RequiredArgsConstructor
@Component
@Transactional
public class IncreaseNumberOfStudentsCommandHandler {

    private final CourseRepository repository;

    @CommandHandler
    public void handle(IncreaseNumberOfStudentsCommand command) {
        final Optional<Course> dbResult = repository.findByUuid(command.getUuid());
        if (dbResult.isEmpty()) {
            throw new ResourceNotFoundException(String.format("Course with uuid: %s not found", command.getUuid()));
        }

        final Course course = dbResult.get();
        course.increaseNumberOfStudents();
        repository.save(course);
    }

}

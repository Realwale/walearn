package com.walearn.platform.backend.enrollments.application.student.create;


import com.walearn.platform.backend.enrollments.application.student.Student;
import com.walearn.platform.backend.enrollments.application.student.StudentRepository;
import lombok.RequiredArgsConstructor;

import org.axonframework.commandhandling.CommandHandler;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Command handler for {@link CreateStudentCommand} creates a student.
 */
@RequiredArgsConstructor
@Component
@Transactional
public class CreateStudentCommandHandler {

    private final StudentRepository studentRepository;

    /**
     * Creates student from command.
     *
     * @param command command
     */
    @CommandHandler
    public void handle(CreateStudentCommand command) {
        final Student student = new Student(command);
        studentRepository.save(student);
    }
}

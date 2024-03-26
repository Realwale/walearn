package com.walearn.platform.backend.courses.teacher.create;

import com.walearn.platform.backend.courses.teacher.Teacher;
import com.walearn.platform.backend.courses.teacher.TeacherRepository;
import lombok.RequiredArgsConstructor;

import org.axonframework.commandhandling.CommandHandler;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Command handler for {@link CreateTeacherCommand} creates a teacher.
 */
@RequiredArgsConstructor
@Component
@Transactional
public class CreateTeacherCommandHandler {

    private final TeacherRepository teacherRepository;

    @CommandHandler
    public void handle(CreateTeacherCommand command) {
        teacherRepository.save(new Teacher(command));
    }

}

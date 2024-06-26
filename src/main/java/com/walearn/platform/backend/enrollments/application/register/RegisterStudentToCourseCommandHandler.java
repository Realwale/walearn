package com.walearn.platform.backend.enrollments.application.register;


import com.walearn.platform.backend.enrollments.application.CourseEnrollment;
import com.walearn.platform.backend.enrollments.application.CourseEnrollmentFactory;
import com.walearn.platform.backend.enrollments.application.CourseEnrollmentRepository;
import com.walearn.platform.backend.enrollments.application.CurrentUserAsStudent;
import com.walearn.platform.backend.enrollments.integration.event.StudentEnrolledToCourseIntegrationEvent;
import lombok.RequiredArgsConstructor;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventhandling.EventBus;
import org.axonframework.eventhandling.GenericEventMessage;
import org.springframework.lang.NonNull;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.Objects;
import java.util.UUID;

/**
 * Command handler for {@link RegisterStudentToCourseCommand} registers student to course.
 */
@RequiredArgsConstructor
@Component
@Transactional
public class RegisterStudentToCourseCommandHandler {

    private final TransactionTemplate transactionTemplate;
    private final CourseEnrollmentRepository courseEnrollmentRepository;
    private final CourseEnrollmentFactory courseEnrollmentFactory;
    private final CurrentUserAsStudent currentUserAsStudent;
    private final EventBus eventBus;

    /**
     * Creates course enrollment from command.
     *
     * @param command command
     */
    @CommandHandler
    @NonNull
    public UUID handle(RegisterStudentToCourseCommand command) {
        final CourseEnrollment courseEnrollment = transactionTemplate.execute(transactionStatus -> {
            final CourseEnrollment enrollment = courseEnrollmentFactory.createFrom(command);
            courseEnrollmentRepository.save(enrollment);

            return enrollment;
        });

        final UUID uuid = Objects.requireNonNull(courseEnrollment).getUuid();
        eventBus.publish(GenericEventMessage.asEventMessage(new StudentEnrolledToCourseIntegrationEvent(command.getCourseId(),
                currentUserAsStudent.userAsStudent().toReference())));

        return uuid;
    }

}

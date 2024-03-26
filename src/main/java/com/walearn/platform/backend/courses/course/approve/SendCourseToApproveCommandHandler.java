package com.walearn.platform.backend.courses.course.approve;


import com.walearn.platform.backend.common.exception.ResourceNotFoundException;
import com.walearn.platform.backend.courses.course.Course;
import com.walearn.platform.backend.courses.course.CourseRepository;
import com.walearn.platform.backend.courses.event.SendCourseToApproveIntegrationEvent;
import lombok.RequiredArgsConstructor;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventhandling.EventBus;
import org.axonframework.eventhandling.GenericEventMessage;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Command handler for {@link SendCourseToApproveCommand}, send a course to approve.
 */
@RequiredArgsConstructor
@Component
@Transactional
public class SendCourseToApproveCommandHandler {

    private final CourseRepository repository;
    private final EventBus eventBus;

    /**
     * Handles send course to approve command.
     *
     * @param command command
     * @throws ResourceNotFoundException      if resource not found
     */
    @CommandHandler
    public void handle(@P("c") SendCourseToApproveCommand command) {
        final Optional<Course> dbResult = repository.findByUuid(command.getUuid());
        if (dbResult.isEmpty()) {
            throw new ResourceNotFoundException(String.format("Course with uuid: %s not found", command.getUuid()));
        }

        final Course course = dbResult.get();
        course.sendToApprove();

        // todo integration event outside transaction
        eventBus.publish(GenericEventMessage.asEventMessage(new SendCourseToApproveIntegrationEvent(command.getUuid())));
    }
}

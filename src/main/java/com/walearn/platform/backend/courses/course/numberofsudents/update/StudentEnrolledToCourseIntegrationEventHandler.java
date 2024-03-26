package com.walearn.platform.backend.courses.course.numberofsudents.update;

import com.walearn.platform.backend.enrollments.integration.event.StudentEnrolledToCourseIntegrationEvent;
import lombok.RequiredArgsConstructor;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

/**
 * Event listener for {@link StudentEnrolledToCourseIntegrationEvent}.
 */
@Component
@RequiredArgsConstructor
public class StudentEnrolledToCourseIntegrationEventHandler {

    private final CommandGateway commandGateway;

    @EventHandler
    public void handleStudentEnrolledToCourseEvent(StudentEnrolledToCourseIntegrationEvent event) {
        commandGateway.send(new IncreaseNumberOfStudentsCommand(event.getCourseId()));
    }

}

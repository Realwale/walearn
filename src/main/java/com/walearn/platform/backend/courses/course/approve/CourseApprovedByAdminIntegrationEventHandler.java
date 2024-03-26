package com.walearn.platform.backend.courses.course.approve;


import com.walearn.platform.backend.administration.integration.event.CourseApprovedByAdminIntegrationEvent;
import lombok.RequiredArgsConstructor;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

/**
 * Event listener for {@link CourseApprovedByAdminIntegrationEvent}.
 */
@Component
@RequiredArgsConstructor
public class CourseApprovedByAdminIntegrationEventHandler {

    private final CommandGateway commandGateway;

    @EventHandler
    public void handleCourseApprovedByAdminEvent(CourseApprovedByAdminIntegrationEvent event) {
        commandGateway.send(new ApproveCourseCommand(event.getCourseId()));
    }

}

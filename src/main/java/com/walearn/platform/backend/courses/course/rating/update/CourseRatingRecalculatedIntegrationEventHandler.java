package com.walearn.platform.backend.courses.course.rating.update;


import com.walearn.platform.backend.coursereviews.integration.event.CourseRatingRecalculatedIntegrationEvent;
import lombok.RequiredArgsConstructor;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

/**
 * Event listener for {@link CourseRatingRecalculatedIntegrationEvent}.
 */
@Component
@RequiredArgsConstructor
public class CourseRatingRecalculatedIntegrationEventHandler {

    private final CommandGateway commandGateway;

    @EventHandler
    public void handleCourseRatingRecalculatedEvent(CourseRatingRecalculatedIntegrationEvent event) {
        commandGateway.send(new UpdateCourseRatingCommand(event.getCourseId(), event.getRating()));
    }

}

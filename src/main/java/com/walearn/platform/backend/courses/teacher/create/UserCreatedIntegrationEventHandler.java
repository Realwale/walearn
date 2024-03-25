package com.walearn.platform.backend.courses.teacher.create;

import com.walearn.platform.backend.users.event.UserCreatedIntegrationEvent;
import lombok.RequiredArgsConstructor;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

/**
 * Event listener for {@link UserCreatedIntegrationEvent}.
 */
// todo should be transactional?
@Component
@RequiredArgsConstructor
public class UserCreatedIntegrationEventHandler {

    private final CommandGateway commandGateway;

    @EventHandler
    public void handleUserCreatedEvent(UserCreatedIntegrationEvent event) {
        commandGateway.send(new CreateTeacherCommand(event.getUsername()));
    }

}

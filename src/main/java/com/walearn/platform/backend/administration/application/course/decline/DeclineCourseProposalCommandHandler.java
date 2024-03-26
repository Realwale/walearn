package com.walearn.platform.backend.administration.application.course.decline;


import com.walearn.platform.backend.administration.application.course.CourseProposal;
import com.walearn.platform.backend.administration.application.course.CourseProposalDTO;
import com.walearn.platform.backend.administration.application.course.CourseProposalRepository;
import com.walearn.platform.backend.administration.integration.event.CourseDeclinedByAdminIntegrationEvent;
import com.walearn.platform.backend.common.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventhandling.EventBus;
import org.axonframework.eventhandling.GenericEventMessage;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.Objects;
import java.util.Optional;

/**
 * Command handler for {@link DeclineCourseProposalCommand} declines a course proposal.
 */
@RequiredArgsConstructor
@Component
public class DeclineCourseProposalCommandHandler {

    private final TransactionTemplate transactionTemplate;
    private final CourseProposalRepository repository;
    private final EventBus eventBus;

    /**
     * Handles decline course proposal command. Declines and save declined course proposal
     *
     * @param command command
     * @throws ResourceNotFoundException              if resource not found
     */


    @CommandHandler
    public void handle(DeclineCourseProposalCommand command) {
        final CourseProposal proposal = transactionTemplate.execute(transactionStatus -> {
            final Optional<CourseProposal> dbResult = repository.findByUuid(command.getUuid());
            if (dbResult.isEmpty()) {
                throw new ResourceNotFoundException(String.format("Course Proposal with uuid: %s not found", command.getUuid()));
            }
            final CourseProposal courseProposal = dbResult.get();

            courseProposal.decline();
            repository.save(courseProposal);

            return courseProposal;
        });

        final CourseProposalDTO dto = Objects.requireNonNull(proposal).toDTO();
        eventBus.publish(GenericEventMessage.asEventMessage(new CourseDeclinedByAdminIntegrationEvent(dto.getUuid())));
    }

}

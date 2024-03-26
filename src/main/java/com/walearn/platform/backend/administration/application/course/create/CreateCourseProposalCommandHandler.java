package com.walearn.platform.backend.administration.application.course.create;


import com.walearn.platform.backend.administration.application.course.CourseProposal;
import com.walearn.platform.backend.administration.application.course.CourseProposalRepository;
import lombok.RequiredArgsConstructor;

import org.axonframework.commandhandling.CommandHandler;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Command handler for {@link CreateCourseProposalCommand} creates a course proposal.
 */
@RequiredArgsConstructor
@Component
@Transactional
public class CreateCourseProposalCommandHandler {

    private final CourseProposalRepository courseProposalRepository;

    /**
     * Creates course proposal from command.
     *
     * @param command command
     */
    @CommandHandler
    public void handle(CreateCourseProposalCommand command) {
        final CourseProposal courseProposal = new CourseProposal(command);
        courseProposalRepository.save(courseProposal);
    }

}

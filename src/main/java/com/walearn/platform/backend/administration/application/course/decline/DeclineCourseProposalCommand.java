package com.walearn.platform.backend.administration.application.course.decline;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

/**
 * Decline course proposal command.
 */
@Data
@AllArgsConstructor
public class DeclineCourseProposalCommand {

    private final UUID uuid;

}

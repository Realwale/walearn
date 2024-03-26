package com.walearn.platform.backend.administration.application.course.create;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

/**
 * Represents Create Course Proposal Command.
 */
@Data
@AllArgsConstructor
public class CreateCourseProposalCommand {

    private final UUID uuid;

}

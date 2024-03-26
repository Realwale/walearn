package com.walearn.platform.backend.administration.application.course;

import java.util.UUID;

/**
 * Course proposal already approved exception because course proposal is already approved.
 */
public class CourseProposalAlreadyApprovedException extends RuntimeException {

    private final UUID uuid;

    public CourseProposalAlreadyApprovedException(UUID uuid) {
        super();
        this.uuid = uuid;
    }

    @Override
    public String getMessage() {
        return "Course Proposal with uuid = " + uuid + " cannot be approved, course proposal was already approved";
    }
}

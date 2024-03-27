package com.walearn.platform.backend.administration.application.course;



import com.walearn.platform.backend.administration.application.course.create.CreateCourseProposalCommand;
import com.walearn.platform.backend.common.domain.AggregateRoot;
import com.walearn.platform.backend.common.exception.CourseProposalAlreadyApprovedException;
import com.walearn.platform.backend.common.exception.CourseProposalAlreadyDeclinedException;
import jakarta.persistence.*;
import java.util.UUID;

/**
 * Represents Course Proposal domain model.
 */
@Entity
public class CourseProposal implements AggregateRoot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private UUID uuid;

    @Enumerated(EnumType.STRING)
    private CourseProposalStatus status;

    // for JPA
    public CourseProposal() {

    }

    public CourseProposal(CreateCourseProposalCommand command) {
        this.uuid = command.getUuid();
        this.status = CourseProposalStatus.WAITING_FOR_APPROVAL;
    }

    public void approve() {
        if (status == CourseProposalStatus.APPROVED) {
            throw new CourseProposalAlreadyApprovedException(uuid);
        }
        this.status = CourseProposalStatus.APPROVED;
    }

    public void decline() {
        if (status == CourseProposalStatus.DECLINED) {
            throw new CourseProposalAlreadyDeclinedException(uuid);
        }
        this.status = CourseProposalStatus.DECLINED;
    }

    public CourseProposalDTO toDTO() {
        return CourseProposalDTO.builder()
                .uuid(uuid)
                .status(status.toDTO())
                .build();
    }
}

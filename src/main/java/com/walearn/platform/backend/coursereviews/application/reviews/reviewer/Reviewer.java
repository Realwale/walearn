package com.walearn.platform.backend.coursereviews.application.reviews.reviewer;




import com.walearn.platform.backend.common.domain.AggregateRoot;
import com.walearn.platform.backend.coursereviews.application.reviews.reviewer.create.CreateReviewerCommand;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

/**
 * Represents Reviewer domain model.
 */
@Entity
@Getter
public class Reviewer implements AggregateRoot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;

    // for JPA
    public Reviewer() {
    }

    public Reviewer(CreateReviewerCommand createReviewerCommand) {
        this.username = createReviewerCommand.getUsername();
    }

}

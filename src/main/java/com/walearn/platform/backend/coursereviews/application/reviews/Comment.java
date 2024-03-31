package com.walearn.platform.backend.coursereviews.application.reviews;


import com.walearn.platform.backend.common.domain.ValueObject;
import lombok.*;

import jakarta.persistence.Embeddable;

/**
 * Represents Comment model.
 */
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class Comment implements ValueObject {

    private String comment;

}

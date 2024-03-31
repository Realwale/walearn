package com.walearn.platform.backend.courses.course;


import com.walearn.platform.backend.common.domain.ValueObject;
import lombok.*;

import jakarta.persistence.Embeddable;

/**
 * Represents number of students model.
 */
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class NumberOfStudents implements ValueObject {

    private int number;

}

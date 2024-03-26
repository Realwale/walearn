package com.walearn.platform.backend.courses.teacher;



import com.walearn.platform.backend.common.domain.AggregateRoot;
import com.walearn.platform.backend.courses.teacher.create.CreateTeacherCommand;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

/**
 * Represents Teacher model.
 */
@Entity
@Getter
public class Teacher implements AggregateRoot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;

    // for JPA
    public Teacher() {

    }

    public Teacher(CreateTeacherCommand command) {
        this.username = command.getUsername();
    }

    public String toIdentity() {
        return username;
    }
}

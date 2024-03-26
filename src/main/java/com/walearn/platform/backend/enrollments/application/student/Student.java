package com.walearn.platform.backend.enrollments.application.student;



import com.walearn.platform.backend.common.domain.AggregateRoot;
import com.walearn.platform.backend.enrollments.application.student.create.CreateStudentCommand;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

/**
 * Represents student domain model.
 */
@Entity
@Getter
public class Student implements AggregateRoot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;

    // for JPA
    public Student() {
    }

    public Student(CreateStudentCommand createStudentCommand) {
        this.username = createStudentCommand.getUsername();
    }

    public String toReference() {
        return username;
    }
}

package com.walearn.platform.backend.enrollments.application.student;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Represents student repository.
 */
public interface StudentRepository extends JpaRepository<Student, Integer> {

    /**
     * Retrieves a student by its username.
     *
     * @param username must not be {@literal null}.
     * @return the student with the given username.
     * @throws IllegalArgumentException if {@literal username} is {@literal null}.
     */
    Student findByUsername(String username);

}

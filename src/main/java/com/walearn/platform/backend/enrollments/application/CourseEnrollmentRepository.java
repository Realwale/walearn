package com.walearn.platform.backend.enrollments.application;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Represents course enrollment repository.
 */
public interface CourseEnrollmentRepository extends JpaRepository<CourseEnrollment, Integer> {

	/**
	 * Retrieves a course enrollment by its uuid.
	 *
	 * @param uuid must not be {@literal null}.
	 * @return the course enrollment with the given uuid or {@literal Optional#empty()} if none found.
	 * @throws IllegalArgumentException if {@literal uuid} is {@literal null}.
	 */
	Optional<CourseEnrollment> findByUuid(UUID uuid);

	/**
	 * Retrieves a course enrollment dto by its uuid.
	 *
	 * @param uuid    must not be {@literal null}.
	 * @param student student must not be {@literal null}.
	 * @return the course enrollment dto with the given uuid or {@literal Optional#empty()} if none found.
	 * @throws IllegalArgumentException if {@literal uuid} is {@literal null}.
	 */
	@Query("SELECT new com.walearn.platform.backend.enrollments.application.CourseEnrollmentDTO(ce.uuid, ec.uuid, s.username, ce.completionStatus) " +
			"FROM CourseEnrollment ce " +
			"JOIN ce.course ec " +
			"JOIN ce.student s " +
			"WHERE ce.uuid = :uuid AND s.username = :student")
	Optional<CourseEnrollmentDTO> query(@Param("uuid") UUID uuid, @Param("student") String student);

	/**
	 * Retrieves course enrollment dtos.
	 *
	 * @param student student must not be {@literal null}.
	 * @return the course enrollment dto with the given uuid or {@literal Optional#empty()} if none found.
	 * @throws IllegalArgumentException if {@literal uuid} is {@literal null}.
	 */
	@Query("SELECT new com.walearn.platform.backend.enrollments.application.CourseEnrollmentDTO(ce.uuid, ec.uuid, s.username, ce.completionStatus) " +
			"FROM CourseEnrollment ce " +
			"JOIN ce.course ec " +
			"JOIN ce.student s " +
			"WHERE s.username = :student")
	List<CourseEnrollmentDTO> query(@Param("student") String student);

}

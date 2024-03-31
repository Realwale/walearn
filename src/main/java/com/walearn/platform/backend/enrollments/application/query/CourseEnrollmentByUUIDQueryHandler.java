package com.walearn.platform.backend.enrollments.application.query;

import java.util.Optional;

import com.walearn.platform.backend.enrollments.application.CourseEnrollmentDTO;
import com.walearn.platform.backend.enrollments.application.CourseEnrollmentRepository;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.lang.NonNull;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;



import lombok.RequiredArgsConstructor;

/**
 * Query handler for getting the course enrollment by uuid.
 */
@RequiredArgsConstructor
@Component
public class CourseEnrollmentByUUIDQueryHandler {

	private final CourseEnrollmentRepository repository;

	/**
	 * Retrieves course enrollment by uuid.
	 *
	 * @param query query.
	 * @return corresponding course enrollment dto.
	 */
//	@QueryHandler
//	@NonNull
//	public Optional<CourseEnrollmentDTO> handle(CourseEnrollmentByUUIDQuery query) {
//		var principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		var username = principal.getUsername();
//
//		return repository.query(query.getUuid(), username);
//	}

}

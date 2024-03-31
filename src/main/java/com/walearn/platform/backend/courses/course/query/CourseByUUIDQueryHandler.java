package com.walearn.platform.backend.courses.course.query;

import java.util.Optional;

import com.walearn.platform.backend.courses.course.CourseDTO;
import com.walearn.platform.backend.courses.course.CourseRepository;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;




import lombok.RequiredArgsConstructor;

/**
 * Query handler for getting the course by uuid.
 */
@RequiredArgsConstructor
@Component
public class CourseByUUIDQueryHandler {

	private final CourseRepository repository;

	/**
	 * Retrieves course by uuid.
	 *
	 * @param query query.
	 * @return corresponding course dto.
	 */
	@QueryHandler
	@NonNull
	public Optional<CourseDTO> handle(CourseByUUIDQuery query) {
		return repository.findDTOByUuid(query.getUuid());
	}

}

package com.walearn.platform.backend.administration.application.course.query;

import java.util.List;

import com.walearn.platform.backend.administration.application.course.CourseProposalDTO;
import com.walearn.platform.backend.administration.application.course.CourseProposalRepository;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;


import lombok.RequiredArgsConstructor;

/**
 * Query handler for getting the course proposals by uuid.
 */
@RequiredArgsConstructor
@Component
public class ListCourseProposalsQueryHandler {

	private final CourseProposalRepository repository;

	/**
	 * Retrieves course proposals.
	 *
	 * @param query query.
	 * @return course proposals.
	 */
	@QueryHandler
	@NonNull
	public List<CourseProposalDTO> handle(ListCourseProposalsQuery query) {
		return repository.listCourseProposals();
	}

}

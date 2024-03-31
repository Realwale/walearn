package com.walearn.platform.backend.courses.course.create;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class CreateCurriculumItemCommand {

	private final String title;
	private final String description;
	private final Integer serialNumber;

}

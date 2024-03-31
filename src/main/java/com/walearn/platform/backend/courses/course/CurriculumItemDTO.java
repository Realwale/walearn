package com.walearn.platform.backend.courses.course;

import java.util.UUID;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class CurriculumItemDTO {

	public static final String TYPE = "curriculumItems_type";
	public static final String TITLE = "curriculumItems_title";
	public static final String DESCRIPTION = "curriculumItems_description";
	public static final String SERIAL_NUMBER = "curriculumItems_serialNumber";

	UUID uuid;
	String title, description;
	Integer serialNumber;

}

package com.walearn.platform.backend.courses.course;

import com.walearn.platform.backend.courses.course.create.CreateCurriculumItemCommand;
import com.walearn.platform.backend.courses.course.create.CreateLectureCommand;
import com.walearn.platform.backend.courses.course.create.CreateQuizCommand;
import jakarta.validation.ConstraintViolationException;





/**
 * Represents Curriculum Item Factory.
 */
public class CurriculumItemFactory {

	/**
	 * Creates course from command.
	 *
	 * @param createCurriculumItemCommand course command
	 * @return course
	 * @throws ConstraintViolationException in the case of validation issues
	 */
	public static CurriculumItem createFrom(CreateCurriculumItemCommand createCurriculumItemCommand, Course course) {
		if (createCurriculumItemCommand instanceof CreateLectureCommand) {
			return new Lecture((CreateLectureCommand) createCurriculumItemCommand, createCurriculumItemCommand.getSerialNumber(), course);
		} else if (createCurriculumItemCommand instanceof CreateQuizCommand) {
			return new Quiz((CreateQuizCommand) createCurriculumItemCommand, createCurriculumItemCommand.getSerialNumber(), course);
		}

		return null;
	}

}

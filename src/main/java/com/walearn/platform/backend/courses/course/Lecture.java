package com.walearn.platform.backend.courses.course;

import com.walearn.platform.backend.courses.course.create.CreateLectureCommand;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;



@Entity
@DiscriminatorValue("Lecture")
public class Lecture extends CurriculumItem {

	private String content;

	// for JPA
	public Lecture() {
		super();
	}

	public Lecture(CreateLectureCommand command, Integer serialNumber, Course course) {
		super(command.getTitle(), command.getDescription(), course, serialNumber);
		this.content = command.getText();
	}
}


package com.walearn.platform.backend.courses.course.publish;


import com.walearn.platform.backend.courses.course.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * Represents the logic for checking if user is a teacher of course
 */
@RequiredArgsConstructor
@Component
public class CourseTeacherChecker {

    private final CourseRepository courseRepository;

    public boolean hasAccess(Authentication authentication, UUID courseId) {
        return courseRepository.isTeacher(courseId, authentication.getName());
    }

}

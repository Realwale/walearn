package com.walearn.platform.backend.courses.course;



import com.walearn.platform.backend.courses.teacher.Teacher;
import com.walearn.platform.backend.courses.teacher.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

/**
 * Represents the logic for retrieving the teacher entity from database for current authenticated user.
 */
@RequiredArgsConstructor
@Component
public class CurrentUserAsTeacher {

    private final TeacherRepository teacherRepository;

    /**
     * Represents current user as teacher.
     *
     * @return teacher.
     */
    public Teacher userAsTeacher() {
        var principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        var username = principal.getUsername();

        return teacherRepository.findByUsername(username);
    }

}

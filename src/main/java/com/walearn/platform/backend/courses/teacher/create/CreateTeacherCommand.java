package com.walearn.platform.backend.courses.teacher.create;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Create teacher command.
 */
@Data
@AllArgsConstructor
public class CreateTeacherCommand {

    private final String username;

}

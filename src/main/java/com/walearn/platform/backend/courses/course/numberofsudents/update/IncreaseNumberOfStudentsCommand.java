package com.walearn.platform.backend.courses.course.numberofsudents.update;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

/**
 * Increase number of students command.
 */
@Data
@RequiredArgsConstructor
public class IncreaseNumberOfStudentsCommand {

    private final UUID uuid;

}

package com.walearn.platform.backend.enrollments.application;

/**
 * Represents possible values for completion status of enrollment
 */
public enum CompletionStatus {

    IN_PROGRESS,
    COMPLETED;

    public CompletionStatusDTO toDTO() {
        return switch (this) {
            case IN_PROGRESS -> CompletionStatusDTO.IN_PROGRESS;
            case COMPLETED -> CompletionStatusDTO.COMPLETED;
        };

    }
}

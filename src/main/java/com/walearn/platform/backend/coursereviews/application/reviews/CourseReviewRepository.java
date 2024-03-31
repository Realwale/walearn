package com.walearn.platform.backend.coursereviews.application.reviews;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Represents course review repository.
 */
public interface CourseReviewRepository extends JpaRepository<CourseReview, Integer> {

    /**
     * Retrieves a course review by its uuid.
     *
     * @param uuid must not be {@literal null}.
     * @return the course review with the given uuid or {@literal Optional#empty()} if none found.
     * @throws IllegalArgumentException if {@literal uuid} is {@literal null}.
     */
    Optional<CourseReview> findByUuid(UUID uuid);

    /**
     * Retrieves list of course reviews.
     *
     * @param uuid course uuid.
     * @return list of course reviews.
     */
    // todo uuid not used
    @Query("SELECT new com.walearn.platform.backend.coursereviews.application.reviews.CourseReviewDTO(cr.uuid, c.originalCourseId, r.username, cr.comment.comment, cr.rating.rating) " +
            "FROM CourseReview cr " +
            "JOIN cr.course c " +
            "JOIN cr.reviewer r " +
            "WHERE c.originalCourseId = :uuid")
    List<CourseReviewDTO> listCourseReviews(@Param("uuid") UUID uuid);


    /**
     * Checks if passed username is an username of reviewer of course review.
     *
     * @param uuid course review uuid.
     * @param username username.
     * @return true if reviewer, false if not.
     */
    @Query("SELECT COUNT(cr) > 0 FROM CourseReview cr WHERE cr.uuid = :uuid AND cr.reviewer.username = :username")
    boolean isReviewer(@Param("uuid") UUID uuid, @Param("username") String username);

}

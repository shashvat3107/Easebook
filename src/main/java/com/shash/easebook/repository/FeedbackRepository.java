package com.shash.easebook.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shash.easebook.entities.Feedback;


@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {

//    Optional<Feedback> findById(Long id);

    List<Feedback> findByUserId(Long userId);

    List<Feedback> findByAdId(Long adId);

    List<Feedback> findByRating(int rating);
    
    List<Feedback> findByRatingGreaterThan(int rating);
    
    List<Feedback> findByRatingLessThan(int rating);

    List<Feedback> findByReviewContainingIgnoreCase(String keyword);

}
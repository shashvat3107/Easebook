package com.shash.easebook.service;

import java.util.List;

import com.shash.easebook.dto.FeedbackResponseDTO;
import com.shash.easebook.entities.Feedback;

public interface FeedbackService {

    List<FeedbackResponseDTO> getAllFeedback();

    Feedback getFeedbackById(Long id);

    Feedback createFeedback(Feedback feedback);

    Feedback updateFeedback(Long id, Feedback feedback);

    void deleteFeedback(Long id);

    List<FeedbackResponseDTO> getFeedbackByUserId(Long userId);

    List<FeedbackResponseDTO> getFeedbackByAdId(Long adId);

    //Optional<FeedbackResponseDTO> getFeedbackByUserIdAndAdId(Long userId, Long adId);

    List<FeedbackResponseDTO> getFeedbackByRatingGreaterThan(int rating);

    List<FeedbackResponseDTO> getFeedbackByRatingLessThan(int rating);

    //List<FeedbackResponseDTO> getFeedbackByRatingBetween(int minRating, int maxRating);

    List<FeedbackResponseDTO> getFeedbackByReviewContaining(String keyword);
}


/*
public interface FeedbackService {

    List<FeedbackResponseDTO> getAllFeedback();

    Optional<FeedbackResponseDTO> getFeedbackById(Long id);

    FeedbackResponseDTO createFeedback(FeedbackDTO feedbackDTO);

    FeedbackResponseDTO updateFeedback(Long id, FeedbackDTO feedbackDTO);

    void deleteFeedback(Long id);

    List<FeedbackResponseDTO> getFeedbackByUserId(Long userId);

    List<FeedbackResponseDTO> getFeedbackByAdId(Long adId);

    //Optional<FeedbackResponseDTO> getFeedbackByUserIdAndAdId(Long userId, Long adId);

    List<FeedbackResponseDTO> getFeedbackByRatingGreaterThan(int rating);

    List<FeedbackResponseDTO> getFeedbackByRatingLessThan(int rating);

    //List<FeedbackResponseDTO> getFeedbackByRatingBetween(int minRating, int maxRating);

    List<FeedbackResponseDTO> getFeedbackByReviewContaining(String keyword);
} 

 */
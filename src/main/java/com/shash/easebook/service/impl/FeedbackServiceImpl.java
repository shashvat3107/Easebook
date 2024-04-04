package com.shash.easebook.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shash.easebook.dto.FeedbackResponseDTO;
import com.shash.easebook.entities.Ads;
import com.shash.easebook.entities.Feedback;
import com.shash.easebook.entities.User;
import com.shash.easebook.repository.AdsRepository;
import com.shash.easebook.repository.FeedbackRepository;
import com.shash.easebook.repository.UserRepository;
import com.shash.easebook.service.FeedbackService;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;

@Service
//@RequiredArgsConstructor
@AllArgsConstructor
public class FeedbackServiceImpl implements FeedbackService {

	@Autowired
	private final FeedbackRepository feedbackRepository;

	@Autowired
	private final UserRepository userRepository;
	@Autowired
	private final AdsRepository adsRepository;

//    private final UserService userService;
//    private final AdsService adsService;

	@Override
	public List<FeedbackResponseDTO> getAllFeedback() {
		List<Feedback> feedbackList = feedbackRepository.findAll();
		return feedbackList.stream().map(this::convertToDTO).collect(Collectors.toList());
	}

	@Override
	public Feedback getFeedbackById(Long id) {
//    	Feedback feedback = feedbackRepository.findById(id);
//        return feedback.map(this::convertToDTO);
		return feedbackRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
	}

	@Override
	public Feedback createFeedback(Feedback feedback) {
		// Fetch User and Ads entities based on the provided ID
		User user = userRepository.findById(feedback.getUser().getId())
				.orElseThrow(() -> new IllegalArgumentException("User not found with id: " + feedback.getId()));

		Ads ad = adsRepository.findById(feedback.getAd().getId())
				.orElseThrow(() -> new IllegalArgumentException("Ad not found with id: " + feedback.getId()));

		Feedback newFeedback = new Feedback();
		newFeedback.setUser(user);
		newFeedback.setAd(ad);
		newFeedback.setRating(feedback.getRating());
		newFeedback.setReview(feedback.getReview());

		Feedback savedFeedback = feedbackRepository.save(feedback);
//        return convertToDTO(savedFeedback);
		return savedFeedback;
	}

	@Override
	public Feedback updateFeedback(Long id, Feedback feedbackDTO) {
		Optional<Feedback> existingFeedbackOptional = feedbackRepository.findById(id);
		Feedback existingFeedback = existingFeedbackOptional
				.orElseThrow(() -> new IllegalArgumentException("Feedback not found with id: " + id));

		existingFeedback.setRating(feedbackDTO.getRating());
		existingFeedback.setReview(feedbackDTO.getReview());

		Feedback updatedFeedback = feedbackRepository.save(existingFeedback);
		return updatedFeedback;
	}

	@Override
	public void deleteFeedback(Long id) {
		feedbackRepository.deleteById(id);
	}

	@Override
	public List<FeedbackResponseDTO> getFeedbackByUserId(Long userId) {
		List<Feedback> feedbackList = feedbackRepository.findByUserId(userId);
		return feedbackList.stream().map(this::convertToDTO).collect(Collectors.toList());
	}

	@Override
	public List<FeedbackResponseDTO> getFeedbackByAdId(Long adId) {
		List<Feedback> feedbackList = feedbackRepository.findByAdId(adId);
		return feedbackList.stream().map(this::convertToDTO).collect(Collectors.toList());
	}

	@Override
	public List<FeedbackResponseDTO> getFeedbackByRatingGreaterThan(int rating) {
		List<Feedback> feedbackList = feedbackRepository.findByRatingGreaterThan(rating);
		return feedbackList.stream().map(this::convertToDTO).collect(Collectors.toList());
	}

	@Override
	public List<FeedbackResponseDTO> getFeedbackByRatingLessThan(int rating) {
		List<Feedback> feedbackList = feedbackRepository.findByRatingLessThan(rating);
		return feedbackList.stream().map(this::convertToDTO).collect(Collectors.toList());
	}

	@Override
	public List<FeedbackResponseDTO> getFeedbackByReviewContaining(String keyword) {
		List<Feedback> feedbackList = feedbackRepository.findByReviewContainingIgnoreCase(keyword);
		return feedbackList.stream().map(this::convertToDTO).collect(Collectors.toList());
	}

	private FeedbackResponseDTO convertToDTO(Feedback feedback) {
		FeedbackResponseDTO responseDTO = new FeedbackResponseDTO();
		responseDTO.setId(feedback.getId());
		responseDTO.setUserId(feedback.getUser());
		responseDTO.setAdId(feedback.getAd());
		responseDTO.setRating(feedback.getRating());
		responseDTO.setReview(feedback.getReview());
		return responseDTO;
	}

}

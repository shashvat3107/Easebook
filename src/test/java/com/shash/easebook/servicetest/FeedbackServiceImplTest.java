package com.shash.easebook.servicetest;

import com.shash.easebook.dto.FeedbackResponseDTO;
import com.shash.easebook.entities.Feedback;
import com.shash.easebook.repository.FeedbackRepository;
import com.shash.easebook.service.impl.FeedbackServiceImpl;

import jakarta.persistence.EntityNotFoundException;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class FeedbackServiceImplTest {

    @Mock
    private FeedbackRepository feedbackRepository;

    @InjectMocks
    private FeedbackServiceImpl feedbackService;

//    @Test
//    void testGetAllFeedback_Positive() {
//        // Mock data
//        List<Feedback> feedbackList = new ArrayList<>();
//        when(feedbackRepository.findAll()).thenReturn(feedbackList);
//
//        // Call service method
//        List<FeedbackResponseDTO> result = feedbackService.getAllFeedback();
//
//        // Verify result
//        assertNotNull(result);
//        assertEquals(0, result.size());
//    }
//
//    @Test
//    void testGetFeedbackById_Positive() {
//        // Mock data
//        Long feedbackId = 1L;
//        Feedback feedback = new Feedback(/* initialize Feedback object */);
//        when(feedbackRepository.findById(feedbackId)).thenReturn(Optional.of(feedback));
//
//        // Call service method
//        Feedback result = feedbackService.getFeedbackById(feedbackId);
//
//        // Verify result
//        assertNotNull(result);
//    }
//
//    @Test
//    void testGetFeedbackById_Negative() {
//        // Mock data
//        Long feedbackId = 1L;
//        when(feedbackRepository.findById(feedbackId)).thenReturn(Optional.empty());
//
//        // Call service method and verify exception
//        assertThrows(EntityNotFoundException.class, () -> feedbackService.getFeedbackById(feedbackId));
//    }
//
//    @Test
//    void testCreateFeedback_Positive() {
//        // Mock data
//        Feedback feedback = new Feedback(/* initialize Feedback object */);
//        when(feedbackRepository.save(feedback)).thenReturn(feedback);
//
//        // Call service method
//        Feedback result = feedbackService.createFeedback(feedback);
//
//        // Verify result
//        assertNotNull(result);
//        // Add additional assertions if needed
//    }
//
//    @Test
//    void testUpdateFeedback_Positive() {
//        // Mock data
//        Long feedbackId = 1L;
//        Feedback existingFeedback = new Feedback(/* initialize existing Feedback object */);
//        Feedback updatedFeedback = new Feedback(/* initialize updated Feedback object */);
//        when(feedbackRepository.findById(feedbackId)).thenReturn(Optional.of(existingFeedback));
//        when(feedbackRepository.save(existingFeedback)).thenReturn(updatedFeedback);
//
//        // Call service method
//        Feedback result = feedbackService.updateFeedback(feedbackId, existingFeedback);
//
//        // Verify result
//        assertNotNull(result);
//        // Add additional assertions if needed
//    }
//
//    @Test
//    void testUpdateFeedback_Negative() {
//        // Mock data
//        Long feedbackId = 1L;
//        Feedback existingFeedback = new Feedback(/* initialize existing Feedback object */);
//        when(feedbackRepository.findById(feedbackId)).thenReturn(Optional.empty());
//
//        // Call service method and verify exception
//        assertThrows(EntityNotFoundException.class, () -> feedbackService.updateFeedback(feedbackId, existingFeedback));
//    }
//
//    @Test
//    void testDeleteFeedback_Positive() {
//        // Mock data
//        Long feedbackId = 1L;
//
//        // Call service method
//        feedbackService.deleteFeedback(feedbackId);
//
//        // Verify that feedbackRepository.deleteById() is called
//        verify(feedbackRepository, times(1)).deleteById(feedbackId);
//    }
//
//    @Test
//    void testDeleteFeedback_Negative() {
//        // Mock data
//        Long feedbackId = 1L;
//        doThrow(EntityNotFoundException.class).when(feedbackRepository).deleteById(feedbackId);
//
//        // Call service method and verify exception
//        assertThrows(EntityNotFoundException.class, () -> feedbackService.deleteFeedback(feedbackId));
//    }
}
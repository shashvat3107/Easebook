package com.shash.easebook.controllertest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.shash.easebook.controller.FeedbackController;
import com.shash.easebook.entities.Feedback;
import com.shash.easebook.service.FeedbackService;

public class FeedbackControllerTest {
	@Mock
    private FeedbackService feedbackService;

    @InjectMocks
    private FeedbackController feedbackController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testCreateFeedback() {
        // Mock data
        Feedback feedback = new Feedback(/* initialize Feedback object */);
        when(feedbackService.createFeedback(feedback)).thenReturn(feedback);

        // Call controller method
        ResponseEntity<Feedback> responseEntity = feedbackController.createFeedback(feedback);

        // Verify response
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(feedback, responseEntity.getBody());
    }

    @Test
    void testUpdateFeedback() {
        // Mock data
        Long id = 1L;
        Feedback feedback = new Feedback(/* initialize Feedback object */);
        when(feedbackService.updateFeedback(id, feedback)).thenReturn(feedback);

        // Call controller method
        ResponseEntity<Feedback> responseEntity = feedbackController.updateFeedback(id, feedback);

        // Verify response
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(feedback, responseEntity.getBody());
    }

    @Test
    void testDeleteFeedback() {
        // Mock data
        Long id = 1L;

        // Call controller method
        ResponseEntity<String> responseEntity = feedbackController.deleteFeedback(id);

        // Verify response
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Feedback deleted successfully!", responseEntity.getBody());

        // Verify that feedbackService.deleteFeedback() is called
        verify(feedbackService, times(1)).deleteFeedback(id);
    }
}

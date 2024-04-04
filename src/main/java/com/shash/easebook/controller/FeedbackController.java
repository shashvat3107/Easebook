package com.shash.easebook.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shash.easebook.entities.Feedback;
import com.shash.easebook.service.FeedbackService;

@RestController
@RequestMapping("/api/feedbacks")
public class FeedbackController {

    private final FeedbackService feedbackService;

//    @Autowired
    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @PostMapping("/create")
    public ResponseEntity<Feedback> createFeedback(@RequestBody Feedback feedback) {
        Feedback createdFeedback = feedbackService.createFeedback(feedback);
//        if (createdFeedback != null) {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(createdFeedback);
//        } 
//        else {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
////                    .body(new Feedback("Failed to create feedback. Please try again.", null, null, 0, null));
//        }
    }

//    @GetMapping("/")
//    public ResponseEntity<List<FeedbackResponseDTO>> getAllFeedbacks() {
//        List<FeedbackResponseDTO> feedbacks = feedbackService.getAllFeedbacks();
//        return ResponseEntity.ok(feedbacks);
//    }

//    @GetMapping("/{id}")
//    public ResponseEntity<FeedbackResponseDTO> getFeedbackById(@PathVariable Long id) {
//        FeedbackResponseDTO feedback = feedbackService.getFeedbackById(id);
//        if (feedback != null) {
//            return ResponseEntity.ok(feedback);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }

    @PutMapping("/{id}")
    public ResponseEntity<Feedback> updateFeedback(@PathVariable Long id, @RequestBody Feedback feedback) {
        Feedback updatedFeedback = feedbackService.updateFeedback(id, feedback);
        if (updatedFeedback != null) {
            return ResponseEntity.ok(updatedFeedback);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFeedback(@PathVariable Long id) {
        feedbackService.deleteFeedback(id);
        return ResponseEntity.ok("Feedback deleted successfully!");
    }
}
          

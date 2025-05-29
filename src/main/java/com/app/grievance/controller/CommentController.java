package com.app.grievance.controller;

import com.app.grievance.model.Comment;
import com.app.grievance.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping
    public ResponseEntity<?> addComment(@RequestBody Comment comment) {
        try {
            Comment savedComment = commentService.createComment(comment);
            return ResponseEntity.ok(savedComment);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error while saving comment: " + e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> getComments(@RequestParam(required = false) Long grievanceId,
                                          @RequestParam(required = false) String username) {
        List<Comment> comments;
        if (grievanceId != null && username != null) {
            comments = commentService.getCommentsByGrievanceIdAndUsername(grievanceId, username);
        } else if (grievanceId != null) {
            comments = commentService.getCommentsByGrievanceId(grievanceId);
        } else {
            comments = commentService.getAllComments();
        }

        if (comments.isEmpty()) {
            return ResponseEntity.status(404).body("No comments found.");
        }
        return ResponseEntity.ok(comments);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCommentById(@PathVariable Long id) {
        try {
            Comment comment = commentService.getCommentById(id);
            return ResponseEntity.ok(comment);
        } catch (Exception e) {
            return ResponseEntity.status(404).body("Comment not found: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateComment(@PathVariable Long id, @RequestBody Comment updatedComment) {
        try {
            Comment comment = commentService.updateComment(id, updatedComment);
            return ResponseEntity.ok(comment);
        } catch (Exception e) {
            return ResponseEntity.status(404).body("Comment not found: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteComment(@PathVariable Long id) {
        try {
            commentService.deleteComment(id);
            return ResponseEntity.ok("Comment deleted successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(404).body("Comment not found: " + e.getMessage());
        }
    }
}

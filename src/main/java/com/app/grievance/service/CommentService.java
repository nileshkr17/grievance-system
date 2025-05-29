package com.app.grievance.service;

import com.app.grievance.model.Comment;
<<<<<<< HEAD
import com.app.grievance.model.Grievance;
import com.app.grievance.repository.CommentRepository;
import com.app.grievance.repository.GrievanceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final GrievanceRepository grievanceRepository;

    public CommentService(CommentRepository commentRepository, GrievanceRepository grievanceRepository) {
        this.commentRepository = commentRepository;
        this.grievanceRepository = grievanceRepository;
    }

    public Comment addComment(String grievanceId, String username, String commentText) {
        Grievance grievance = grievanceRepository.findById(Long.valueOf(grievanceId))
                .orElseThrow(() -> new RuntimeException("Grievance not found"));
        
        Comment comment = new Comment();
        comment.setUsername(username);
        comment.setComment(commentText);
        comment.setGrievance(grievance);

        return commentRepository.save(comment);
    }

    public List<Comment> getComments(String grievanceId, String username) {
        return commentRepository.findByGrievanceIdAndUsername(grievanceId, username);
    }
=======
import com.app.grievance.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    public Comment createComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public List<Comment> getCommentsByGrievanceId(Long grievanceId) {
        return commentRepository.findByGrievanceId(grievanceId);
    }

    public List<Comment> getCommentsByGrievanceIdAndUsername(Long grievanceId, String username) {
        return commentRepository.findByGrievanceIdAndUsername(grievanceId, username);
    }

    public Optional<Comment> getCommentById(Long id) {
        return commentRepository.findById(id);
    }

    public Comment updateComment(Long id, Comment updatedComment) {
        return commentRepository.findById(id).map(comment -> {
            comment.setComment(updatedComment.getComment());
            comment.setUsername(updatedComment.getUsername());
            comment.setGrievanceId(updatedComment.getGrievanceId());
            return commentRepository.save(comment);
        }).orElseThrow(() -> new RuntimeException("Comment not found"));
    }

    public void deleteComment(Long id) {
        if (!commentRepository.existsById(id)) {
            throw new RuntimeException("Comment not found");
        }
        commentRepository.deleteById(id);
    }
>>>>>>> 1259d89 (comment CRUD completed)
}

package com.app.grievance.service;

import com.app.grievance.model.Comment;
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
}

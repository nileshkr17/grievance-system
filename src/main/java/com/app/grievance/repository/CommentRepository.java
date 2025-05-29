package com.app.grievance.repository;

import com.app.grievance.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByGrievanceId(Long grievanceId);
    List<Comment> findByGrievanceIdAndUsername(Long grievanceId, String username);
}

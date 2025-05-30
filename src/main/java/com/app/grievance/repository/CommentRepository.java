package com.app.grievance.repository;

import com.app.grievance.model.Comment;
import com.app.grievance.model.Grievance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByGrievance(Grievance grievance);
    List<Comment> findByGrievanceAndUsername(Grievance grievance, String username);
}

package com.app.grievance.repository;
import org.springframework.data.domain.Page; // ✅ RIGHT

import com.app.grievance.model.Grievance;
//import org.hibernate.query.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable; // CORRECT
import java.util.List;

@Repository
public interface GrievanceRepository extends JpaRepository<Grievance, Long> {

  // Find grievances by status (resolved, pending, etc.)
  List<Grievance> findByStatus(String status);

  // Search grievances by title or description
  @Query("SELECT g FROM Grievance g WHERE g.title LIKE %:query% OR g.description LIKE %:query%")
  List<Grievance> searchByQuery(String query);  // Implement custom query logic for search

  Page<Grievance> findAll(Pageable pageable);

}

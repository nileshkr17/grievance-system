package com.app.grievance.service;

import java.util.List;

import com.app.grievance.dto.GrievanceRequest;
import com.app.grievance.model.Grievance;
import com.app.grievance.repository.GrievanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GrievanceForumService {


  @Autowired
  private GrievanceRepository grievanceRepository;

  // Fetch all grievances with optional filtering by status
  public List<Grievance> getAllGrievances(String status) {
    if (status != null) {
      return grievanceRepository.findByStatus(status);  // assuming this method is defined
    } else {
      return grievanceRepository.findAll();
    }
  }

  // Add a comment to a grievance (example)
  public Grievance addComment(GrievanceRequest grievanceRequest) {
    Grievance grievance = new Grievance();
    // Logic to add comment to grievance, this can be expanded
    grievance.setComment(grievanceRequest.getComment());
    return grievanceRepository.save(grievance);
  }

  // Search for grievances by title or description
  public List<Grievance> searchGrievances(String query) {
    return grievanceRepository.searchByQuery(query); // Assuming you add a method for search
  }
}

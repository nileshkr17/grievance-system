package com.app.grievance.service;

import java.util.List;

import com.app.grievance.dto.GrievanceRequest;
import com.app.grievance.model.Grievance;
import com.app.grievance.repository.GrievanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
//  public Grievance addComment(GrievanceRequest grievanceRequest) {
//    // Retrieve the existing grievance by ID
//    try {
//      Grievance grievance = grievanceRepository.findById(grievanceRequest.getId())
//        .orElseThrow(() -> new IllegalArgumentException("Grievance not found with ID: " + grievanceRequest.getId()));
//
//      // Add the comment to the existing grievance
//      grievance.setComment(grievanceRequest.getComment());
//      grievance.setStatus("Commented"); // Update status if needed
//      return grievanceRepository.save(grievance);
//    }
//    catch (Exception e){
//      e.printStackTrace();  // or log.error("Error:", e);
//      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Grievance not found with ID: " +grievanceRequest.getId());
//    }
//    finally {
//      System.out.println("Grievance ID: " + grievanceRequest.getId());
//      System.out.println("Comment: " + grievanceRequest.getComment());
//    }
//
//  }

  public Grievance addComment(GrievanceRequest grievanceRequest) {
    try {
      System.out.println("Adding comment to Grievance ID: " + grievanceRequest.getId());
      Grievance grievance = grievanceRepository.findById(grievanceRequest.getId())
        .orElseThrow(() -> new IllegalArgumentException("Grievance not found with ID: " + grievanceRequest.getId()));

      // Set the comment
      grievance.setComment(grievanceRequest.getComment());
      grievance.setStatus("Commented"); // Update status if needed
      return grievanceRepository.save(grievance);
    }
    catch (Exception e) {
      e.printStackTrace();  // Or log.error("Error:", e);
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Grievance not found with ID: " + grievanceRequest.getId());
    }
  }

  // Search for grievances by title or description
  public List<Grievance> searchGrievances(String query) {
    return grievanceRepository.searchByQuery(query); // Assuming you add a method for search
  }


  //post for service
  public Grievance createGrievance(Grievance grievance) {
    return grievanceRepository.save(grievance);
  }

  //get for grievance by id
  public Grievance getGrievanceById(Long id) {
    return grievanceRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Grievance not found"));
  }

}

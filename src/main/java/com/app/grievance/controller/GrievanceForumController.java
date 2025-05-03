package com.app.grievance.controller;

import com.app.grievance.dto.GrievanceRequest;
import com.app.grievance.service.GrievanceForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("api/forum")
public class GrievanceForumController {

  @Autowired
  private GrievanceForumService grievanceForumService;

  // Endpoint to view grievances (could be filtered by status, etc.)
  @GetMapping("/grievances")
  public ResponseEntity<?> getAllGrievances(@RequestParam(required = false) String status) {
    return ResponseEntity.ok(grievanceForumService.getAllGrievances(status));
  }


  // Endpoint to add a comment to a grievance
  @PostMapping("/add-comment")
  public ResponseEntity<?> addComment(@RequestBody GrievanceRequest grievanceRequest) {
    return ResponseEntity.ok(grievanceForumService.addComment(grievanceRequest));
  }

  // Endpoint to search grievances by title or description
  @GetMapping("/search")
  public ResponseEntity<?> searchGrievances(@RequestParam String query) {
    return ResponseEntity.ok(grievanceForumService.searchGrievances(query));
  }

}

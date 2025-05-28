package com.app.grievance.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Random; // Import for random number generation

@Setter
@Getter
@Entity
@Table(name = "grievance")  // Ensure the table name matches the one in your MySQL database
public class Grievance {

  @Id
  // The ID will now be generated programmatically as a 5-digit numeric string.
  private String id; // Type remains String for numeric ID

  private String title;
  private String description;
  private String status;       // OPEN, PENDING, RESOLVED
  private String comment;
  private String category;     // Newly added field
  @Column(name = "created_by")
  private String createdBy;
  @Column(name = "assigned_to")
  private String assignedTo;

  @Column(name = "created_at", nullable = false, updatable = false)
  @Temporal(TemporalType.TIMESTAMP)
  private java.util.Date createdAt;

  // Helper method to generate a 5-digit numeric ID
  private String generateNumericId() {
    String digits = "0123456789";
    StringBuilder sb = new StringBuilder();
    Random random = new Random();
    for (int i = 0; i < 5; i++) {
      sb.append(digits.charAt(random.nextInt(digits.length())));
    }
    return sb.toString();
  }

  // Default constructor
  public Grievance() {
    // Generate a 5-digit numeric ID when a new Grievance object is created
    this.id = generateNumericId();
  }

  // Constructor with fields (including category)
  public Grievance(String title, String description, String status, String comment, String category, String createdBy, String assignedTo, java.util.Date createdAt) {
    // Generate a 5-digit numeric ID when a new Grievance object is created
    this.id = generateNumericId();
    this.title = title;
    this.description = description;
    this.status = status;
    this.comment = comment;
    this.category = category;
    this.createdAt = createdAt;
    this.createdBy = createdBy;
    this.assignedTo = assignedTo;
  }
}
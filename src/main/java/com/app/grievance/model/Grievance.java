package com.app.grievance.model;

import jakarta.persistence.*;

@Entity
@Table(name = "grievance")  // Ensure the table name matches the one in your MySQL database
public class Grievance {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String title;
  private String description;
  private String status;       // OPEN, PENDING, RESOLVED
  private String comment;
  private String category;     //  Newly added field

  @Column(name = "created_at", nullable = false, updatable = false)
  @Temporal(TemporalType.TIMESTAMP)
  private java.util.Date createdAt;

  // Default constructor
  public Grievance() {}

  // Constructor with fields (including category)
  public Grievance(String title, String description, String status, String comment, String category, java.util.Date createdAt) {
    this.title = title;
    this.description = description;
    this.status = status;
    this.comment = comment;
    this.category = category;
    this.createdAt = createdAt;
  }

  // Getters and Setters
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public java.util.Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(java.util.Date createdAt) {
    this.createdAt = createdAt;
  }
}

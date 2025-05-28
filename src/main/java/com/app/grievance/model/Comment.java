package com.app.grievance.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Auto-generated comment ID

    private String username;

    private String comment;

    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "grievance_id", nullable = false)
    private Grievance grievance;

    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
}

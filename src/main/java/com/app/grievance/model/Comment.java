package com.app.grievance.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
<<<<<<< HEAD

=======
>>>>>>> 1259d89 (comment CRUD completed)
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "comment")
public class Comment {
<<<<<<< HEAD

=======
>>>>>>> 1259d89 (comment CRUD completed)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Auto-generated comment ID

    private String username;

<<<<<<< HEAD
=======
    @Column(name = "grievance_id")
    private Long grievanceId;

>>>>>>> 1259d89 (comment CRUD completed)
    private String comment;

    private LocalDateTime createdAt;

<<<<<<< HEAD
    @ManyToOne
    @JoinColumn(name = "grievance_id", nullable = false)
    private Grievance grievance;

=======
>>>>>>> 1259d89 (comment CRUD completed)
    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
}

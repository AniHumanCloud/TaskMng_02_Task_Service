package com.example.task.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;

@Entity
@Table(name = "TASK_SERVICE")
@Data
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    @Column(name = "createdDate", updatable = false)
    @CreationTimestamp
    private LocalDate createdAt;

    @UpdateTimestamp
    @Column(name = "updatedDate", insertable = false)
    private LocalDate updatedAt;

//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private UserEntity user;
}

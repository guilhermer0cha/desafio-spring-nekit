package com.example.nekit.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table
public class Tasks {
    @Id
    private UUID id;
    private UUID projectId;
    private String title;
    private Boolean completed;
    public enum Priority {
        LOW,
        MEDIUM,
        HIGH
    }
    private LocalDate dueDate;
    private LocalDateTime createdAt;
}

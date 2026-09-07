package com.example.nekit.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table
public class Projects {
    @Id
    private UUID id;
    private String title;
    private String description;
    private LocalDateTime createdAt;
}

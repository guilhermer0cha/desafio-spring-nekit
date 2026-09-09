package com.example.nekit.Repository;

import com.example.nekit.Entity.Projects;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProjectsRepository extends JpaRepository<Projects, UUID> {
}

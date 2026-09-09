package com.example.nekit.Repository;

import com.example.nekit.Entity.Tasks;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TasksRepository extends JpaRepository<Tasks, UUID> {
}

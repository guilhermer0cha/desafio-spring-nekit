package com.example.nekit.DTO.TasksDTO;

import com.example.nekit.Entity.Tasks;
import java.time.LocalDate;
import java.util.UUID;

public record TaskResponseDTO (
        UUID id,
        String title,
        Tasks.Priority priority,
        UUID projectId,
        LocalDate due_date
){
}

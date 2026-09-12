package com.example.nekit.DTO.TasksDTO;

import com.example.nekit.Entity.Tasks;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.UUID;

public record TaskCreateDTO(
        @NotBlank
        String title,

        @NotBlank
        Tasks.Priority priority,

        @NotBlank
        @NotNull
        UUID projectId,

        @NotBlank
        LocalDate due_date

) {
}

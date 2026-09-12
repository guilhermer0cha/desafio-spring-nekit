package com.example.nekit.DTO.ProjectsDTO;

import com.example.nekit.DTO.TasksDTO.TaskResponseDTO;

import java.util.UUID;
import java.util.List;

public record ProjectResponseDTO (
        UUID id,
        String title,
        List<TaskResponseDTO> tasks
){
}

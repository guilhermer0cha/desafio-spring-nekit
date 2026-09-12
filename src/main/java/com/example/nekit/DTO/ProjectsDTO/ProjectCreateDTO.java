package com.example.nekit.DTO.ProjectsDTO;

import jakarta.validation.constraints.NotBlank;

public record ProjectCreateDTO(
        @NotBlank
        String title,
        String description
) {}



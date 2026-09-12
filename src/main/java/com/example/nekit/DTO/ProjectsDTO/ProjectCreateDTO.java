package com.example.nekit.DTO.ProjectsDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ProjectCreateDTO(
        @NotBlank
        @Size(max = 60, message = "TITLE WITH MORE THAN 60 CHARACTERS")
        String title,
        String description
) {}



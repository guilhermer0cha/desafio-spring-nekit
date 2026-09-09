package com.example.nekit.Controller;

import com.example.nekit.DTO.ProjectsDTO.ProjectCreateDTO;
import com.example.nekit.Entity.Projects;
import com.example.nekit.Service.ProjectsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/projects")
@RequiredArgsConstructor
public class ProjectController {
    private final ProjectsService projectsService;

    @PostMapping
    public Projects createProject(@RequestBody ProjectCreateDTO projectCreateDTO) {
        return projectsService.createProject(projectCreateDTO);
    }

    @DeleteMapping("/{projectId}")
    public void deleteProject(@PathVariable UUID projectId) {
        projectsService.deleteProject(projectId);
    }
}

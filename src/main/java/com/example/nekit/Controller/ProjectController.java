package com.example.nekit.Controller;

import com.example.nekit.DTO.ProjectsDTO.ProjectCreateDTO;
import com.example.nekit.DTO.ProjectsDTO.ProjectUpdateDTO;
import com.example.nekit.Entity.Projects;
import com.example.nekit.Service.ProjectsService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @DeleteMapping("/{id}")
    public void deleteProject(@PathVariable UUID id) {
        projectsService.deleteProject(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Projects> findById(@PathVariable UUID id) {
        return projectsService.findProject(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Projects> findAll() {
        return projectsService.findAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateProjectById(@PathVariable UUID id,
                                                  @RequestBody ProjectUpdateDTO projectUpdateDTO) {
        projectsService.updateProject(id, projectUpdateDTO);
        return ResponseEntity.ok().build();
    }
}

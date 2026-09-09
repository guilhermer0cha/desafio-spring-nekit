package com.example.nekit.Service;

import com.example.nekit.DTO.ProjectsDTO.ProjectCreateDTO;
import com.example.nekit.Entity.Projects;
import com.example.nekit.Repository.ProjectsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProjectsService {

    private final ProjectsRepository projectsRepository;

    public Projects createProject(ProjectCreateDTO projectCreateDTO) {
        Projects project = new Projects();

        project.setTitle(projectCreateDTO.title());
        project.setDescription(projectCreateDTO.description());

        return projectsRepository.save(project);
    }

    public void deleteProject(UUID id) {
        projectsRepository.deleteById(id);
    }
}

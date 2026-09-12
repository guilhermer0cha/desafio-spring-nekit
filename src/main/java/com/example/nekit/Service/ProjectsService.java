package com.example.nekit.Service;

import com.example.nekit.DTO.ProjectsDTO.ProjectCreateDTO;
import com.example.nekit.DTO.ProjectsDTO.ProjectResponseDTO;
import com.example.nekit.DTO.ProjectsDTO.ProjectUpdateDTO;
import com.example.nekit.DTO.TasksDTO.TaskResponseDTO;
import com.example.nekit.Entity.Projects;
import com.example.nekit.Repository.ProjectsRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

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



    public ProjectResponseDTO findProject(UUID id) {
        Projects project = projectsRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "PROJECT NOT FOUND"));

        List<TaskResponseDTO> taskDTOs = project.getTasks().stream()
                .map(task -> new TaskResponseDTO(
                        task.getId(),
                        task.getTitle(),
                        task.getPriority(),
                        project.getId(),
                        task.getDueDate()
                ))
                .toList();

        return new ProjectResponseDTO(
                project.getId(),
                project.getTitle(),
                taskDTOs
        );
    }

    public List<Projects> findAll() {
        return projectsRepository.findAll();
    }

    public void updateProject(UUID id, ProjectUpdateDTO projectUpdateDTO) {
        Projects projectEntity = projectsRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "PROJECT NOT FOUND"));

        if (projectUpdateDTO.title() != null) {
            projectEntity.setTitle(projectUpdateDTO.title());
        }

        if (projectUpdateDTO.description() != null) {
            projectEntity.setDescription(projectUpdateDTO.description());
        }
        projectsRepository.save(projectEntity);
    }
}

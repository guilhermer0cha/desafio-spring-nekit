package com.example.nekit.Service;

import com.example.nekit.DTO.TasksDTO.TaskResponseDTO;
import com.example.nekit.Entity.Projects;
import com.example.nekit.Entity.Tasks;
import com.example.nekit.DTO.TasksDTO.TaskCreateDTO;
import com.example.nekit.Repository.ProjectsRepository;
import com.example.nekit.Repository.TasksRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TasksService {

    private final TasksRepository tasksRepository;
    private final ProjectsRepository projectsRepository;

    public TaskResponseDTO createTask(TaskCreateDTO taskCreateDTO) {
        Tasks task = new Tasks();

        task.setTitle(taskCreateDTO.title());
        task.setPriority(taskCreateDTO.priority());
        task.setDueDate(taskCreateDTO.due_date());

        Projects actualProject = projectsRepository.findById(taskCreateDTO.projectId()).orElseThrow(()  ->
               new ResponseStatusException(HttpStatus.NOT_FOUND, "PROJECT NOT FOUND"));

        task.setProject(actualProject);
        Tasks savedTask = tasksRepository.save(task);

        return new TaskResponseDTO(
                savedTask.getId(),
                savedTask.getTitle(),
                savedTask.getPriority(),
                savedTask.getProject().getId(),
                savedTask.getDueDate()
        );
    }

    public void deleteTask(UUID taskId) {
        tasksRepository.deleteById(taskId);
    }
}

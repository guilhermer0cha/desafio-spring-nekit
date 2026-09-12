package com.example.nekit.Controller;

import com.example.nekit.DTO.TasksDTO.TaskResponseDTO;
import com.example.nekit.Entity.Tasks;
import com.example.nekit.Service.TasksService;
import com.example.nekit.DTO.TasksDTO.TaskCreateDTO;
import com.example.nekit.Repository.TasksRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {
    private final TasksService tasksService;

    @PostMapping
    public TaskResponseDTO create(@RequestBody TaskCreateDTO taskCreateDTO) {
        return tasksService.createTask(taskCreateDTO);
    }

    @DeleteMapping("/id")
    public void delete(@PathVariable UUID taskId) {
        tasksService.deleteTask(taskId);
    }
}

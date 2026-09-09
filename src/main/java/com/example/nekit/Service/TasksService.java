package com.example.nekit.Service;

import com.example.nekit.Entity.Tasks;
import com.example.nekit.Repository.ProjectsRepository;
import com.example.nekit.Repository.TasksRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TasksService {

    private final TasksRepository tasksRepository;

}

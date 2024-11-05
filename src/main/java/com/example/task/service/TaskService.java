package com.example.task.service;

import com.example.task.bindings.TaskDto;
import com.example.task.entities.TaskEntity;

import java.util.List;

public interface TaskService {

    public TaskEntity createTask(TaskDto task);

    public boolean updateTaskById(Long id, TaskDto taskDto);

    public TaskDto getTaskById(Long id);

    public TaskDto getTaskByUserById(Long id);

    public boolean deletTaskById(Long id);

    public List<TaskDto>getAllTask();
}

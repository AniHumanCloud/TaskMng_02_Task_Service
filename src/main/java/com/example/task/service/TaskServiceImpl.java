package com.example.task.service;

import com.example.task.bindings.TaskDto;
import com.example.task.entities.TaskEntity;
import com.example.task.repository.TaskRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {
    Logger logger = LoggerFactory.getLogger(TaskServiceImpl.class);
    @Autowired
    private TaskRepo taskRepo;

    @Override
    public TaskEntity createTask(TaskDto task) {
        logger.debug("Create task processing started: " + task);
        TaskEntity taskEntity = new TaskEntity();

        BeanUtils.copyProperties(task, taskEntity);
        TaskEntity saveTaskEntity = taskRepo.save(taskEntity);
        return saveTaskEntity;
    }

    @Override
    public boolean updateTaskById(Long id, TaskDto taskDto) {

        Optional<TaskEntity> taskEntityOp = taskRepo.findById(id);

        if (taskEntityOp.isPresent()) {
            TaskEntity taskEntity = taskEntityOp.get();
            BeanUtils.copyProperties(taskDto, taskEntity);
            taskEntity.setId(id);
            taskRepo.save(taskEntity);
            return true;
        }

        return false;
    }

    @Override
    public TaskDto getTaskById(Long id) {
        Optional<TaskEntity> taskById = taskRepo.findById(id);
        if(taskById.isPresent()){
            TaskEntity taskEntity = taskById.get();
            TaskDto taskDto=new TaskDto();
            BeanUtils.copyProperties(taskEntity,taskDto);
            return taskDto;
        }

        return null;
    }

    @Override
    public TaskDto getTaskByUserById(Long id) {
        //userRepo.getTaskByUserid();
        return null;
    }

    @Override
    public boolean deletTaskById(Long id) {
        boolean status = taskRepo.existsById(id);
        if(status){
            taskRepo.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<TaskDto> getAllTask() {

        List<TaskEntity> allTask = taskRepo.findAll();

        List<TaskDto> taskDtos=new ArrayList<>();

        for(TaskEntity task:allTask){
            TaskDto taskDto=new TaskDto();
            BeanUtils.copyProperties(task,taskDto);
            taskDtos.add(taskDto);
        }
        return taskDtos;
    }
}

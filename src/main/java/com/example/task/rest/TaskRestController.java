package com.example.task.rest;

import com.example.task.bindings.TaskDto;
import com.example.task.entities.TaskEntity;
import com.example.task.service.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskRestController {

    @Autowired
    private TaskService taskService;
    Logger logger = LoggerFactory.getLogger(TaskRestController.class);

    @PostMapping("/task")
    public ResponseEntity<TaskEntity> createTask(@RequestBody TaskDto taskDto) {
        logger.debug("TaskCreation started..." + taskDto);
        TaskEntity task = taskService.createTask(taskDto);
        return new ResponseEntity<>(task, HttpStatus.CREATED);
    }

    @PutMapping("/task/{taskId}")
    public ResponseEntity<String> updateTask(@PathVariable Long taskId, @RequestBody TaskDto taskDto) {
        boolean status = taskService.updateTaskById(taskId, taskDto);
        if (status) {
            return new ResponseEntity<>("Task Updated", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Problem Occurred", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/task/{taskId}")
    public ResponseEntity<TaskDto> getTaskById(@PathVariable Long taskId) {
        TaskDto taskById = taskService.getTaskById(taskId);
        return new ResponseEntity<>(taskById, HttpStatus.OK);
    }

    @DeleteMapping("/task-delete/{taskId}")
    public ResponseEntity<String> delteTaskById(@PathVariable Long taskId) {
        boolean status = taskService.deletTaskById(taskId);
        if (status) {
            return new ResponseEntity<>("Task Deleted..", HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>("Task Not Found", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/task")
    public ResponseEntity<List<TaskDto>>AllTasks(){
        List<TaskDto> allTask = taskService.getAllTask();
        return new ResponseEntity<>(allTask,HttpStatus.OK);
    }
}

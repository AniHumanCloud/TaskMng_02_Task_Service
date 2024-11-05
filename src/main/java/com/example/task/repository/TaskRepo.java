package com.example.task.repository;

import com.example.task.entities.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepo extends JpaRepository<TaskEntity,Long> {
}

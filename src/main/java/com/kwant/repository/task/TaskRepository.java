package com.kwant.repository.task;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kwant.entity.task.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{

}
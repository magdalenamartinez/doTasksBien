package com.cmepps.doTasks.core.driver_ports;

import java.util.List;
import java.util.Optional;

import com.cmepps.doTasks.core.domain.Task;

public interface TaskService  {
    Optional<Task> readById(Long id);

    List<Task> readAll();

    Optional<Task> updateTask(Task task);

    boolean deleteTask(Long id);

    Task createTask(Task task);
}
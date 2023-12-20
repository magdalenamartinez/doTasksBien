package com.cmepps.doTasks.core.driven_ports;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.cmepps.doTasks.core.domain.Task;


@Repository
public interface TaskRepository {
    Optional<Task> update(Task task);

    Optional<Task> findById(Long id);

    List<Task> findAll();

    Task save(Task task);

    boolean deleteById(Long id);


}
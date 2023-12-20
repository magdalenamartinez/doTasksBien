package com.cmepps.doTasks.core.usecase;

import com.cmepps.doTasks.core.domain.Task;
import com.cmepps.doTasks.core.driven_ports.TaskRepository;

public class DeleteTaskUseCaseImpl implements DeleteTaskUseCase{

    private final TaskRepository taskRepository;

    public DeleteTaskUseCaseImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public boolean deleteTask(Long id) {
        return taskRepository.deleteById(id);
    }
}
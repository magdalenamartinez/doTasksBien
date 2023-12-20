package com.cmepps.doTasks.core.usecase;

import com.cmepps.doTasks.core.domain.Task;
import com.cmepps.doTasks.core.driven_ports.TaskRepository;

public class CreateTaskUseCaseImpl implements CreateTaskUseCase{

    private final TaskRepository taskRepository;

    public CreateTaskUseCaseImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task createTask(Task task)
    {
        return taskRepository.save(task);
    }

}
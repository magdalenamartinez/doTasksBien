package com.cmepps.doTasks.core.usecase;

import java.util.Optional;

import com.cmepps.doTasks.core.domain.Task;
import com.cmepps.doTasks.core.driven_ports.TaskRepository;


public class UpdateTaskUseCaseImpl implements UpdateTaskUseCase {
	
	private final TaskRepository taskRepository;

	
	public UpdateTaskUseCaseImpl(TaskRepository taskRepository)
	{
		this.taskRepository = taskRepository;
	}
	
	@Override
	public Optional<Task> updateTask(Task task) {
		return taskRepository.update(task);
	}
}
	

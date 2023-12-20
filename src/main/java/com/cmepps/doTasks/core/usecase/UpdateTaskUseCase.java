package com.cmepps.doTasks.core.usecase;

import java.util.Optional;

import com.cmepps.doTasks.core.domain.Task;

public interface UpdateTaskUseCase {
	Optional<Task> updateTask(Task task);
}

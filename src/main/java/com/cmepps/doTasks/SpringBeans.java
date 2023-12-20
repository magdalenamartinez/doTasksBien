package com.cmepps.doTasks;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cmepps.doTasks.core.driven_ports.TaskRepository;
import com.cmepps.doTasks.core.driver_ports.TaskService;
import com.cmepps.doTasks.core.driver_ports.TaskServiceImpl;
import com.cmepps.doTasks.core.usecase.CreateTaskUseCaseImpl;
import com.cmepps.doTasks.core.usecase.DeleteTaskUseCaseImpl;
import com.cmepps.doTasks.core.usecase.ReadTaskUseCaseImpl;
import com.cmepps.doTasks.core.usecase.UpdateTaskUseCaseImpl;


@Configuration
public class SpringBeans {
	@Bean
	TaskService taskService(final TaskRepository taskRepository) {
		return new TaskServiceImpl
				(new UpdateTaskUseCaseImpl(taskRepository), 
						new DeleteTaskUseCaseImpl(taskRepository),
						new ReadTaskUseCaseImpl(taskRepository),
						new CreateTaskUseCaseImpl(taskRepository));
	}
	
}

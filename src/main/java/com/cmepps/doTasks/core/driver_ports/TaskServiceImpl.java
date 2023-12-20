package com.cmepps.doTasks.core.driver_ports;

import java.util.List;
import java.util.Optional;

import com.cmepps.doTasks.core.domain.Task;
import com.cmepps.doTasks.core.usecase.CreateTaskUseCase;
import com.cmepps.doTasks.core.usecase.DeleteTaskUseCase;
import com.cmepps.doTasks.core.usecase.ReadTaskUseCase;
import com.cmepps.doTasks.core.usecase.UpdateTaskUseCase;


public class TaskServiceImpl implements TaskService {

    private final UpdateTaskUseCase updateTaskUseCase;
    private final DeleteTaskUseCase deleteTaskUseCase;
    private final ReadTaskUseCase readTaskUseCase;
    private final CreateTaskUseCase createTaskUseCase;


    public TaskServiceImpl(UpdateTaskUseCase updateTaskUseCase, DeleteTaskUseCase deleteTaskUseCase,
        ReadTaskUseCase readTaskUseCase, CreateTaskUseCase createTaskUseCase) {
        super();
        this.updateTaskUseCase = updateTaskUseCase;
        this.deleteTaskUseCase = deleteTaskUseCase;
        this.readTaskUseCase = readTaskUseCase;
        this.createTaskUseCase = createTaskUseCase;
    }

    @Override
    public Optional<Task> readById(Long id) {
        // TODO Auto-generated method stub
        return readTaskUseCase.readById(id);
    }

    @Override
    public List<Task> readAll() {
        // TODO Auto-generated method stub
        return readTaskUseCase.readAll();
    }

    @Override
    public Optional<Task> updateTask(Task task) {
        // TODO Auto-generated method stub
        return updateTaskUseCase.updateTask(task);
    }

    @Override
    public boolean deleteTask(Long id) {
        // TODO Auto-generated method stub
        return deleteTaskUseCase.deleteTask(id);
    }

    @Override
    public Task createTask(Task task) {
        // TODO Auto-generated method stub
        return createTaskUseCase.createTask(task);
    }
    
}
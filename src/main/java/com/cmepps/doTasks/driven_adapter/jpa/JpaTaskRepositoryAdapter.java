package com.cmepps.doTasks.driven_adapter.jpa;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.cmepps.doTasks.core.domain.Task;
import com.cmepps.doTasks.core.driven_ports.TaskRepository;
import com.cmepps.doTasks.driven_adapter.domain.TaskEntity;
@Repository
public class JpaTaskRepositoryAdapter implements TaskRepository{
	private JpaTaskRepository jpaTaskRepository;

	@Override
	public Optional<Task> update(Task task) {
		// TODO Auto-generated method stub
		/*
		 * Se ve si existe la entidad tarea en db
		 * luego se pasa la tarea actualizada a tarea entidad
		 * se guarda en la db la tarea entidad
		 * en caso de q se haya actualizado se pasa la tarea entidad obtenida a tarea
		 * se devuelve la tarea
		 * */
		if (jpaTaskRepository.existsById(task.getId())) {
			TaskEntity TaskEntityToUpdate = TaskEntity.fromTask(task);
			TaskEntity updatedTaskEntity = jpaTaskRepository.save(TaskEntityToUpdate);
			Task updatedTask = updatedTaskEntity.toTask();
			return Optional.of(updatedTask);
		}
		return Optional.empty();
	}

	@Override
	public Optional<Task> findById(Long id) {
		// TODO Auto-generated method stub
		/*
		 * Mira si existe la taskentity en la DB buscando por id
		 * si existe la pasa a task y la devuelve.
		 * */
		if (jpaTaskRepository.existsById(id)) {
			Optional<TaskEntity> taskEntityReadedOptional = jpaTaskRepository.findById(id);
			if (!taskEntityReadedOptional.isEmpty()) {
				TaskEntity taskEntityReaded = taskEntityReadedOptional.get();
				Task taskReaded = taskEntityReaded.toTask();
				return Optional.of(taskReaded);
			}
		}
		return Optional.empty();
	}

	@Override
	public List<Task> findAll() {
		// TODO Auto-generated method stub
		/*
		 * Busca todas las TaskEntities, las pasa a Task y las devuelve
		 * */
		List<TaskEntity> listTaskEntity = jpaTaskRepository.findAll();
		List<Task> listTask = new ArrayList<>();
		for (TaskEntity taskEntity : listTaskEntity) {
			listTask.add(taskEntity.toTask());
		}
		return listTask;
	}

	@Override
    public Task save(Task task) {
        // TODO Auto-generated method stub
        TaskEntity TaskEntityToSave = TaskEntity.fromTask(task);
        TaskEntity savedTaskEntity = jpaTaskRepository.save(TaskEntityToSave);
        return savedTaskEntity.toTask();
    }

    @Override
    public boolean deleteById(Long id) {
        // TODO Auto-generated method stub
        if (jpaTaskRepository.existsById(id)) {
            jpaTaskRepository.deleteById(id);
            return true;
        }
        return false;
    }
	
	
}

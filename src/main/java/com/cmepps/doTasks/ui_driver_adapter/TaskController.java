package com.cmepps.doTasks.ui_driver_adapter;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cmepps.doTasks.core.domain.Task;
import com.cmepps.doTasks.core.driver_ports.TaskService;

@Controller
public class TaskController {
	@Autowired
	TaskService taskService;
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        // Date - dd/MM/yyyy
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
    
	@RequestMapping(value="/list-tasks", method=RequestMethod.GET)
	public String readAll(ModelMap model)
	{
		//model.put("tasks", taskService.readAll());
		return "list-tasks";
	}
	

    private String getLoggedInUserName(ModelMap model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            return ((UserDetails) principal).getUsername();
        }

        return principal.toString();
    }

    @RequestMapping(value = "/showcreate-task", method = RequestMethod.GET)
    public String showAddTaskPage(ModelMap model) {
        return "newtask";
    }

    @RequestMapping(value = "/delete-task", method = RequestMethod.GET)
    public String deleteTodo(@RequestParam long id) {
        taskService.deleteTask(id);
        return "redirect:/list-tasks";
    }

    @RequestMapping(value = "/update-task", method = RequestMethod.GET)
    public String showUpdateTodoPage(@RequestParam long id, ModelMap model) {
        Task task = taskService.readById(id).get();
        model.put("task", task);
        return "task";
    }

    @RequestMapping(value = "/create-task", method = RequestMethod.POST)
    public String createTask(ModelMap model, @Validated Task task, BindingResult result) {
        if (result.hasErrors()) {
            return "todo";
        }
        taskService.createTask(task);
        return "redirect:/list-todos";
    }
	
	
}

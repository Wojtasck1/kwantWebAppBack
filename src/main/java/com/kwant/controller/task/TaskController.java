package com.kwant.controller.task;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kwant.entity.task.Task;
import com.kwant.repository.task.TaskRepository;

@Controller
@RequestMapping("api/v1/")
public class TaskController {
	
	@Autowired
	TaskRepository taskRepository;
	
	@CrossOrigin
	@RequestMapping(value = "dupa" , method = RequestMethod.GET)
	public ModelAndView getPage(){
		ModelAndView view = new ModelAndView("tasks"); 
		return view;
	}
	
	@CrossOrigin
	@RequestMapping(value = "tasks" , method = RequestMethod.GET , produces = "application/json") 
	public @ResponseBody List<Task> getTask(){ 
		return taskRepository.findAll(); 
	}
	
//	@RequestMapping(value = "/saveOrUpdate" , method = RequestMethod.POST)
//	public @ResponseBody Map<String , Object> getSaved(Task task){
//		Map<String , Object> map = new HashMap<String , Object>();
//		 
//		if(taskRepository.saveOrUpdate(task)){
//			map.put("status", "200");
//			map.put("message", "Your record have been saved successfully");
//		}
//		
//		return map;
//	}
	
//	@RequestMapping(value = "/list" , method = RequestMethod.POST)
//	public @ResponseBody Map<String , Object> getAll(Task task){
//		Map<String, Object> map = new HashMap<String , Object>();
//		
//		List<Task> list = taskRepository.list();
//		if(list != null){
//			map.put("status", "200");
//			map.put("message", "Data found");
//			map.put("data", list);
//		} else {
//			map.put("status", "404");
//			map.put("message", "Data not found");
//		}
//		
//		return map;
//	}
	
//	@RequestMapping()
//	public @ResponseBody Map<String , Object> delete(Task task){
//		Map<String, Object> map = new HashMap<String, Object>();	
//		
//		if(taskRepository.delete(task)){
//			map.put("status", "200");
//			map.put("message", "Your record have been deleted successfully");
//		}
//		return map;
//	}
}
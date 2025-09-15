package com.example.todo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.todo.dao.TodoDao;
import com.example.todo.model.Todo;

@Controller
public class TodoController {
	
	private final TodoDao todoDao;
	
	public TodoController(TodoDao todoDao) {
		this.todoDao = todoDao;
	}
	
	@GetMapping("/")
	public String listTodos(Model model) {
		List<Todo> todos = todoDao.findAll();
//		Todo todo = new Todo();
//		todo.setTitle("독서");
//		List<Todo> todos = new ArrayList<Todo>();
//		todos.add(todo);
		model.addAttribute("todos", todos);
		return "list";
	}
	
	@GetMapping("add")
	public String addForm() {
		return "add";
	}
	
	@PostMapping("/add")
	public String addTodo(@RequestParam("title") String title) {//@RequestParam("title") 생략가능 혹시나 이름이 달라졌을떄 사용가능 웬만하면 쓰지마
		todoDao.add(title);
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteTodo(@PathVariable int id) {
		todoDao.delete(id);
		return "redirect:/";
	}
	
	@GetMapping("/toggle/{id}")
	public String toggleCompleted(@PathVariable int id) {
		todoDao.toggleCompleted(id);
		return "redirect:/";
	}
	
}

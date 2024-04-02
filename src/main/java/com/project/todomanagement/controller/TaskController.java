package com.project.todomanagement.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.todomanagement.pojo.TbTaskDetails;
import com.project.todomanagement.service.TaskService;

import jakarta.validation.Valid;

public class TaskController {
	@Autowired
    private TaskService todoService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        // Date - dd/MM/yyyy
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

    @GetMapping(value = "/todos")
    public ResponseEntity<Object> showTodos(String userId) {
        return new ResponseEntity<>(todoService.getTodosByUser(userId), HttpStatus.OK);
    }


    @DeleteMapping(value = "/todo")
    public ResponseEntity<Object> deleteTodo(@RequestParam long id) {
    	todoService.deleteTodo(id);
    	return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/todo")
    public ResponseEntity<Object> showTodoById(@RequestParam long id) {
    	return new ResponseEntity<>(todoService.getTodoById(id).get(), HttpStatus.OK);
    }

    @PutMapping(value = "/update-todo")
    public ResponseEntity<Object> updateTodo(@Valid TbTaskDetails todo) {
        todoService.updateTodo(todo);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/todo")
    public ResponseEntity<Object> addTodo(@Valid TbTaskDetails todo) {
        todoService.saveTodo(todo);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

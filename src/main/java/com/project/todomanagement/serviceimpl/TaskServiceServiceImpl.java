package com.project.todomanagement.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.project.todomanagement.pojo.TbTaskDetails;
import com.project.todomanagement.repository.TodoMangementRepository;
import com.project.todomanagement.service.TaskService;

public class TaskServiceServiceImpl implements TaskService {

	@Autowired
    private TodoMangementRepository todoRepository;

    @Override
    public List<TbTaskDetails> getTodosByUser(String user) {
        return todoRepository.findByUserId(user);
    }

    @Override
    public Optional<TbTaskDetails> getTodoById(long id) {
        return todoRepository.findById(id);
    }

    @Override
    public void updateTodo(TbTaskDetails todo) {
        todoRepository.save(todo);
    }

    @Override
    public void deleteTodo(long id) {
        Optional<TbTaskDetails> todo = todoRepository.findById(id);
        if (todo.isPresent()) {
            todoRepository.delete(todo.get());
        }
    }

    @Override
    public void saveTodo(TbTaskDetails todo) {
        todoRepository.save(todo);
    }
}

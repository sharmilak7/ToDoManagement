package com.project.todomanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.todomanagement.pojo.TbTaskDetails;

@Service
public interface TaskService {

	List<TbTaskDetails> getTodosByUser(String user);

    Optional<TbTaskDetails> getTodoById(long id);

    void updateTodo(TbTaskDetails TbTaskDetails);

    void deleteTodo(long id);

    void saveTodo(TbTaskDetails TbTaskDetails);
}

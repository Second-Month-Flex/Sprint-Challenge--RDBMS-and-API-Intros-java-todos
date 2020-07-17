package com.lambdaschool.todos.services;

import com.lambdaschool.todos.models.Todos;
import com.lambdaschool.todos.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service(value = "TodosService")
public class TodosServiceImp implements TodosService{

    @Autowired
    TodoRepository todoRepository;

    @Override
    public Todos markComplete(long todoid) {

        Todos currentTodo = todoRepository.findById(todoid)
                .orElseThrow(()-> new EntityNotFoundException("Todo " + todoid + " Not Found"));

        currentTodo.setCompleted(true);
        return currentTodo;
    }


}

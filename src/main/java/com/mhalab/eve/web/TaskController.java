package com.mhalab.eve.web;

import com.mhalab.eve.domain.Task;
import com.mhalab.eve.domain.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {
    @Autowired
    private TaskRepository taskRepository;

    @RequestMapping("/tasks")
    public Iterable<Task> getTasks() {
        return taskRepository.findAll();
    }
}

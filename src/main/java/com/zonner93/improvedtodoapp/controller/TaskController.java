package com.zonner93.improvedtodoapp.controller;

import com.zonner93.improvedtodoapp.model.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@RepositoryRestController
@RequiredArgsConstructor
public class TaskController {
    private final static Logger logger = LoggerFactory.getLogger(TaskController.class);
    private final TaskRepository taskRepository;

    @GetMapping(value = "/tasks", params = {"!sort", "!page", "!size"})
    ResponseEntity<?> readAllTasks(){
        logger.warn("Exposing all the tasks.");
        return ResponseEntity.ok(taskRepository.findAll());
    }
}

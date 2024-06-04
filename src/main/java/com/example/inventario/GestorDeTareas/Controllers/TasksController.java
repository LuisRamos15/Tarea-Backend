package com.example.inventario.GestorDeTareas.Controllers;

import com.example.inventario.GestorDeTareas.DTOs.TaskDTO;
import com.example.inventario.GestorDeTareas.Services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/task", consumes = "application/json")
public class TasksController {

    @Autowired
    private TaskService taskService;

    @GetMapping(value = "/task")
    public ResponseEntity<String> hi() {
        return ResponseEntity.ok("Hola");
    }

    @PostMapping(value = "/user/{userId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createTask(@RequestBody TaskDTO taskDTO, @PathVariable(value = "userId") long userId) {
        return taskService.createNewTask(taskDTO, userId);
    }

}

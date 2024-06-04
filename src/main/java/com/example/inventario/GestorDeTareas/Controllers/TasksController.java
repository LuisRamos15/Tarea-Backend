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

    @PostMapping(value = "/user/{userId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createTask(@RequestBody TaskDTO taskDTO, @PathVariable(value = "userId") long userId) {
        return taskService.createNewTask(taskDTO, userId);
    }
    @PutMapping(value = "/user/{userId}/task/{taskId}")
    public ResponseEntity<?> updateTask(@RequestBody TaskDTO taskDTO, @PathVariable(value = "userId") long userId, @PathVariable(value = "taskId") long taskId) {
        return taskService.updateTask(taskDTO, taskId, userId);
    }

    @DeleteMapping(value = "/user/{userId}/task/{taskId}")
    public ResponseEntity<?> deleteTask(@PathVariable(value = "userId") long userId, @PathVariable(value = "taskId") long taskId) {
        return taskService.deleteTask(taskId, userId);
    }
    @GetMapping(value = "/user/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllTasksByUserId(@PathVariable(value = "userId") long userId) {
        return taskService.getAllTasksByUserId(userId);
    }

}

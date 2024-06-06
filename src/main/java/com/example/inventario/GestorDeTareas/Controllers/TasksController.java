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

    @GetMapping(value = "/user/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllTaskByUserId(@PathVariable(value = "userId") long userId) {
        return taskService.getAllTaskByUserId(userId);
    }
  
    @PostMapping(value = "/user/{userId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createTask(@RequestBody TaskDTO taskDTO, @PathVariable(value = "userId") long userId) {
        return taskService.createNewTask(taskDTO, userId);
    }

    @PutMapping(value = "/user/{userId}/task/{taskId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateTask(@RequestBody TaskDTO taskDTO, @PathVariable(value = "userId") long userId, @PathVariable(value = "taskId") long taskId) {
        return taskService.updateTask(taskDTO, userId, taskId);
    }

    @DeleteMapping(value = "/user/{userId}/task/{taskId}")
    public ResponseEntity<?> deleteTask(@PathVariable(value = "userId") long userId, @PathVariable(value = "taskId") long taskId) {
        return taskService.deleteTask(userId, taskId);
    }



}

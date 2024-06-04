package com.example.inventario.GestorDeTareas.Services;

import com.example.inventario.GestorDeTareas.DTOs.TaskDTO;
import com.example.inventario.GestorDeTareas.Models.TaskModel;
import com.example.inventario.GestorDeTareas.Repositories.TasksRepositorie;
import com.example.inventario.GestorDeTareas.Utilities.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    @Autowired
    private TasksRepositorie tasksRepositorie;

    @Autowired
    private TaskMapper taskMapper;

    public ResponseEntity<?> createNewTask(TaskDTO taskDTO, Long userId) {
        try {
            TaskModel task = taskMapper.toTaskModel(taskDTO);

            if (task.getId() == null) {
                return new ResponseEntity<>("La tarea ya existe", HttpStatus.NOT_FOUND);
            }

            task.setUserId(userId);

            tasksRepositorie.save(task);

            return new ResponseEntity<>("Tarea creada satisfactoriamente!", HttpStatus.CREATED);

        } catch (Exception error) {
            return new ResponseEntity<>("Error inesperado " + error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

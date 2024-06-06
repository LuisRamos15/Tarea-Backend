package com.example.inventario.GestorDeTareas.Services;

import com.example.inventario.GestorDeTareas.DTOs.TaskDTO;
import com.example.inventario.GestorDeTareas.Models.TaskModel;
import com.example.inventario.GestorDeTareas.Repositories.TasksRepositorie;
import com.example.inventario.GestorDeTareas.Utilities.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TasksRepositorie tasksRepositorie;

    @Autowired
    private TaskMapper taskMapper;

    public ResponseEntity<?> getAllTaskByUserId(Long userId) {
        try {
            List<TaskModel> tasks = tasksRepositorie.getAllTaskByUserid(userId);
            List<TaskDTO> taskDTOs = tasks.stream().map(taskMapper::toTaskDTO).toList();

            return new ResponseEntity<>(taskDTOs, HttpStatus.OK);

        } catch (Exception error) {
            return new ResponseEntity<>("Error inesperado " + error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

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

    public ResponseEntity<?> updateTask(TaskDTO taskDTO, Long taskId, Long userId) {
        try {
            Optional<TaskModel> optionalTask = tasksRepositorie.findById(taskId);

            if (optionalTask.isEmpty()) {
                return new ResponseEntity<>("La tarea no existe", HttpStatus.NOT_FOUND);
            }

            TaskModel task = optionalTask.get();

            if (!task.getUserId().equals(userId)) {
                return new ResponseEntity<>("No autorizado", HttpStatus.UNAUTHORIZED);
            }

            task.setTitle(taskDTO.getTitle());
            task.setDescription(taskDTO.getDescription());
            task.setPriority(taskDTO.getPriority());
            task.setCategory(taskDTO.getCategory());
            task.setStatus(taskDTO.getStatus());
            task.setExpiry_date(taskDTO.getExpiry_date());

            tasksRepositorie.save(task);

            return new ResponseEntity<>("Tarea actualizada satisfactoriamente!", HttpStatus.OK);

        } catch (Exception error) {
            return new ResponseEntity<>("Error inesperado " + error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> deleteTask(Long taskId, Long userId) {
        try {
            Optional<TaskModel> optionalTask = tasksRepositorie.findById(taskId);

            if (optionalTask.isEmpty()) {
                return new ResponseEntity<>("La tarea no existe", HttpStatus.NOT_FOUND);
            }

            TaskModel task = optionalTask.get();

            if (!task.getUserId().equals(userId)) {
                return new ResponseEntity<>("No autorizado", HttpStatus.UNAUTHORIZED);
            }

            tasksRepositorie.delete(task);

            return new ResponseEntity<>("Tarea eliminada satisfactoriamente!", HttpStatus.OK);

        } catch (Exception error) {
            return new ResponseEntity<>("Error inesperado " + error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

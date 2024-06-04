package com.example.inventario.GestorDeTareas.Utilities;

import com.example.inventario.GestorDeTareas.DTOs.TaskDTO;
import com.example.inventario.GestorDeTareas.Models.TaskModel;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {

    public TaskDTO toTaskDTO(TaskModel taskModel) {
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setId(taskModel.getId());
        taskDTO.setUserId(taskModel.getUserId());
        taskDTO.setTitle(taskModel.getTitle());
        taskDTO.setDescription(taskModel.getDescription());
        taskDTO.setPriority(taskModel.getPriority());
        taskDTO.setCategory(taskModel.getCategory());
        taskDTO.setStatus(taskModel.getStatus());
        taskDTO.setExpiry_date(taskModel.getExpiry_date());
        return taskDTO;
    }

    public TaskModel toTaskModel(TaskDTO taskDTO) {
        TaskModel taskModel = new TaskModel();
        taskModel.setId(taskDTO.getId());
        taskModel.setUserId(taskDTO.getUserId());
        taskModel.setTitle(taskDTO.getTitle());
        taskModel.setDescription(taskDTO.getDescription());
        taskModel.setPriority(taskDTO.getPriority());
        taskModel.setCategory(taskDTO.getCategory());
        taskModel.setStatus(taskDTO.getStatus());
        taskModel.setExpiry_date(taskDTO.getExpiry_date());
        return taskModel;
    }


}

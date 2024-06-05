package com.example.inventario.GestorDeTareas.Repositories;

import com.example.inventario.GestorDeTareas.Models.TaskModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TasksRepositorie extends JpaRepository<TaskModel, Long> {
}

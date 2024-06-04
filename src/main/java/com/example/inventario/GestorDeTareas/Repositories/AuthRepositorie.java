package com.example.inventario.GestorDeTareas.Repositories;

import com.example.inventario.GestorDeTareas.Models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepositorie extends JpaRepository<UserModel, Long> {

    UserModel findByEmail(String email);

}

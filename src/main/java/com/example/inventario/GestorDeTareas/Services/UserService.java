package com.example.inventario.GestorDeTareas.Services;

import com.example.inventario.GestorDeTareas.Repositories.AuthRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private AuthRepositorie authRepositorie;

    public void getUserInfo() {

    }

}

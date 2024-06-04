package com.example.inventario.GestorDeTareas.Services;

import com.example.inventario.GestorDeTareas.Models.UserModel;
import com.example.inventario.GestorDeTareas.Utilities.JwtGenerate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JwtService {

    private final JwtGenerate jwtGenerate;

    @Autowired
    public JwtService(JwtGenerate jwtGenerate) {
        this.jwtGenerate = jwtGenerate;
    }

    public String generateToken(UserModel userModel) {
        return jwtGenerate.generateToken(userModel);
    }

}

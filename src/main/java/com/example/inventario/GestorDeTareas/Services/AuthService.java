package com.example.inventario.GestorDeTareas.Services;

import com.example.inventario.GestorDeTareas.DTOs.AuthLoginResponse;
import com.example.inventario.GestorDeTareas.DTOs.UserDTO;
import com.example.inventario.GestorDeTareas.Models.UserModel;
import com.example.inventario.GestorDeTareas.Repositories.AuthRepositorie;
import com.example.inventario.GestorDeTareas.Utilities.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private AuthRepositorie authRepositorie;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private JwtService jwtService;

    public ResponseEntity<?> register(UserDTO userDTO) {
        try {
            UserModel userModel = userMapper.toUserModel(userDTO);

            if (userModel.getEmail() == null) {
                return new ResponseEntity<>("El usuario ya existe", HttpStatus.NOT_FOUND);
            }

            authRepositorie.save(userModel);

            return new ResponseEntity<>("usuario creado satisfactoriamente!", HttpStatus.CREATED);

        } catch (Exception error) {
            return new ResponseEntity<>("Error inesperado" + error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> login(UserDTO userDTO) {
        try {
            UserModel user = authRepositorie.findByEmail(userDTO.getEmail());

            if (userDTO.getEmail() == null) {
                return new ResponseEntity<>("El usuario ya existe", HttpStatus.NOT_FOUND);
            }

            String token = jwtService.generateToken(user);

            AuthLoginResponse response = new AuthLoginResponse(token, user.getId());

            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (Exception error) {
            return new ResponseEntity<>("Error inesperado " + error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

package com.example.inventario.GestorDeTareas.Utilities;

import com.example.inventario.GestorDeTareas.DTOs.UserDTO;
import com.example.inventario.GestorDeTareas.Models.UserModel;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDTO toUserDTO(UserModel userModel) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(userModel.getId());
        userDTO.setUsername(userModel.getUsername());
        userDTO.setEmail(userModel.getEmail());
        userDTO.setPassword(userModel.getPassword());
        return userDTO;
    }

    public UserModel toUserModel(UserDTO userDTO) {
        UserModel userModel = new UserModel();
        userModel.setId(userDTO.getId());
        userModel.setUsername(userDTO.getUsername());
        userModel.setEmail(userDTO.getEmail());
        userModel.setPassword(userDTO.getPassword());
        return userModel;
    }

}

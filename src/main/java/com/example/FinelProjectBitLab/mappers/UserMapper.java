package com.example.FinelProjectBitLab.mappers;

import com.example.FinelProjectBitLab.DTO.UserDTO;
import com.example.FinelProjectBitLab.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toDTO(User user);
    User user(UserDTO userDTO);
}

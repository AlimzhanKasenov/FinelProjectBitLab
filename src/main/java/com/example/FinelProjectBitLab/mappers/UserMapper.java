package com.example.FinelProjectBitLab.mappers;

import com.example.FinelProjectBitLab.DTO.UserDTO;
import com.example.FinelProjectBitLab.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User userEntity(UserDTO userDTO);
    UserDTO userDTO(User user);
}

package com.example.FinelProjectBitLab.mappers;

import com.example.FinelProjectBitLab.DTO.RoleDTO;
import com.example.FinelProjectBitLab.model.Role;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    RoleDTO roleDTO(Role role);
    Role roleEntity(RoleDTO roleDTO);
    List<RoleDTO> roleListDTO(List<Role> roles);
    List<Role> roleList(List<RoleDTO> roleDTOList);
}

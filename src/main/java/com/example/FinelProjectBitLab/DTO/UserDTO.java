package com.example.FinelProjectBitLab.DTO;

import com.example.FinelProjectBitLab.model.Role;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserDTO {
    private Long id;
    private String email;
    private String fullName;
    private List<Role> role;
}

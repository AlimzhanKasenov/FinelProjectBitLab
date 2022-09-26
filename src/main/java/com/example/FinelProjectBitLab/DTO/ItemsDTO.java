package com.example.FinelProjectBitLab.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemsDTO {

    private Long id;
    private String nameItem;
    private String description;
    private Long price;
    private String picture;
    private UserDTO author;
}

package com.example.FinelProjectBitLab.mappers;

import com.example.FinelProjectBitLab.DTO.ItemsDTO;
import com.example.FinelProjectBitLab.DTO.RoleDTO;
import com.example.FinelProjectBitLab.model.Items;
import com.example.FinelProjectBitLab.model.Role;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemsMapper {

    ItemsDTO itemDTO(Items items);
    Items itemEntity(ItemsDTO itemsDTO);
    List<ItemsDTO> itemListDTO(List<Items> itemsList);
    List<Items> ItemList(List<ItemsDTO> dtoList);
}

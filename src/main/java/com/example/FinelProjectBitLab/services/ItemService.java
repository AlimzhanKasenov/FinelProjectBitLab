package com.example.FinelProjectBitLab.services;

import com.example.FinelProjectBitLab.DTO.ItemsDTO;
import com.example.FinelProjectBitLab.model.Items;

import java.util.List;

public interface ItemService {
    List<ItemsDTO> getAllItems();
    ItemsDTO getItemById(Long id);
    Items addItem(Items item);
    ItemsDTO updateItem(Items items);
    void deletItem(Long id);
    ItemsDTO updateItemControl(Long id, String nameItem, String description, Long price);
}

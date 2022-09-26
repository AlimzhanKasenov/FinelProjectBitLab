package com.example.FinelProjectBitLab.services;

import com.example.FinelProjectBitLab.DTO.ItemsDTO;
import com.example.FinelProjectBitLab.model.Items;
import com.example.FinelProjectBitLab.model.User;

import java.util.List;

public interface ItemService {
    List<Items> getAllItems();
    Items getItemById(Long id);
    Items addItem(Items item);
    Items updateItem(Items items);
    void deletItem(Long id);
}

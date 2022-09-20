package com.example.FinelProjectBitLab.services;

import com.example.FinelProjectBitLab.model.Items;
import com.example.FinelProjectBitLab.model.User;

import java.util.List;

public interface ItemService {
    List<Items> getAllItems();
    Items getItemById(Long id);
}

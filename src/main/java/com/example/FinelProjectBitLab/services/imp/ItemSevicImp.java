package com.example.FinelProjectBitLab.services.imp;

import com.example.FinelProjectBitLab.DTO.ItemsDTO;
import com.example.FinelProjectBitLab.mappers.ItemsMapper;
import com.example.FinelProjectBitLab.model.Items;
import com.example.FinelProjectBitLab.model.User;
import com.example.FinelProjectBitLab.repository.ItemRepos;
import com.example.FinelProjectBitLab.repository.UserRepos;
import com.example.FinelProjectBitLab.services.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemSevicImp implements ItemService {
    private final ItemRepos itemRepos;
    private final UserRepos userRepos;
    private final ItemsMapper itemsMapper;


    public List<ItemsDTO> getAllItems() {
        return itemsMapper.itemListDTO(itemRepos.findAll());
    }

    public ItemsDTO getItemById(Long id) {
        return itemsMapper.itemDTO(itemRepos.findById(id).orElseThrow());
    }

    public Items addItem(Items item) {
        return itemRepos.save(item);
    }

    public ItemsDTO updateItem(Items item) {
        return itemsMapper.itemDTO(itemRepos.save(item));
    }

    public void deletItem(Long id) {
        itemRepos.deleteById(id);
    }

    public ItemsDTO updateItemControl(Long id, String nameItem, String description, Long price) {
        Items item = itemRepos.findById(id).orElse(null);
        if (item != null) {
            item.setNameItem(nameItem);
            item.setDescription(description);
            item.setPrice(price);
            itemRepos.save(item);
            return itemsMapper.itemDTO(itemRepos.findById(id).orElse(null));
        } else {
            return null;
        }
    }

    public ItemsDTO addItemControl(Long author_id, String nameItem, String description, Long price, String picture) {
        User user = userRepos.findById(author_id).orElse(null);
        if (user != null) {
            Items item = new Items();
            item.setNameItem(nameItem);
            item.setDescription(description);
            item.setPrice(price);
            item.setPicture(picture);
            item.setAuthor(user);
            return itemsMapper.itemDTO(itemRepos.save(item));
        } else {
            return null;
        }
    }
}

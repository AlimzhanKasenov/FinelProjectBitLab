package com.example.FinelProjectBitLab.services.imp;

import com.example.FinelProjectBitLab.model.Items;
import com.example.FinelProjectBitLab.repository.ItemRepos;
import com.example.FinelProjectBitLab.services.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemSevicImp implements ItemService {
    private final ItemRepos itemRepos;

    public List<Items> getAllItems(){
        return itemRepos.findAll();
    }

    public Items getItemById(Long id){
        return itemRepos.findById(id).orElseThrow();
    }

    public Items addItem(Items item) {
        return itemRepos.save(item);
    }

    public Items updateItem(Items item){
        return itemRepos.save(item);
    }

    public void deletItem(Long id){
        itemRepos.deleteById(id);
    }
}

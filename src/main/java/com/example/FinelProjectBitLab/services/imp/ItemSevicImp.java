package com.example.FinelProjectBitLab.services.imp;

import com.example.FinelProjectBitLab.model.Items;
import com.example.FinelProjectBitLab.repository.ItemRepos;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemSevicImp {
    private final ItemRepos itemRepos;

    public List<Items> getAllItems(){
        return itemRepos.findAll();
    }

    public Items getItemById(Long id){
        return itemRepos.findById(id).orElse(null);
    }
}

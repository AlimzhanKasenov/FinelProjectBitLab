package com.example.FinelProjectBitLab.API;

import com.example.FinelProjectBitLab.DTO.ItemsDTO;
import com.example.FinelProjectBitLab.mappers.ItemsMapper;
import com.example.FinelProjectBitLab.model.Items;
import com.example.FinelProjectBitLab.services.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping(value = "/api")
public class RestControl {
    private final ItemService itemService;


    @GetMapping
    public ResponseEntity<List<ItemsDTO>> getAllItems(){
        List<ItemsDTO> items = itemService.getAllItems();
        return new ResponseEntity<> (items, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ItemsDTO> getCourse(@PathVariable(name = "id") Long id) {
        ItemsDTO item = itemService.getItemById(id);
        if (item != null) {
            return new ResponseEntity<>(item, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "/addItem")
    public ItemsDTO addItem(@RequestBody Items item){
        return itemService.addItem(item);
    }

    @PutMapping(value = "/update")
    public ItemsDTO updateItem(@RequestBody Items item){
        return itemService.updateItem(item);
    }

    @DeleteMapping("/delet")
    public void deletItem(@PathVariable(value = "id")Long id){
        itemService.deletItem(id);
    }
}

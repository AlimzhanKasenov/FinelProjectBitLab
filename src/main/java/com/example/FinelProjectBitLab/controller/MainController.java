package com.example.FinelProjectBitLab.controller;

import com.example.FinelProjectBitLab.services.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final ItemService itemService;

    @GetMapping(value = "/")
    private String mainPage(Model model){
        model.addAttribute("items", itemService.getAllItems());
        return "MainPage";
    }

    @GetMapping(value = "/details/{id}")
    private String details(@PathVariable(name = "id") Long id, Model model){
        model.addAttribute("item", itemService.getItemById(id));
        return "DetailsItem";
    }


    @PostMapping(value = "/editPage")
    private String editPage(@RequestParam(name = "id") Long id, Model model){
        model.addAttribute("editItem", itemService.getItemById(id));
        return "EditPage";
    }

    // @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @PostMapping(value = "/edit")
    private String editItem(@RequestParam(name = "id") Long id,
                            @RequestParam(name = "nameItem") String nameItem,
                            @RequestParam(name = "description") String description,
                            @RequestParam(name = "price") Long price,
                            Model model){
        itemService.updateItemControl(id, nameItem, description, price);
        model.addAttribute("item", itemService.getItemById(id));
        return "DetailsItem";
    }


    @PostMapping(value = "/delete")
    private String edit(@RequestParam(name = "id") Long id){
        itemService.deletItem(id);
        return "redirect:/";
    }

    @GetMapping(value = "/forbidden")
    private String forbiddenPage(){
        return "ForbiddenPage";
    }

    @GetMapping("/signin")
    public String authorization(){
        return "Authorization";
    }

    //@PreAuthorize("isAuthenticated()")
    @GetMapping(value = "/mainPage")
    private String mainPage(){
        return "VhodPage";
    }
}
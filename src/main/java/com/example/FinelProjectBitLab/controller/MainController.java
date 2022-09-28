package com.example.FinelProjectBitLab.controller;

import com.example.FinelProjectBitLab.model.User;
import com.example.FinelProjectBitLab.services.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
    public String mainPage(Model model){
        model.addAttribute("items", itemService.getAllItems());
        return "MainPage";
    }


    @GetMapping(value = "/details/{id}")
    public String details(@PathVariable(name = "id") Long id, Model model){
        model.addAttribute("item", itemService.getItemById(id));
        return "DetailsItem";
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @PostMapping(value = "/editPage")
    public String editPage(@RequestParam(name = "id") Long id, Model model){
        model.addAttribute("editItem", itemService.getItemById(id));
        return "EditPage";
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @PostMapping(value = "/edit")
    public String editItem(@RequestParam(name = "id") Long id,
                            @RequestParam(name = "nameItem") String nameItem,
                            @RequestParam(name = "description") String description,
                            @RequestParam(name = "price") Long price,
                            Model model){
        itemService.updateItemControl(id, nameItem, description, price);
        model.addAttribute("item", itemService.getItemById(id));
        return "DetailsItem";
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @PostMapping(value = "/delete")
    public String edit(@RequestParam(name = "id") Long id){
        itemService.deletItem(id);
        return "redirect:/";
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @PostMapping(value = "/cancel")
    public String cancel(Model model){
        model.addAttribute("items", itemService.getAllItems());
        return "MainPage";
    }


    @GetMapping(value = "/forbidden")
    public String forbiddenPage(){
        return "ForbiddenPage";
    }


    @GetMapping("/signin")
    public String authorization(){
        return "Authorization";
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping(value = "/mainPage")
    public String mainPage(){
        return "VhodPage";
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @PostMapping(value = "/addItem")
    public String addItem(@RequestParam(name = "nameItem") String nameItem,
                           @RequestParam(name = "description") String description,
                           @RequestParam(name = "price") Long price,
                           @RequestParam(name = "picture") String picture){
            itemService.addItemControl(getCurrentUser().getId(),nameItem, description, price, picture);
        return "redirect:/";
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping(value = "/addPage")
    public String addPage(){
        return "AddItemPage";
    }

    public User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            return (User) authentication.getPrincipal();
        }
        return null;
    }
    //@PreAuthorize("isAuthenticated()")
}
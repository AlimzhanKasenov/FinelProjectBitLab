package com.example.FinelProjectBitLab.controller;

import com.example.FinelProjectBitLab.API.RestControl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final RestControl restControl;

    @GetMapping(value = "/")
    private String mainPage(){
        return "redirect:/api/items";
    }

    @GetMapping(value = "/forbidden")
    private String forbiddenPage(){
        return "ForbiddenPage";
    }
}

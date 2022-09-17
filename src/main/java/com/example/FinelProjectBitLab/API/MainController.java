package com.example.FinelProjectBitLab.API;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MainController {



    @GetMapping(value = "/")
    private String mainPage(){
        return "MainPage";
    }

    @GetMapping(value = "/forbidden")
    private String forbiddenPage(){
        return "ForbiddenPage";
    }
}

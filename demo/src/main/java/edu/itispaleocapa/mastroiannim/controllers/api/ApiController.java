package edu.itispaleocapa.mastroiannim.controllers.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {
    
    @GetMapping("/api")
    public String index(){
        return "index";
    }
}

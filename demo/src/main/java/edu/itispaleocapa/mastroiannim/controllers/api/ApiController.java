package edu.itispaleocapa.mastroiannim.controllers.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.itispaleocapa.mastroiannim.services.UsersService;

@RestController
public class ApiController {

    private final UsersService usersService;

    @Autowired
    public ApiController(UsersService usersService) {
        this.usersService = usersService;
    }

    
    @GetMapping("/api")
    public String index(){
        return "index";
    }

    @GetMapping("/api/users")
    public String getUsers(){
        return usersService.getUsers();
    }
}

package edu.itispaleocapa.mastroiannim.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import edu.itispaleocapa.mastroiannim.controllers.api.LoginController;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class TemplateController {
        
    private static final Logger LOG = LoggerFactory.getLogger(TemplateController.class);


    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/dashboard")
    public ModelAndView dashboard(HttpServletRequest request) {   
        // Add any additional logic or data retrieval for the dashboard
                
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("dashboard");
       
        LoginController.LoginForm loginForm = (LoginController.LoginForm) request.getSession().getAttribute("loginForm");
        modelAndView.addObject("username", loginForm.getUsername());

        LOG.info(loginForm.getUsername());
        // Create the ModelAndView object with the result view and form model
        return modelAndView;
    }

}

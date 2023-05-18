package edu.itispaleocapa.mastroiannim.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TemplateController {
        
    private static final Logger LOG = LoggerFactory.getLogger(TemplateController.class);


    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/dashboard")
    public ModelAndView dashboard(ModelAndView modelAndView) {
        // Get the username parameter from the ModelAndView
        String username = (String) modelAndView.getModel().get("username");

        LOG.info(username);
        // Add any additional logic or data retrieval for the dashboard

        // Return the ModelAndView
        return modelAndView;
    }
}

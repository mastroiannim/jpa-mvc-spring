package edu.itispaleocapa.mastroiannim.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import edu.itispaleocapa.mastroiannim.controllers.api.LoginController;
import jakarta.servlet.http.HttpSession;

@Controller
public class TemplateController {
        
    private static final Logger LOG = LoggerFactory.getLogger(TemplateController.class);


    @GetMapping("/")
    public ModelAndView index(@ModelAttribute("errorMessage") String errorMessage, HttpSession session){

        LOG.info(session.getId());
        ModelAndView modelAndView = new ModelAndView();

        LoginController.LoginForm loginForm = (LoginController.LoginForm) session.getAttribute("loginForm");
        if(loginForm != null){
            RedirectView redirectView = new RedirectView("dashboard");
            modelAndView.setView(redirectView);            
            LOG.info(loginForm.getUsername());
        }else{
            modelAndView.setViewName("index");
        }
        return modelAndView;
    }

    @GetMapping("/dashboard")
    public ModelAndView dashboard(HttpSession session) {   
        // Add any additional logic or data retrieval for the dashboard
        LOG.info(session.getId());
        ModelAndView modelAndView = new ModelAndView();
       
        LoginController.LoginForm loginForm = (LoginController.LoginForm) session.getAttribute("loginForm");
        if(loginForm != null){
            modelAndView.setViewName("dashboard");
            modelAndView.addObject("username", loginForm.getUsername());
            LOG.info(loginForm.getUsername());
        }else{
            RedirectView redirectView = new RedirectView("");
            modelAndView.setView(redirectView);     
        }
        // Create the ModelAndView object with the result view and form model
        return modelAndView;
    }

}

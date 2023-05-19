package edu.itispaleocapa.mastroiannim.controllers.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import edu.itispaleocapa.mastroiannim.services.LoginService;
import jakarta.servlet.http.HttpSession;

@RestController
public class LoginController {
    
    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ModelAndView login(@ModelAttribute("loginForm") LoginForm loginForm,  HttpSession session) {
        
        ModelAndView modelAndView = new ModelAndView();

        // Process the form data and perform login logic using the LoginService

        // Example login logic
        boolean loginSuccessful = loginService.authenticate(loginForm.getUsername(), loginForm.getPassword());

        if (loginSuccessful) {

            //save in session
            session.setAttribute("loginForm", loginForm);

            // Redirect to a different URL on successful login
            RedirectView redirectView = new RedirectView("dashboard");
            modelAndView.setView(redirectView);

        } else {
            // Add an error message to the model and return the login template
            modelAndView.setViewName("index");  // the name of your login template
            modelAndView.addObject("errorMessage", "Invalid credentials");
        }

        return modelAndView;
    }


    public static class LoginForm {
        private String username;
        private String password;

        // Constructors, getters, and setters

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}

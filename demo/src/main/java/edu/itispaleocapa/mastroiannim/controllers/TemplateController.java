package edu.itispaleocapa.mastroiannim.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import edu.itispaleocapa.mastroiannim.controllers.api.LoginController;
import edu.itispaleocapa.mastroiannim.entity.Chat;
import edu.itispaleocapa.mastroiannim.entity.Message;
import edu.itispaleocapa.mastroiannim.services.ChatService;
import edu.itispaleocapa.mastroiannim.services.MessageService;
import jakarta.servlet.http.HttpSession;

import org.springframework.http.MediaType;
//import org.springframework.messaging.handler.annotation.SendTo;


@Controller
public class TemplateController {
        
    private static final Logger LOG = LoggerFactory.getLogger(TemplateController.class);
    private final ChatService chatService;
    private final MessageService messageService;

    public TemplateController(ChatService chatService, MessageService messageService) {
        this.chatService = chatService;
        this.messageService = messageService;
    }

    @GetMapping("/")
    public ModelAndView index(@ModelAttribute("errorMessage") String errorMessage, HttpSession session){

        LOG.info(session.getId());
        ModelAndView modelAndView = new ModelAndView();

        LoginController.LoginForm loginForm = (LoginController.LoginForm) session.getAttribute("loginForm");
        if(loginForm != null){
            RedirectView redirectView = new RedirectView("/dashboard");
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
            List<Chat> chats = chatService.getChatsByUsername(loginForm.getUsername());
            modelAndView.addObject("chats", chats);
            LOG.info(chats.toString());
            
        }else{
            RedirectView redirectView = new RedirectView("/");
            modelAndView.setView(redirectView);     
        }
        // Create the ModelAndView object with the result view and form model
        return modelAndView;
    }

    @GetMapping("/chat/{id}/message")
    public ModelAndView getChatMessages(@PathVariable("id") Long chatId, HttpSession session) {
        // Use the chatId as needed
        ModelAndView modelAndView = new ModelAndView();
        LoginController.LoginForm loginForm = (LoginController.LoginForm) session.getAttribute("loginForm");
        if(loginForm != null){
            modelAndView.addObject("username", loginForm.getUsername());
            modelAndView.setViewName("chat");
            modelAndView.addObject("messages", messageService.getMessagesByChatId(chatId));
            modelAndView.addObject("chatId", chatId);


        }else{
            RedirectView redirectView = new RedirectView("/");
            modelAndView.setView(redirectView);     
        }
        return modelAndView;
    }

    //@SendTo("/topic/messages")
    @PostMapping(value = "/chat/{id}/message", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ModelAndView postChatMessage(@PathVariable("id") Long chatId, @ModelAttribute("content") String message, HttpSession session) {
        // Use the chatId and message as needed
        ModelAndView modelAndView = new ModelAndView();
        LoginController.LoginForm loginForm = (LoginController.LoginForm) session.getAttribute("loginForm");
        if(loginForm != null){
            RedirectView redirectView = new RedirectView("/chat/"+chatId+"/message");
            modelAndView.setView(redirectView);
            //modelAndView.setViewName("chat");
            modelAndView.addObject("messages", messageService.getMessagesByChatId(chatId));
            Message newMsg = messageService.saveMessage(message, chatId, loginForm.getUsername());
            modelAndView.addObject("message", newMsg);
        }else{
            RedirectView redirectView = new RedirectView("/");
            modelAndView.setView(redirectView);     
        }
        return modelAndView;
    }

}

package com.example.demo.controllers;

import com.example.demo.beans.Challenge;
import com.example.demo.beans.User;
import com.example.demo.repositories.ChallegneRepository;
import com.example.demo.repositories.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;

@Controller
public class HomeController {

  @Autowired
  private UserService userService;

  @Autowired
  ChallegneRepository challegneRepository;

@Autowired
  UserRepository userRepository;

  @RequestMapping("/")
  public String index(Model model){
    model.addAttribute("challenges", challegneRepository.findAll());
    return "index";
  }

  @RequestMapping("/login")
  public String login(){
    return "login";
  }

  @RequestMapping(value = "/register", method = RequestMethod.GET)
  public String showRegistrationPage(Model model) {
    model.addAttribute("user", new User());
    return "registration";
  }

  @RequestMapping(value="/register", method=RequestMethod.POST)
  public String processRegistrationPage(@Valid @ModelAttribute("user")
                                                User user, BindingResult result, Model model) {
    model.addAttribute("user", new User());
    if (result.hasErrors()) {
      return "registration";
    }
    else {
      userService.saveUser(user);
    }
    return "index";
  }



  @GetMapping("/addchallenge")
  public String getChallege(Model model){
    model.addAttribute("challenge", new Challenge());
    return "challenge";
  }

  @PostMapping("/processchallenge")
  public String processChallegne(Challenge challenge){
    challegneRepository.save(challenge);
    return "redirect:";
  }

  private User getUser(){
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    String currentusername =  authentication.getName();
    User user = userRepository.findByUsername(currentusername);
    return user;
  }

}

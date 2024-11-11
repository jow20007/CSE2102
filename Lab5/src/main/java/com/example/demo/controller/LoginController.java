package com.example.demo.controller;

import com.example.demo.model.Login;
import com.example.demo.PasswordChecker;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class LoginController {
  private String serverURL = "";
  // private String serverURL = "https://turbo-bassoon-7vrqp59xvr4rcr7q5-8080.app.github.dev";
  private PasswordChecker pwChecker = new PasswordChecker();

  @GetMapping("/")
  public String home(Model model) {
    model.addAttribute("login", new Login());
    model.addAttribute("loginFailed", false);
    return "login"; // for login.html
  }

  @PostMapping("/")
  public String homePost(@ModelAttribute Login login, Model model) {
    System.out.println(login.getUsername());
    System.out.println(login.getPassword());
    if (pwChecker.validPassword(login.getPassword())) {
      return String.format("redirect:%s/quiz", serverURL); // for quiz.html at /quiz
    }
    model.addAttribute("login", login);
    model.addAttribute("loginFailed", true);
    return "login"; // for login.html
  }
}
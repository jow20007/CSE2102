package com.example.demo.controller;

import com.example.demo.model.Email;
import com.example.demo.EmailChecker;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class EmailController {
  private EmailChecker eChecker = new EmailChecker();

  @GetMapping("/email")
  public String home(Model model) {
    model.addAttribute("email", new Email());
    return "email"; // for login.html
  }

  @PostMapping("/email")
  public String homePost(@ModelAttribute Email e, Model model) {
    System.out.println(e.getEmail());
    if (eChecker.validEmail(e.getEmail())) {
      model.addAttribute("emailFailed", false);
      model.addAttribute("emailSuccess", true);
    } else {
      model.addAttribute("emailFailed", true);
      model.addAttribute("emailSuccess", false);
    }
    return "email"; // for email.html
  }
}
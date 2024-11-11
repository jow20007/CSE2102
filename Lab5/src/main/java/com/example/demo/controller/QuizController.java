package com.example.demo.controller;

import com.example.demo.QuestionGenerator;
import com.example.demo.model.Quiz;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class QuizController {
  private QuestionGenerator qGen = new QuestionGenerator();

  @GetMapping("/quiz")
  public String quiz(Model model) {
    Quiz q = new Quiz();
    
    int qIdx = qGen.seedIndex();
    q.setQIdx(qIdx);
    q.setQuestion(qGen.getQuestion(qIdx));
    
    model.addAttribute("quiz", q);
    return "quiz"; // for quiz.html
  }
  
  @PostMapping("/quiz")
  public String quizPost(@RequestParam("submit") String submitAction, @ModelAttribute Quiz q, Model model) {
    q.setAttempted(q.getAttempted() + 1);

    String expectedAns = qGen.getAnswer(q.getQIdx());
    if (submitAction.equals(expectedAns)) q.setCorrect(q.getCorrect() + 1);
    
    int qIdx = qGen.incIndex(q.getQIdx());
    q.setQIdx(qIdx);
    q.setQuestion(qGen.getQuestion(qIdx));

    model.addAttribute("quiz", q);
    return "quiz"; // for quiz.html
  }
}
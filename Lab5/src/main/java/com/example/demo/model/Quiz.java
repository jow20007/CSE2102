package com.example.demo.model;

public class Quiz {
  private String question;
  private int qIdx;
  private int correct;
  private int attempted;

  public String getQuestion() {
    return this.question;
  }
  public void setQuestion(String q) {
    this.question = q;
  }
  public int getQIdx() {
    return this.qIdx;
  }
  public void setQIdx(int q) {
    this.qIdx = q;
  }
  public int getAttempted() {
    return this.attempted;
  }
  public void setAttempted(int v) {
    this.attempted = v;
  }
  public int getCorrect() {
    return this.correct;
  }
  public void setCorrect(int v) {
    this.correct = v;
  }
  @Override
  public String toString() {
    return String.format("Quiz - c: %d, a: %d, q: %s", correct, attempted, question);
  }
}

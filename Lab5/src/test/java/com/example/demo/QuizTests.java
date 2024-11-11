package com.example.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.demo.controller.QuizController;
import com.example.demo.model.Quiz;
import com.fasterxml.jackson.databind.ObjectMapper;

	
// UTILS & MODELS
@SpringBootTest
class QuizTests {
	@Test 
	void quizModelTest() {
		String question = "Hello?";
		int correct = 10;
		int attempted = 20;
		int qIdx = 30;
		Quiz q = new Quiz();
		q.setQuestion(question);
		q.setCorrect(correct);
		q.setAttempted(attempted);
		q.setQIdx(qIdx);
		Assertions.assertEquals(question, q.getQuestion()); 
		Assertions.assertEquals(correct, q.getCorrect()); 
		Assertions.assertEquals(attempted, q.getAttempted()); 
		Assertions.assertEquals(qIdx, q.getQIdx()); 
	}
}

// CONTROLLER
@WebMvcTest(controllers = QuizController.class)
class QuizControllerTests {
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testGetQuiz() throws Exception {
		mockMvc.perform(get("/quiz"))
			.andExpect(status().isOk())
			.andExpect(model().attributeExists("quiz"))
			.andExpect(model().errorCount(0));
	}

	private void testQuestion(String submitValue) throws Exception {
		Quiz expected = new Quiz();
		expected.setAttempted(1);
		expected.setCorrect(submitValue == "False" ? 1 : 0);
		expected.setQIdx(1);
		expected.setQuestion("A stack is a Last-In-First-Out (LIFO) data structure.");

		Quiz q = new Quiz();
		MvcResult res = mockMvc.perform(post("/quiz")
					.param("submit", submitValue)
					.content(new ObjectMapper().writeValueAsString(q))
					.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(model().attributeExists("quiz"))
			.andReturn();

		Object actual = res.getModelAndView().getModel().get("quiz").toString();
		Assertions.assertEquals(expected.toString(), actual);
	}

	@Test
	public void testCorrectQuestion() throws Exception {
		testQuestion("False");
	}
	
	@Test
	public void testIncorrectQuestion() throws Exception {
		testQuestion("True");
	}
}
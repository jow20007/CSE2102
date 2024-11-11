package com.example.demo;

import org.junit.jupiter.api.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.example.demo.controller.EmailController;
import com.example.demo.model.Email;

	
// UTILS & MODELS
@SpringBootTest
class EmailTests {
	boolean checkEmail(String email) {
		EmailChecker checker = new EmailChecker();
		return checker.validEmail(email);
	}

	@Test 
	void emailCheckerTest1() {
		Assertions.assertTrue(checkEmail("example@ex.com"));
	}
	
	@Test 
	void emailCheckerTest2() {
		Assertions.assertTrue(checkEmail("xxdfgchvjbknkmlkljkbhvgcfx.sx.asx.asxasxx@xxx.xxx"));
	}

	@Test 
	void emailCheckerTest3() {
		Assertions.assertFalse(checkEmail("x@xxx."));
	}
	
	@Test 
	void emailCheckerTest4() {
		Assertions.assertFalse(checkEmail("abc@.com"));
	}

	@Test 
	void emailModelTest() {
		String expected = "example@ex.com";
		Email e = new Email();
		e.setEmail(expected);
		Assertions.assertEquals(expected, e.getEmail());
		e.setEmail("");
		Assertions.assertEquals("", e.getEmail());
	}
}


// CONTROLLER
@WebMvcTest(controllers = EmailController.class)
class EmailControllerTests {
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testGetEmail() throws Exception {
		mockMvc.perform(get("/email"))
			.andExpect(status().isOk())
			.andExpect(model().attributeExists("email"))
			.andExpect(model().errorCount(0));
	}

	private ResultActions mockCheckEmail(String email) throws Exception {
		return mockMvc.perform(post("/email")
					.formField("email", email)
					.contentType(MediaType.APPLICATION_FORM_URLENCODED));
	}

	@Test
	public void testValidEmail() throws Exception {
		mockCheckEmail("example@gmail.com")
		.andExpect(status().isOk())
		.andExpect(model().attribute("emailFailed", false))
		.andExpect(model().attribute("emailSuccess", true));
	}

	@Test
	public void testInvalidEmail() throws Exception {
		System.out.println(model());
		mockCheckEmail("x.x.x")
		.andExpect(status().isOk())
		.andExpect(model().attribute("emailFailed", true))
		.andExpect(model().attribute("emailSuccess", false));
	}
}
package com.example.demo;

import org.junit.jupiter.api.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.demo.controller.LoginController;
import com.example.demo.model.Login;


// UTILS & MODELS
@SpringBootTest
class PasswordTests {

	boolean checkPassword(String pw) {
		PasswordChecker checker = new PasswordChecker();
		return checker.validPassword(pw);
	}

	@Test 
	void passwordCheckerTest1() {
		Assertions.assertTrue(checkPassword("Example123!"));
	}
	
	@Test 
	void passwordCheckerTest2() {
		Assertions.assertTrue(checkPassword("Xx**!!55"));
	}

	@Test 
	void passwordCheckerTest3() {
		Assertions.assertFalse(checkPassword("noNumbers!"));
	}
	
	@Test 
	void passwordCheckerTest4() {
		Assertions.assertFalse(checkPassword("1noSpecial"));
	}

	@Test 
	void passwordCheckerTest5() {
		Assertions.assertFalse(checkPassword("nocaps1!"));
	}

	@Test 
	void passwordCheckerTest6() {
		Assertions.assertFalse(checkPassword("NOLOWERS1!"));
	}

	@Test 
	void passwordCheckerTest7() {
		Assertions.assertFalse(checkPassword("Short1!"));
	}

	@Test 
	void passwordCheckerTest8() {
		Assertions.assertFalse(checkPassword("1!LONGaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
	}

	@Test 
	void loginModelTest() {
		String expectedUn = "user";
		String expectedPw = "pw123";
		Login login = new Login();
		login.setUsername(expectedUn);
		login.setPassword(expectedPw);
		Assertions.assertEquals(expectedUn, login.getUsername());
		Assertions.assertEquals(expectedPw, login.getPassword());
	}
}

// CONTROLLER
@WebMvcTest(controllers = LoginController.class)
class PasswordControllerTests {
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testGetLogin() throws Exception {
		mockMvc.perform(get("/"))
			.andExpect(status().isOk())
			.andExpect(model().attributeExists("login"))
			.andExpect(model().errorCount(0));
	}

	private ResultActions mockLogin(String username, String password) throws Exception {
		return mockMvc.perform(post("/")
					.formField("username", username)
					.formField("password", password)
					.contentType(MediaType.APPLICATION_FORM_URLENCODED));
	}

	@Test
	public void testValidLogin() throws Exception {
		mockLogin("", "SecurePW123!!")
			.andExpect(status().is3xxRedirection())
			.andExpect(redirectedUrl("/quiz"));
	}

	@Test
	public void testInvalidLogin() throws Exception {
		mockLogin("", "notSecure!")
			.andExpect(status().isOk())
			.andExpect(redirectedUrl(null))
			.andExpect(model().attribute("loginFailed", true));
	}
}
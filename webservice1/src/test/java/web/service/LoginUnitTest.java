package web.service;

import org.junit.Test;
import static org.junit.Assert.*;

public class LoginUnitTest {

	@Test
	public void testLogin_Success() {
		assertTrue(LoginService.login("ahsan", "ahsan_pass", "2000-05-07"));
	}

	@Test
	public void testLogin_Fail_WrongUsername() {
		assertFalse(LoginService.login("wrong_user", "ahsan_pass", "2000-05-07"));
	}

	@Test
	public void testLogin_Fail_WrongPassword() {
		assertFalse(LoginService.login("ahsan", "wrong_pass", "2000-05-07"));
	}

	@Test
	public void testLogin_Fail_InvalidDob() {
		assertFalse(LoginService.login("ahsan", "ahsan_pass", "invalid_date"));
	}

	@Test
	public void testLogin_Fail_NullParameters() {
		assertFalse(LoginService.login(null, null, null));
	}

	@Test
	public void testLogin_Fail_EmptyParameters() {
		assertFalse(LoginService.login("", "", ""));
	}

	@Test
	public void testLogin_Fail_IncorrectDob() {
		assertFalse(LoginService.login("ahsan", "ahsan_pass", "1990-01-01"));
	}
	
}

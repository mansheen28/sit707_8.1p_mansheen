package web.service;

import java.time.LocalDate;

/**
 * Business logic to handle login functions.
 * 
 * @author Ahsan.
 */
public class LoginService {

	/**
	 * Static method returns true for successful login, false otherwise.
	 * @param username
	 * @param password
	 * @param dob (date of birth in yyyy-mm-dd format)
	 * @return
	 */
	public static boolean login(String username, String password, String dob) {
		// Match a fixed user name, password, and dob.
		if ("ahsan".equals(username) && "ahsan_pass".equals(password) && "2000-05-07".equals(dob)) {
			return true;
		}
		return false;
	}

	
	
}

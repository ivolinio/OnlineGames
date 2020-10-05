package servicesInterface;

import entities.User;

public interface UserInterface {
	
	/**
	 * Add user to the database and return it
	 * returns null if it's not successful
	 * for username
	 * and for password
	 * @return: user or null
	 */
	User registerUser(String password, String username);
		
	
	/**
	 * Check user and pass 
	 * if they belong to existing User
	 * @return: if not successful returns null
	 * else returns the user that was logged
	 */
	User login(String username,String password);
	
	void logout(String username);
}

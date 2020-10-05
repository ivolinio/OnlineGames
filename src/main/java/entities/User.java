package entities;

import java.util.Map;

public class User {

	private int userId;
	
	private String username;
	
	private String password;
		
	public User() {
		
	}
	 
	public static User parseMapToUser(Map<String, Object> userMap) {
		User user = new User();
		user.setUsername((String)userMap.get("username"));
		user.setPassword((String)userMap.get("password"));
		user.setUserId((Integer)userMap.get("user_id"));
		
		return user;
	}

	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
}
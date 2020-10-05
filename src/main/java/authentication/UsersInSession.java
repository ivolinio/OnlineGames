package authentication;

import java.util.HashMap;
import java.util.Map;
import entities.User;

public class UsersInSession {

	// List of users in session
	private static final Map<String, User> ONLINE_USERS = new HashMap<>();
	
	private UsersInSession() {
	}
	
	public static User getUser(String username) {
		return ONLINE_USERS.get(username);
	}
	
	public static User getUser(User user) {
		return ONLINE_USERS.get(user.getUsername());
	}
	
	public static void addUser(User user) {
		ONLINE_USERS.put(user.getUsername(), user);
	}
	
	public static void removeUser(User user) {
		ONLINE_USERS.remove(user.getUsername());
	}
	
	public static void removeUser(String username) {
		ONLINE_USERS.remove(username);
	}
	
	
}

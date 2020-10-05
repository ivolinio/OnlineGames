package repository;

import java.util.List;
import java.util.Map;

import dataBase.Connector;
import entities.User;

public class UserRepository {
	
	private static final String INSERT_USER = "INSERT INTO users (username, password)\n" + 
			"VALUES (?, ?);";
	
	private static final String DELETE_USERNAME = "DELETE FROM users WHERE username=?;";
	
	
	private static final String SELECT_USERNAME = "SELECT user_id, username, password \n" + 
			"FROM users WHERE username=?;";
	
	
	public User addUser(User user) {
		Connector.getInstance().executeQuery(INSERT_USER, user.getUsername(), user.getPassword());
		return user;
	}
	public void deleteUser(User user) {
		Connector.getInstance().executeQuery(DELETE_USERNAME, user.getUsername());
	}
	
	public User getUser(String username) {
		List<Map<String,Object>> userData = Connector.getInstance().executeQueryWithResult(SELECT_USERNAME, username);
		if(userData.isEmpty()) {
			return null;
		} else {
			return User.parseMapToUser(userData.get(0));
		  }
	}
	
}

package serviceImplement;


import java.util.Objects;

import authentication.UsersInSession;
import entities.User;
import repository.UserRepository;
import servicesInterface.UserInterface;

public class UserImplement implements UserInterface{

	private UserRepository userRepository;
	
	public UserImplement() {
		userRepository = new UserRepository();
		
	}
	
	@Override
	public User registerUser(String password, String username) {
		if(userRepository.getUser(username) == null) {
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			return userRepository.addUser(user);
		}
		return null;
		
	}

	@Override
	public User login(String username, String password) {
		User user = userRepository.getUser(username);

		if(user != null && Objects.equals(user.getPassword(), password)) {
			UsersInSession.addUser(user);
			return user;
		}
	    return null;
	}

	@Override
	public void logout(String username) {
		User user = userRepository.getUser(username);
		UsersInSession.removeUser(user);
		
	}

	

	

	

}

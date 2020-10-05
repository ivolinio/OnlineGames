package serviceImplement;

import java.util.List;

import entities.Timer;
import entities.User;
import repository.TimeRepository;
import repository.UserRepository;
import servicesInterface.TimeInterface;

public class TimeImplement implements TimeInterface {


	private final TimeRepository timeRepository;
    private final UserRepository userRepository;
		
	
	public TimeImplement(TimeRepository equipmentRepository,
				UserRepository userRepository) {
		 this.timeRepository = equipmentRepository;
		 this.userRepository = userRepository;
	 }

	@Override
	public void addTime(String seller, String time) {
		User u = this.userRepository.getUser(seller);		
		this.timeRepository.addTimer(time, u.getUserId()); 
	}

	@Override
	public List<Timer> getAll() {
		return this.timeRepository.getAll();
	}


	@Override
	public Timer getById(int id) {
		return this.timeRepository.findById(id);
	}


	@Override
	public List<Timer> getBySeller(int Seller) {
		return this.timeRepository.findBySeller(Seller);
	}




	

	

	
	
	

}

package servicesInterface;

import java.util.List;

import entities.Timer;

public interface TimeInterface {

    List<Timer> getAll();
	
	Timer getById(int id);
	
	List<Timer> getBySeller(int Seller);
	
	void addTime(String seller, String time );
	
}

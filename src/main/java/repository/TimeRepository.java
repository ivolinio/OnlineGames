package repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import dataBase.Connector;
import entities.Timer;

public class TimeRepository {
	
	private static final String INSERT_TIME = "INSERT INTO times (time_score, user_name)\n" + 
			"VALUES (?, ?);";
	
	private static final String SELECT_TIME = "SELECT times.time_id, times.time_score, users.username" + 
			"FROM times " +
            "JOIN users ON times.user_name = users.user_id ";

			
	private static final String GET_ALL_QUERY = SELECT_TIME + ";";
	
    private static final String FIND_BY_ID_QUERY = SELECT_TIME + "WHERE time_id=?;";
    
    private static final  String FIND_BY_SELLER_QUERY = SELECT_TIME + "WHERE user_name=?;"; // za sellera
	
	
	public void addTimer(String time, int Seller) {
		Connector.getInstance().executeQuery(INSERT_TIME, time, Seller);
		
	}
	
	public List<Timer> getAll() {
		List<Map<String,Object>> returnVal = Connector.getInstance().executeQueryWithResult(GET_ALL_QUERY);
		List<Timer> equipments = new ArrayList<>();
		
		for(Map<String,Object> rawDatabaseEntity : returnVal) {
			equipments.add(Timer.parseMapToTime(rawDatabaseEntity));
		}
		
		return equipments;
	} 
		

		public Timer findById(int id) {
			return Timer.parseMapToTime(
					Connector.getInstance().executeQueryWithResult(FIND_BY_ID_QUERY, id).get(0));
		}
		
		public List<Timer> findBySeller(int seller) {
			List<Map<String,Object>> returnVal = Connector.getInstance().executeQueryWithResult(FIND_BY_SELLER_QUERY, seller);
			List<Timer> equipments = new ArrayList<>();
			
			for(Map<String,Object> userNum : returnVal) {
				equipments.add(Timer.parseMapToTime(userNum));
			}
			
			return equipments;
	}

}

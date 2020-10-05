package entities;

import java.util.Map;

public class Timer {

    private int timeId;
	
	private String time_score;
	
	private String userName; // username 
		
	public Timer() {
		
	}
	 
	public static Timer parseMapToTime(Map<String, Object> timeMap) {
		Timer timer = new Timer();
		timer.setTime((String)timeMap.get("time_score"));
		timer.setTimeId((Integer)timeMap.get("time_id"));
		timer.setUserName((String)timeMap.get("user_name"));

		
		return timer;
	}

	/**
	 * @return the timeId
	 */
	public int getTimeId() {
		return timeId;
	}

	/**
	 * @param timeId the timeId to set
	 */
	public void setTimeId(int timeId) {
		this.timeId = timeId;
	}

	/**
	 * @return the timeScore
	 */
	public String getTime() {
		return time_score;
	}

	/**
	 * @param timeScore the timeScore to set
	 */
	public void setTime(String time_score) {
		this.time_score = time_score;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	
	
	
}

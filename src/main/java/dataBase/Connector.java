package dataBase;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class Connector {

	private String USERS_TABLE = "CREATE TABLE IF NOT EXISTS users(" +
			"user_id INT NOT NULL AUTO_INCREMENT, " +
			"username VARCHAR(100) NOT NULL UNIQUE, " +
			"password VARCHAR(100) NOT NULL, " 
			+ "PRIMARY KEY (user_id) "
			+ ");";
	
	private Connection connect;
	
	private String TIME_TABLE = "CREATE TABLE IF NOT EXISTS times(" 
			+"time_id INT NOT NULL AUTO_INCREMENT, " 
			+"time_score VARCHAR(100) NOT NULL, " 
			+"user_name INT, " 
			+ "PRIMARY KEY (time_id), "
			+ "FOREIGN KEY (user_name) REFERENCES users(user_id) "
			+ ");";

	private String GAME_TABLE = "CREATE TABLE IF NOT EXISTS games(" +
			"game_id INT NOT NULL AUTO_INCREMENT, " +
			"game_name NVARCHAR(255) NOT NULL, " +
			"username VARCHAR(100) NOT NULL, " +
			"address VARCHAR(100) NOT NULL, "
			+ "PRIMARY KEY (game_id) "
			+ ");";
	//SignIn
	private static volatile Connector instance = null;
	
	public static Connector getInstance() { 
		if(instance != null) {
			return instance;
		}
		synchronized(Connector.class) { 
			if(instance == null) {
				instance = new Connector();
			}
			return instance;
		}
	}
	
	private Connector() {
		init();
		createTables();
	}
	
	
	private void createTables() {
		executeQuery(USERS_TABLE);
		executeQuery(TIME_TABLE);
		executeQuery(GAME_TABLE);

		
	}

	private void init() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Properties properties = new Properties();
			properties.setProperty("user", "root");
			properties.setProperty("password", "Programista12*");
			
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/data_base?createDatabaseIfNotExist=true&useLegacyDatetimeCode=false&serverTimezone=UTC",properties);

		}catch (Exception e) {		
			e.printStackTrace();
		}
	}
	// insert data in dataBase
	public void executeQuery(String query, Object...datas) {
		try (Statement st = connect.createStatement();
				PreparedStatement prst = connect.prepareStatement(query)) {
				
			prepareStatement(prst, datas);
			prst.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
 
    // executes query that return result with all the data
	public List<Map<String,Object>> executeQueryWithResult(String query, Object...datas) { 
		try(Statement stmt = connect.createStatement();
			PreparedStatement pstmt = connect.prepareStatement(query)) {
			prepareStatement(pstmt, datas);
			ResultSet resultSet = pstmt.executeQuery();
			
			return parseResultSetsToMap(resultSet);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private void prepareStatement(PreparedStatement pstmt, Object...datas) throws SQLException {
		for (int i = 0; i < datas.length; i++) {
			Object currentData = datas[i];
			if (currentData instanceof LocalDateTime) {
				pstmt.setTimestamp(i + 1, Timestamp.valueOf((LocalDateTime) currentData));
			}else {
				pstmt.setObject(i + 1, currentData);
			}
		}
	}
	
	/**
	 * parses the resultSet into list of maps with key = name of the column and value = value of the column in database
	 * note : each map represents an entity
	 * @param resultSet - the result set 
	 * @return - list of maps each of which represents an entity from database
	 * @throws SQLException - throws from result set
	 */
	private List<Map<String,Object>> parseResultSetsToMap (ResultSet resultSet) throws SQLException {
		List<Map<String,Object>> entities = new ArrayList<>();
		int colCount = resultSet.getMetaData().getColumnCount();
		while(resultSet.next()) {
			Map<String, Object> map = new HashMap<>();
			for (int i = 1; i <= colCount; i++) {
				String colName = resultSet.getMetaData().getColumnName(i);
				Object colValue = resultSet.getObject(colName);
				map.put(colName,colValue);	
			}			
			entities.add(map);	
		}
		return entities;
	}
}


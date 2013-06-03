package conf;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataSource {
	private static final String DB_PORT="3306"; // database port no eg mysql port : 3306
	private static final String DB_NAME="library"; // database name
	private static final String DB_URL="jdbc:mysql://localhost:"+DB_PORT+"/"+DB_NAME;	
	private static final String DB_USER="root";// Database username
	private static final String DB_PASSWORD="root"; // Database password
	private static final String DB_DRIVER="com.mysql.jdbc.Driver";
	
	protected static Connection connection;
	protected static PreparedStatement preparedStatement;
	
	public DataSource(){
		try{
		connect();
		}
		catch(Exception e){
			System.err.println("Error while calling connect method ::"+e.getMessage());
		}
	}
	
	protected static boolean connect() throws InstantiationException, IllegalAccessException{
		try{
			Class.forName(DB_DRIVER).newInstance();
		}
		catch(ClassNotFoundException e){
			System.err.print("Error while loading Driver :"+DB_DRIVER+" "+e.getMessage());			
		}
		try{
			connection =DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		}
		catch(SQLException e){
			System.err.println("Error while conneting Database DB_URL:"+DB_URL+" DB_USER:"+DB_USER+" DB_PASSWORD:"+DB_PASSWORD+" ERROR ::::"+e.getMessage());
		}
		return connection != null;
	}
	
	public static ResultSet find(){
		ResultSet resultSet = null;
		try {
			resultSet = preparedStatement.executeQuery();
		} catch (SQLException e) {
			System.err.println("Error while Executing query :"+e.getMessage());
		}
		return resultSet != null ? resultSet : null;
	}
	public static boolean affect(){
		int result = 0;
		try{
			result=preparedStatement.executeUpdate();
		}
		catch(SQLException e){
			System.err.println("Error while executeUpdate "+e.getMessage());
		}
		return result==0? false :true;
	}
}
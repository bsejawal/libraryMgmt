package services.edu.smude;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conf.Dao;
import conf.DataSource;
import domains.edu.smude.User;


public class UserService extends Dao{
	private static String table="user";
	public static User authenticate(User user) throws SQLException, InstantiationException, IllegalAccessException{
		isConnection();
		preparedStatement=connection.prepareStatement("SELECT * FROM "+table+" WHERE `username`=? AND `password`=md5(?) LIMIT 1");
		preparedStatement.setString(1, user.getUsername());
		preparedStatement.setString(2, user.getPassword());
		return instantiateSingleRow(DataSource.find());
	}
	
	private static User instantiateSingleRow(ResultSet rs){
		User user = new User();
		try {
			while(rs.next()) {
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setName(rs.getString("name"));
				user.setPhone(rs.getString("phone"));
				user.setEmail(rs.getString("email"));
				user.setUserType(rs.getString("userType"));
			}
		} catch (SQLException e) {
			System.err.println("error on instantiate single row :"+e.getMessage());
		}		
		return user;		
	}
	private ArrayList<User> instantiateMultipleRow(ResultSet rs){
		ArrayList<User> list=new ArrayList<User>();
		try{
			while(rs.next()){
				User user= new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setName(rs.getString("name"));
				user.setPhone(rs.getString("phone"));
				user.setEmail(rs.getString("email"));
				user.setUserType(rs.getString("userType"));
				list.add(user);
			}
		} catch(SQLException e){
			System.err.println("Error on instantiate multiple row ::"+e.getMessage());
		}
		return list;
	}
	
	public User find_by_id(int id){
		return instantiateSingleRow(findById(table, id));
	}
	
	public ArrayList<User> find_all(){
		return instantiateMultipleRow(findAll(table));
	}
	public static boolean isConnection() throws InstantiationException, IllegalAccessException{
		if(connection==null) return DataSource.connect();
		else return true;
	}
	
}

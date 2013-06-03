package conf;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Dao extends DataSource {

	protected static ResultSet findAll(String table){
		try {
			preparedStatement =connection.prepareStatement("SELECT * FROM "+table);
		} catch (SQLException e) {
			System.err.println("Error on find all :"+e.getMessage());
		}
		return find();
	}
	
	protected static ResultSet findById(String table, int id){
		try{
			preparedStatement =connection.prepareStatement("SELECT * FROM "+table+" WHERE id=?");
			preparedStatement.setInt(1, id);
		}catch (SQLException e) {
			System.err.println("Error on find_by_id :"+e.getMessage());
		}
		return find();
	}
}
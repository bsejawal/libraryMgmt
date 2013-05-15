package conf;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Dao extends DataSource {

	protected ResultSet find_all(String tbl_name){
		try {
			setPreparedStatement(getConnection().prepareStatement("SELECT * FROM test"));
		} catch (SQLException e) {
			System.err.println("Error on find all :"+e.getMessage());
		}
		return find();
	}
	
	protected ResultSet find_by_id(String tbl_name, int id){
		try{
			setPreparedStatement(getConnection().prepareStatement("SELECT * FROM TEST WHERE id=1"));
			getPreparedStatement().setInt(1, id);
		}catch (SQLException e) {
			System.err.println("Error on find_by_id :"+e.getMessage());
		}
		return find();
	}

}

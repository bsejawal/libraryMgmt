package services.com.smude;

import domains.com.smude.Book;
import conf.Dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class BookService extends Dao {
	private String tbl_name="test";
	
	private Book instantiate_single_row(ResultSet rs){
		Book book = new Book();
		try {
			while(rs.next()) {
				book.setId(rs.getInt("id"));
				book.setName(rs.getString("name"));
				book.setAddress(rs.getString("address"));
			System.out.println("ID"+rs.getInt("id"));
			System.out.println("Name "+rs.getString("name"));
			System.out.println("address "+rs.getString("address"));
			}
		} catch (SQLException e) {
			System.err.println("error on instantiate single row :"+e.getMessage());
		}		
		return book;		
	}
	
	private ArrayList<Book> instantiate_multi_row(ResultSet rs){
		ArrayList<Book> list = new ArrayList<Book>();
		try {
			while(rs.next()){
				Book book = new Book();
				book.setId(rs.getInt("id"));
				book.setName(rs.getString("name"));
				book.setAddress(rs.getString("address"));
				list.add(book);
			}
		} catch (SQLException e) {
			System.err.println("Error in Login :"+e.getMessage());
		}
		return list;
	}
	
	public Book find_by_id(int id){
		return instantiate_single_row(find_by_id(tbl_name, id));
	}
	
	public ArrayList<Book> find_all(){
		return instantiate_multi_row(find_all(tbl_name));
	}
	
}

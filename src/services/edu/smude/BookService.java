package services.edu.smude;
import conf.Dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import domains.edu.smude.Book;


public class BookService extends Dao{
	private static  String table="book";
	
	private static Book instantiateSingleRow(ResultSet rs){
		Book book = new Book();
		try {
			while(rs.next()) {
				book.setId(rs.getInt("id"));
				book.setName(rs.getString("name"));
				book.setAuthor(rs.getString("author"));
				book.setPublication(rs.getString("publication"));
				book.setStatus(rs.getString("status"));
				book.setPurchaseDate(rs.getDate("purchaseDate"));
			}
		} catch (SQLException e) {
			System.err.println("error on instantiate single row :"+e.getMessage());
		}		
		return book;		
	}
	private static ArrayList<Book> instantiateMultipleRow(ResultSet rs){
		ArrayList<Book> list=new ArrayList<Book>();
		try{
			while(rs.next()){
				Book book= new Book();
				book.setId(rs.getInt("id"));
				book.setName(rs.getString("name"));
				book.setAuthor(rs.getString("author"));
				book.setPublication(rs.getString("publication"));
				book.setStatus(rs.getString("status"));
				book.setPurchaseDate(rs.getDate("purchaseDate"));
				list.add(book);
			}
		} catch(SQLException e){
			System.err.println("Error on instantiate multiple row ::"+e.getMessage());
		}
		return list;
	}
	
	public static Book findById(int id){		
		return instantiateSingleRow(findById("stst", id));
	}
	
	public static ArrayList<Book> find_all(){
		return instantiateMultipleRow(findAll(table));
	}
	
//	@Override
//	public Domain getById(int id) {
//		return new Book();
//	}
//	
//	public List<Domain> findAll() {
//		
//	}
}

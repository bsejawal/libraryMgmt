package controllers.com.smude;

import java.io.IOException;

import domains.com.smude.Book;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.com.smude.BookService;
/**
 * Servlet implementation class BookController
 */
public class BookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
		BookService bookService = new BookService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("pages/index.jsp");
		request.setAttribute("book", bookService.find_by_id(1));
		view.forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("pages/index.jsp");
		view.forward(request, response);
		// TODO Auto-generated method stub
	}

}

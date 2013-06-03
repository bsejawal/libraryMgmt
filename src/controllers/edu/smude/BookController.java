package controllers.edu.smude;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.edu.smude.BookService;

public class BookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static HttpServletRequest request;
	private static HttpServletResponse response;	
	
	@SuppressWarnings("static-access")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.request=request; this.response=response;
		request.getRequestURI();
	}
	@SuppressWarnings("static-access")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.request=request; this.response=response;
	}
	@SuppressWarnings("unused")
	private void index() throws ServletException, IOException{
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("");
		request.setAttribute("book", BookService.findById(1));
		requestDispatcher.forward(request,response);
	}

}

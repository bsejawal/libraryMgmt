package controllers.edu.smude;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.edu.smude.UserService;
import utilities.Utils;

import domains.edu.smude.User;

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpServletRequest request;
	HttpServletResponse response;
	Map<String, String> params = new HashMap<String, String>();

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("~~~login->doGet~~~");
		setInstanceVariables(request, response);
		if (params.get("action") == "" || params.get("action").equals("index"))
			index();
		else if (params.get("action").equals("logout"))
			logout();
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("~~~login->doPost~~~");
		setInstanceVariables(request, response);
		if (params.get("action").equals("index"))
			index();
		else if (params.get("action").equals("authenticate")) {
			try {
				authenticate();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}

	@SuppressWarnings("unchecked")
	protected void setInstanceVariables(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("~~~login->setInstanceVariables~~~");
		this.request = request;
		this.response = response;
		Map<String, String[]> map = request.getParameterMap();
		Set set = map.entrySet();
		Iterator<Map.Entry<String, String[]>> it = set.iterator();
		params.clear();
		while (it.hasNext()) {
			Entry<String, String[]> entry = it.next();
			params.put(entry.getKey(), entry.getValue()[0]);
		}
		if (!params.containsKey("action"))
			params.put("action", "index");
		if (!params.containsKey("id"))
			params.put("id", "0");
	}

	protected void index() throws ServletException, IOException {
		System.out.println("~~~login->index~~~");
		request.getRequestDispatcher("views/login/index.jsp").include(request,
				response);
	}

	protected void authenticate() throws ServletException, IOException,
			SQLException, InstantiationException, IllegalAccessException {
		System.out.println("~~~login->authencate~~~");
		User user = new User();
		user.setUsername(params.get("username"));
		user.setPassword(params.get("password"));
		user = UserService.authenticate(user);
		setSessionValues(user);
		if (Utils.isLogin(request)) {
			System.out.println("~~~isLogin->true~~~");
			response.sendRedirect("user");
		} else {
			System.out.println("~~~isLogin->false~~~");
			response.sendRedirect("login");
		}
	}

	private void logout() throws IOException {
		System.out.println("~~~login->logout~~~");
		request.getSession().setAttribute("user", null);
		request.getSession().setAttribute("isLogin", null);
		response.sendRedirect("login");
	}

	public void setSessionValues(User user) {
		System.out.println("~~~login->setSessionValues~~~");
		if (!Utils.isNull(user.getEmail()) && !Utils.isNull(user.getName())
				&& !Utils.isNull(user.getUserType())) {
			request.getSession().setAttribute("isLogin", "true");
			request.getSession().setAttribute("user", user);
		}
	}
}

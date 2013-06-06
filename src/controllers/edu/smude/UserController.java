package controllers.edu.smude;

import java.io.IOException;
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
import domains.edu.smude.User;

public class UserController extends HttpServlet {
	HttpServletRequest request;
	HttpServletResponse response;
	Map<String, String> params = new HashMap<String, String>();

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		setInstanceVariables(request, response);
		System.out.println("~~~user->doGet~~~");
		System.out.println("---->>>> "
				+ request.getSession().getAttribute("isLogin"));
		if (params.get("action").equals("")
				|| params.get("action").equals("index"))
			index();
		else if (params.get("action").equals("form"))
			form();
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("~~~user->doPost~~~");
		setInstanceVariables(request, response);
		if (params.get("action").equals("save")) {
			try {
				save();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

	}

	@SuppressWarnings("unchecked")
	private void setInstanceVariables(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("~~~user->setInstanceVariables~~~");
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
		System.out.println("~~~user->index~~~");
		request.setAttribute("user", (User) request.getSession().getAttribute(
				"user"));
		System.out.println("is login ::"
				+ request.getSession().getAttribute("isLogin"));
		request.getRequestDispatcher("views/user/index.jsp").forward(request,
				response);
	}

	private void form() throws ServletException, IOException {
		System.out.println("~~~user->form~~~");
		request.getRequestDispatcher("views/user/form.jsp").forward(request,
				response);
	}

	private void save() throws ServletException, IOException,
			InstantiationException, IllegalAccessException {
		System.out.println("~~~user->save~~~");
		if (UserService.save(params)) {

		}
	}
}

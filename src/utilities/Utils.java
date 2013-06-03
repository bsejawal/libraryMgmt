package utilities;

import javax.servlet.http.HttpServletRequest;

public class Utils {

	public static boolean isNull(String st) {
		return st == null || st == "null" || st == "" || st == "undefine";
	}

	public static String trimmer(String st) {
		st = st.startsWith("[") ? st.substring(1, st.length()) : st;
		st = st.endsWith("]") ? st.substring(0, st.length() - 1) : st;
		st = st.startsWith("'") ? st.substring(1, st.length()) : st;
		st = st.endsWith("'") ? st.substring(0, st.length() - 1) : st;
		st = st.startsWith("\"") ? st.substring(1, st.length()) : st;
		st = st.endsWith("\"") ? st.substring(0, st.length() - 1) : st;
		st = st.trim();
		return st;
	}

	public static boolean isLogin(HttpServletRequest request) {
		if (request.getSession().getAttribute("isLogin") != null
				&& request.getSession().getAttribute("user") != null)
			return true;
		return false;
	}
}

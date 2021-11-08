package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DemoData
 */
@WebServlet("/demoData")
public class DemoData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DemoData() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Session
		HttpSession session = request.getSession();
		// on a deja une session
		// on a pas de session
		session.setAttribute("session1", "un message en session");
		session.setAttribute("sessionid", session.getId());

		// session.setAttribute("list", new ArrayList<String>()); à ne faire qu'une fois
		// pour ne pas ecraser la liste a chaque fois
		// ((ArrayList<String>) session.getAttribute("list")).add("aaa");
		// session.invalidate();
		// session.getMaxInactiveInterval();
		// session.setMaxInactiveInterval(0);
		ServletContext servletContext = this.getServletContext();
		servletContext.setAttribute("application1", "un message en application");
		
		Cookie cookie=new Cookie("cookie1", "message_du_cookie1");
		cookie.setMaxAge(3600*24*7);
		response.addCookie(cookie);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListPersonneController
 */
@WebServlet("/personne/list")
public class ListPersonneController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListPersonneController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// preparation de mes donnees
		List<Personne> list = Arrays.asList(new Personne("olivier", "gozlan"), new Personne("benjamin", "tam"));
		//List<Personne> list=null;
		// mettre les donnees dans le modele
		request.setAttribute("personnes", list);
		// envoyer la requete vers la bonne vue
		RequestDispatcher rd = null;
		if (list != null && !list.isEmpty()) {
			rd = request.getRequestDispatcher("/WEB-INF/page3.jsp");
		} else {
			rd = request.getRequestDispatcher("/WEB-INF/pageErreur.jsp");
		}
		rd.forward(request, response);

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

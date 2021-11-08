package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import formationJdbc.dao.DaoFormateur;
import formationJdbc.dao.DaoFormateurFactory;
import formationJdbc.model.Formateur;

/**
 * Servlet implementation class FormateurController
 */
@WebServlet("/formateur")
public class FormateurController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FormateurController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String q = request.getParameter("q");
		RequestDispatcher rd = null;
		if (q == null) {
			rd = goList(request, response);
		} else if (q.equals("delete")) {
			rd = delete(request, response);
		} else if (q.equals("add")) {
			rd = goEdit(request, response);
		} else if (q.equals("edit")) {
			rd = edit(request, response);
		}else if(q.equals("save")) {
			rd=save(request,response);
		}
		rd.forward(request, response);
	}
	
	private RequestDispatcher save(HttpServletRequest request,HttpServletResponse response) {
		Formateur formateur=new Formateur(request.getParameter("prenom"), request.getParameter("nom"));
		DaoFormateur daoFormateur = DaoFormateurFactory.getInstance();
		if(!request.getParameter("id").isEmpty()) {
			formateur.setId(Integer.parseInt(request.getParameter("id")));
			daoFormateur.update(formateur);
		}else {
			daoFormateur.insert(formateur);
		}
		return goList(request, response);
		
	}
	
	private RequestDispatcher edit(HttpServletRequest request, HttpServletResponse response) {
		DaoFormateur daoFormateur = DaoFormateurFactory.getInstance();
		int id = Integer.parseInt(request.getParameter("id"));
		Formateur formateur=daoFormateur.findByKey(id);
		request.setAttribute("formateur", formateur);
		return goEdit(request, response);
	}

	private RequestDispatcher goEdit(HttpServletRequest request, HttpServletResponse response) {
		return request.getRequestDispatcher("/WEB-INF/formateur/edit.jsp");
	}

	private RequestDispatcher delete(HttpServletRequest request, HttpServletResponse response) {
		DaoFormateur daoFormateur = DaoFormateurFactory.getInstance();
		int id = Integer.parseInt(request.getParameter("id"));
		daoFormateur.deleteByKey(id);
		return goList(request, response);
	}

	private RequestDispatcher goList(HttpServletRequest request, HttpServletResponse response) {
		DaoFormateur daoFormateur = DaoFormateurFactory.getInstance();
		request.setAttribute("formateurs", daoFormateur.findAll());
		return request.getRequestDispatcher("/WEB-INF/formateur/list.jsp");
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

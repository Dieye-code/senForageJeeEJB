package com.senForage.servlet;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.senForage.dao.IVillage;
import com.senForage.dao.VillageDao;
import com.senForage.entities.Village;

/**
 * Servlet implementation class VillageServlet
 */
@WebServlet(urlPatterns = { "/Village", "/Village/add", "/Village/edit/*" }, name = "village")
public class VillageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private IVillage villageDao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VillageServlet() {
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("baseUrl", "http://localhost:8080/senForageFirst/");
		String methode = request.getRequestURI();
		if (request.getSession().getAttribute("user") == null) {
			response.sendRedirect("/senForageVersion2/Login");
		} else {
			request.setAttribute("baseUrl", "http://localhost:8080/senForageVersion2/");

			if (methode.endsWith("/add")) {

				this.getServletContext().getRequestDispatcher("/WEB-INF/village/add.jsp").forward(request, response);

			} else if (methode.contains("/edit")) {

//				

			} else if (methode.endsWith("/Village")) {
				request.setAttribute("villages", villageDao.listeVillage());
				this.getServletContext().getRequestDispatcher("/WEB-INF/village/liste.jsp").forward(request, response);

			}
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setAttribute("baseUrl", "http://localhost:8080/senForageVersion2/");
		if (request.getSession().getAttribute("user") == null) {
			response.sendRedirect("/senForageVersion2/Login");
		} else {
			String libelle = request.getParameter("libelle");
			Village v = villageDao.getVillageByLibelle(libelle);
			if(v!=null) {
				request.setAttribute("existe", 1);
				this.getServletContext().getRequestDispatcher("/WEB-INF/village/add.jsp").forward(request, response);
			} else {
				v = new Village();
				v.setLibelle(libelle);
				int a = villageDao.addVillege(v);
				request.setAttribute("a", a);
				request.setAttribute("villages", villageDao.listeVillage());
				this.getServletContext().getRequestDispatcher("/WEB-INF/village/liste.jsp").forward(request, response);
			}
		}
		
	}

}

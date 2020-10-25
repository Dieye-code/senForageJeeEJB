package com.senForage.servlet;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.senForage.dao.AbonnementDao;
import com.senForage.dao.CompteurDao;
import com.senForage.dao.IAbonnement;
import com.senForage.dao.ICompteur;
import com.senForage.entities.Abonnement;
import com.senForage.entities.Client;
import com.senForage.entities.Compteur;
import com.senForage.entities.Personne;
import com.senForage.entities.Village;

/**
 * Servlet implementation class AbonnementServlet
 */
@WebServlet(name = "compteur", urlPatterns = { "/Compteur", "/Compteur/add", "/Compteur/edit/*" })
public class CompteurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private ICompteur compteurDao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CompteurServlet() {
		this.compteurDao = new CompteurDao();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("baseUrl", "http://localhost:8080/senForageVersion2/");
		String methode = request.getRequestURI();
		if (request.getSession().getAttribute("user") == null) {
			response.sendRedirect("/senForageVersion2/Login");
		} else {
			request.setAttribute("abonnements", compteurDao.listeAbonnement());
			if (methode.endsWith("/add")) {
				this.getServletContext().getRequestDispatcher("/WEB-INF/compteur/add.jsp").forward(request, response);

			} else if (methode.contains("/edit")) {

				String[] dept = request.getRequestURI().split("/");
				try {
					int a = Integer.parseInt(dept[dept.length - 1]);
					request.setAttribute("compteur", compteurDao.getCompteur(a));
				} catch (Exception e) {

					request.setAttribute("compteur", null);
				}
				request.setAttribute("abonnements", compteurDao.listeAbonnement());

				this.getServletContext().getRequestDispatcher("/WEB-INF/compteur/edit.jsp").forward(request,
						response);

			} else if (methode.endsWith("/Compteur")) {
				request.setAttribute("compteurs", compteurDao.listeCompteur());
				this.getServletContext().getRequestDispatcher("/WEB-INF/compteur/liste.jsp").forward(request,
						response);

			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getSession().getAttribute("user") == null) {
			response.sendRedirect("/senForageVersion2/Login");
		} else {
			request.setAttribute("baseUrl", "http://localhost:8080/senForageVersion2/");
			String methode = request.getRequestURI();

			List<Abonnement> abonnements = this.compteurDao.listeAbonnement();
			request.setAttribute("abonnements", abonnements);
			if (methode.endsWith("/add")) {

				Compteur u = new Compteur();
				u.setDateAttribution(request.getParameter("dateAttribution"));
				u.setDescription(request.getParameter("description"));
				u.setAbonnement(compteurDao.getAbonnement(Integer.parseInt(request.getParameter("abonnement"))));

				int a = compteurDao.addCompteur(u);

				if (a != 0) {
					request.setAttribute("a", a);
					request.setAttribute("compteurs", compteurDao.listeCompteur());
					this.getServletContext().getRequestDispatcher("/WEB-INF/compteur/liste.jsp").forward(request,
							response);
				} else {

					request.setAttribute("a", a);
					this.getServletContext().getRequestDispatcher("/WEB-INF/compteur/add.jsp").forward(request,
							response);
				}

			} else if (methode.contains("/edit")) {

				String[] dept = request.getRequestURI().split("/");
				Compteur compteur = null;
				try {
					int a = Integer.parseInt(dept[dept.length - 1]);
					compteur = compteurDao.getCompteur(a);
				} catch (Exception e) {

					compteur = null;
				}

				if (compteur == null) {

					request.setAttribute("compteur", compteur);
					this.getServletContext().getRequestDispatcher("/WEB-INF/compteur/edit.jsp").forward(request,
							response);

				} else {
					compteur.setDateAttribution(request.getParameter("dateAttribution"));
					compteur.setDescription(request.getParameter("description"));
					compteur.setAbonnement(compteurDao.getAbonnement(Integer.parseInt(request.getParameter("abonnement"))));

					int a = compteurDao.addCompteur(compteur);

					if (a != 0) {
						request.setAttribute("a", a);
						request.setAttribute("compteurs", compteurDao.listeCompteur());
						this.getServletContext().getRequestDispatcher("/WEB-INF/abonnement/liste.jsp").forward(request,
								response);
					} else {

						request.setAttribute("a", a);
						request.setAttribute("compteur", compteur);
						request.setAttribute("abonnements", compteurDao.listeAbonnement());
						this.getServletContext().getRequestDispatcher("/WEB-INF/compteur/edit.jsp").forward(request,
								response);
					}
				}

			}
		}
	}

}

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
import com.senForage.dao.IAbonnement;
import com.senForage.entities.Abonnement;
import com.senForage.entities.Client;
import com.senForage.entities.Personne;
import com.senForage.entities.Village;

/**
 * Servlet implementation class AbonnementServlet
 */
@WebServlet(name = "abonnement", urlPatterns = { "/Abonnement", "/Abonnement/add", "/Abonnement/edit/*" })
public class AbonnementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private IAbonnement abonnementDao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AbonnementServlet() {
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
			request.setAttribute("clients", abonnementDao.listeClient());
			if (methode.endsWith("/add")) {
				this.getServletContext().getRequestDispatcher("/WEB-INF/abonnement/add.jsp").forward(request, response);

			} else if (methode.contains("/edit")) {

				String[] dept = request.getRequestURI().split("/");
				try {
					int a = Integer.parseInt(dept[dept.length - 1]);
					request.setAttribute("abonnement", abonnementDao.getAbonnement(a));
				} catch (Exception e) {

					request.setAttribute("client", null);
				}
				request.setAttribute("clients", abonnementDao.listeClient());

				this.getServletContext().getRequestDispatcher("/WEB-INF/abonnement/edit.jsp").forward(request,
						response);

			} else if (methode.endsWith("/Abonnement")) {
				request.setAttribute("abonnements", abonnementDao.listeAbonnement());
				this.getServletContext().getRequestDispatcher("/WEB-INF/abonnement/liste.jsp").forward(request,
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

			List<Client> clients = this.abonnementDao.listeClient();
			request.setAttribute("clients", clients);
			if (methode.endsWith("/add")) {

				Abonnement u = new Abonnement();
				u.setDateAbonnement(request.getParameter("dateAbonnement"));
				u.setDescription(request.getParameter("description"));
				u.setClient(abonnementDao.getClient(Integer.parseInt(request.getParameter("client"))));

				int a = abonnementDao.addAbonnement(u);

				if (a != 0) {
					request.setAttribute("a", a);
					request.setAttribute("abonnements", abonnementDao.listeAbonnement());
					this.getServletContext().getRequestDispatcher("/WEB-INF/abonnement/liste.jsp").forward(request,
							response);
				} else {

					request.setAttribute("a", a);
					this.getServletContext().getRequestDispatcher("/WEB-INF/abonnement/add.jsp").forward(request,
							response);
				}

			} else if (methode.contains("/edit")) {

				String[] dept = request.getRequestURI().split("/");
				Abonnement abonnement = null;
				try {
					int a = Integer.parseInt(dept[dept.length - 1]);
					abonnement = abonnementDao.getAbonnement(a);
				} catch (Exception e) {

					abonnement = null;
				}

				if (abonnement == null) {

					request.setAttribute("abonnement", abonnement);
					this.getServletContext().getRequestDispatcher("/WEB-INF/abonnement/edit.jsp").forward(request,
							response);

				} else {
					abonnement.setDateAbonnement(request.getParameter("dateAbonnement"));
					abonnement.setDescription(request.getParameter("description"));
					abonnement.setClient(abonnementDao.getClient(Integer.parseInt(request.getParameter("client"))));

					int a = abonnementDao.addAbonnement(abonnement);

					if (a != 0) {
						request.setAttribute("a", a);
						request.setAttribute("abonnements", abonnementDao.listeAbonnement());
						this.getServletContext().getRequestDispatcher("/WEB-INF/abonnement/liste.jsp").forward(request,
								response);
					} else {

						request.setAttribute("a", a);
						request.setAttribute("abonnement", abonnement);
						request.setAttribute("clients", abonnementDao.listeClient());
						this.getServletContext().getRequestDispatcher("/WEB-INF/client/edit.jsp").forward(request,
								response);
					}
				}

			}
		}
	}

}

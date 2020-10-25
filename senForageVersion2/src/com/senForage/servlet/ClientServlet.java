package com.senForage.servlet;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.senForage.dao.ClientDao;
import com.senForage.dao.IClient;
import com.senForage.entities.Client;
import com.senForage.entities.Personne;
import com.senForage.entities.Role;
import com.senForage.entities.User;
import com.senForage.entities.Village;

/**
 * Servlet implementation class ClientServlet
 */
@WebServlet(urlPatterns = { "/Client", "/Client/add", "/Client/edit/*" }, name = "client")
public class ClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private IClient clientDao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ClientServlet() {
		super();
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
			request.setAttribute("villages", clientDao.listeVillage());
			if (methode.endsWith("/add")) {
				this.getServletContext().getRequestDispatcher("/WEB-INF/client/add.jsp").forward(request, response);

			} else if (methode.contains("/edit")) {
				
				String[] dept = request.getRequestURI().split("/");
				try {
					int a = Integer.parseInt(dept[dept.length - 1]);
					request.setAttribute("client", clientDao.getClient(a));
				} catch (Exception e) {

					request.setAttribute("client", null);
				}
				request.setAttribute("villages", clientDao.listeVillage());

				this.getServletContext().getRequestDispatcher("/WEB-INF/client/edit.jsp").forward(request, response);

			} else if (methode.endsWith("/Client")) {
				request.setAttribute("clients", clientDao.listeClient());
				this.getServletContext().getRequestDispatcher("/WEB-INF/client/liste.jsp").forward(request, response);

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

			List<Village> villages = this.clientDao.listeVillage();
			request.setAttribute("villages", villages);
			if (methode.endsWith("/add")) {

				Client u = new Client();

				Personne p = new Personne();
				p.setNom(request.getParameter("nom"));
				p.setPrenom(request.getParameter("prenom"));
				p.setDateNaissance(request.getParameter("dateNaissance"));
				p.setLieuNaissance(request.getParameter("lieuNaissance"));
				p.setTelephone(request.getParameter("telephone"));
				p.setAdresse(request.getParameter("adresse"));
				u.setPersonne(p);
				u.setVillage(clientDao.getVillage(Integer.parseInt(request.getParameter("village"))));

				int a = clientDao.addClient(u);
				System.out.println(a);

				if (a != 0) {
					request.setAttribute("a", a);
					request.setAttribute("clients", clientDao.listeClient());
					this.getServletContext().getRequestDispatcher("/WEB-INF/client/liste.jsp").forward(request,
							response);
				} else {

					request.setAttribute("a", a);
					this.getServletContext().getRequestDispatcher("/WEB-INF/client/add.jsp").forward(request, response);
				}

			} else if (methode.contains("/edit")) {

				String[] dept = request.getRequestURI().split("/");
				Client client = null;
				try {
					int a = Integer.parseInt(dept[dept.length - 1]);
					client = clientDao.getClient(a);
				} catch (Exception e) {

					client  = null;
				}
				
				if(client==null) {
					
					request.setAttribute("client", client);
					this.getServletContext().getRequestDispatcher("/WEB-INF/client/edit.jsp").forward(request, response);
					
				} else {

					Personne p = client.getPersonne();
					p.setNom(request.getParameter("nom"));
					p.setPrenom(request.getParameter("prenom"));
					p.setDateNaissance(request.getParameter("dateNaissance"));
					p.setLieuNaissance(request.getParameter("lieuNaissance"));
					p.setTelephone(request.getParameter("telephone"));
					p.setAdresse(request.getParameter("adresse"));
					client.setPersonne(p);
					client.setVillage(clientDao.getVillage(Integer.parseInt(request.getParameter("village"))));

					int a = clientDao.addClient(client);

					if (a != 0) {
						request.setAttribute("a", a);
						request.setAttribute("clients", clientDao.listeClient());
						this.getServletContext().getRequestDispatcher("/WEB-INF/client/liste.jsp").forward(request,
								response);
					} else {

						request.setAttribute("a", a);
						request.setAttribute("client", client);
						request.setAttribute("villages", clientDao.listeVillage());
						this.getServletContext().getRequestDispatcher("/WEB-INF/client/edit.jsp").forward(request, response);
					}
				}

				
			}
		}
	}

}

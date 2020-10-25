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

import com.senForage.dao.IUser;
import com.senForage.dao.UserDao;
import com.senForage.entities.Personne;
import com.senForage.entities.Role;
import com.senForage.entities.User;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet(name = "user", urlPatterns = { "/User", "/Login", "/User/add", "/Logout" })
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private IUser userDao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String methode = request.getRequestURI();
		request.setAttribute("baseUrl", "http://localhost:8080/senForageVersion2/");

		if (methode.endsWith("/add")) {

			List<Role> roles = this.userDao.listeRole();
			request.setAttribute("roles", roles);

			this.getServletContext().getRequestDispatcher("/WEB-INF/user/add.jsp").forward(request, response);

		} else if (methode.endsWith("/Login")) {
			
//			request.getSession().invalidate();
			
			if(request.getSession().getAttribute("user")!=null) {
				response.sendRedirect("/senForageVersion2/Welcome");
			}else {
				this.getServletContext().getRequestDispatcher("/WEB-INF/user/login.jsp").forward(request, response);
			}


		} else if (methode.endsWith("/User")) {
			request.setAttribute("users", userDao.listeUser());
			this.getServletContext().getRequestDispatcher("/WEB-INF/user/liste.jsp").forward(request, response);

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute("baseUrl", "http://localhost:8080/senForageVersion2/");
		String methode = request.getRequestURI();

		List<Role> roles = this.userDao.listeRole();
		request.setAttribute("roles", roles);
		if (methode.endsWith("/add")) {
			
			User u = new User();
			
			Personne p = new Personne();
			p.setNom(request.getParameter("nom"));
			p.setPrenom(request.getParameter("prenom"));
			p.setDateNaissance(request.getParameter("dateNaissance"));
			p.setLieuNaissance(request.getParameter("lieuNaissance"));
			p.setTelephone(request.getParameter("telephone"));
			p.setAdresse(request.getParameter("adresse"));
			u.setPersonne(p);
			u.setEmail(request.getParameter("email"));
			u.setPassword("passer");
			
			for (String r : request.getParameterValues("role[]")) {
				u.addRole(userDao.getRoleById(Integer.parseInt(r)));
			}
			
			int a = userDao.addUser(u);
			System.out.println(a);
			request.setAttribute("r", a);
			
			if(a!=0) {
				request.setAttribute("a", a);
				request.setAttribute("users", userDao.listeUser());
				this.getServletContext().getRequestDispatcher("/WEB-INF/user/liste.jsp").forward(request, response);
			}else {

				request.setAttribute("a", a);
				this.getServletContext().getRequestDispatcher("/WEB-INF/user/add.jsp").forward(request, response);
			}


		} else if (methode.endsWith("/Login")) {
			
			HttpSession session = request.getSession(true);
			
			User user = userDao.getUserByEmail(request.getParameter("email"));
			
			if(user!=null) {
				if(user.getPassword().equals(request.getParameter("password"))) {
					
					session.setAttribute("user", user);
					System.out.println(user.getRoles());
					List<Role> roles1 = user.getRoles();
					for (Role role : roles1) {
						
						if(role.getLibelle().equals("Administrateur")) {
							session.setAttribute("administrateur", 1);
						}else if(role.getLibelle().equals("Gestion Clientel")){
							session.setAttribute("gestionClientel", 1);
						}else if(role.getLibelle().equals("Gestion Compteur")){
							session.setAttribute("gestionCompteur", 1);
						} else {
							session.setAttribute("gestionCommercial", 1);
						}
					}
					
					response.sendRedirect("/senForageVersion2/Welcome");
					
				} else {

					request.setAttribute("password", request.getParameter("password"));
					request.setAttribute("vide", 1);
					this.getServletContext().getRequestDispatcher("/WEB-INF/user/login.jsp").forward(request, response);
				}
			} else {
				request.setAttribute("vide", 2);
				this.getServletContext().getRequestDispatcher("/WEB-INF/user/login.jsp").forward(request, response);
			}


		}
	}

}

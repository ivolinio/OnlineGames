package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.User;
import serviceImplement.UserImplement;
import servicesInterface.UserInterface;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserInterface userInterface;
	
    public LoginServlet() {
        super();
        userInterface = new UserImplement();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("jsp/login.jsp").forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 	String username = request.getParameter("username");
	        String password = request.getParameter("password");
	        
	        User user = userInterface.login(username, password);
	        
	        if (user == null) {
				response.getWriter().write("Wrong Username or Password");

	        } else {
	        	request.getSession().setAttribute("uname",username);
	            request.getSession().setAttribute("user", user);
	            request.getRequestDispatcher("jsp/HomePage.jsp").forward(request, response);
	        }
	    }
	}
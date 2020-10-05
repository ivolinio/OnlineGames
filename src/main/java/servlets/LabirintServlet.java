package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import repository.TimeRepository;
import repository.UserRepository;
import serviceImplement.TimeImplement;
import serviceImplement.UserImplement;
import servicesInterface.TimeInterface;
import servicesInterface.UserInterface;
import entities.User;

@WebServlet("/labirint")
public class LabirintServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

     private TimeInterface timeInterface;
     private final UserInterface userService;

	
    public LabirintServlet() {
    	super();
    	this.timeInterface = new TimeImplement(new TimeRepository(), new UserRepository());
        this.userService = new UserImplement();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("static/Labirint.html").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String time = request.getParameter("timezon");
		String seller = ((User) request.getSession().getAttribute("user")).getUsername();
		
		this.timeInterface.addTime(seller, time);
	
		request.getRequestDispatcher("jsp/HomePage.jsp").forward(request, response);
		
		}	
	}


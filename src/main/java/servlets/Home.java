package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import serviceImplement.GameImplement;
import servicesInterface.GameInterface;


@WebServlet("/Home")
@MultipartConfig
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private GameInterface gameInterface;
	
    public Home() {
    	super();
    	gameInterface = new GameImplement();
    }  

    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("jsp/HomePage.jsp").forward(request, response);
	}

    	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String selectedGame = request.getParameter("List");
		String username = request.getParameter("user");
		String bill = request.getParameter("bill");
		String addres = request.getParameter("address");
	
				
		if(request.getParameter("Play") != null && selectedGame.equals("The Labirint")) {
           request.getRequestDispatcher("static/Labirint.html").forward(request, response);
		}
		else if(request.getParameter("Play") != null && selectedGame.equalsIgnoreCase("Snake")) {
	           request.getRequestDispatcher("static/Snake.html").forward(request, response);
		}
		else if(request.getParameter("Play") != null && selectedGame.equalsIgnoreCase("Shadow Fight")) {
	           request.getRequestDispatcher("static/NotAvaivable.html").forward(request, response);
		}
		else if(request.getParameter("Play") != null && selectedGame.equalsIgnoreCase("GTA IV")) {
	           request.getRequestDispatcher("static/NotAvaivable.html").forward(request, response);
		}
			
		if(request.getParameter("buy") != null && (bill.length() <= 0 || addres.length() <= 0)) {
			response.getWriter().write("You didn't select a game or you didnt insert address");
		}
		else if(request.getParameter("buy") != null && (bill.length() >= 0 || addres.length() >= 0)) {
			gameInterface.registerGame(username, bill, addres);
            request.getRequestDispatcher("static/bought.html").forward(request, response); 
		}
	    
	}	
	    
}
	


		
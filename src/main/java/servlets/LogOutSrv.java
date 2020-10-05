package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import serviceImplement.UserImplement;
import servicesInterface.UserInterface;

@WebServlet("/logout")
public class LogOutSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;

private UserInterface userInterface;
	
    public LogOutSrv() {
        super();
        userInterface = new UserImplement();
    }


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("jsp/LogOut.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 	String username = (String) request.getSession().getAttribute("uname");
	 	String username2 = request.getParameter(username);
	 	request.getSession().setAttribute("uname",username2);

	 	userInterface.logout(username);
        request.getSession().setAttribute("user", null);
//        System.out.println(username);
//        System.out.println(username2);
        request.getRequestDispatcher("jsp/login.jsp").forward(request, response);
	
	}

}

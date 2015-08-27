package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;

/**
 * Servlet implementation class UsersController
 */
@WebServlet("/UsersController")
public class UsersController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String LOGIN = "static/authentication/login.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsersController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward="";
        String action = request.getParameter("action");
        if(action.equalsIgnoreCase("logout")){
        	response.sendRedirect("http://localhost:8080/ComicsWebProject/welcome.jsp");
        }
        if(action.equalsIgnoreCase("login"))
        {
        	forward=LOGIN;
        	RequestDispatcher view = request.getRequestDispatcher(forward);
        	view.forward(request, response);
        }
        
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean allow= false;
		String forward="";
    	String username = request.getParameter("username");
    	String password = request.getParameter("password");
    	allow = UserDao.login(username, password);
    	if(allow){
    		request.setAttribute("admin", allow);
    		forward="/welcome.jsp";
    	}
    	RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
	}

}

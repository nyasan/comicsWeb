package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ComicDao;
import dao.LoanDao;
import dao.PersonDao;

/**
 * Servlet implementation class IndexController
 */
@WebServlet("/IndexController")
public class IndexController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String HOME = "/index.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward="";
		HttpSession context= request.getSession();
			forward = HOME;
			ArrayList comicList = new ArrayList<>(ComicDao.selectComics().values());
			ArrayList personList = new ArrayList<>(PersonDao.selectPeople().values());
			ArrayList loanList = new ArrayList<>(LoanDao.selectLoans().values());
			request.setAttribute("comics", comicList);
			request.setAttribute("persons", personList);
			request.setAttribute("loans", loanList);
			
			 RequestDispatcher view = request.getRequestDispatcher(forward);
		     view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ComicDao;
import dao.LoanDao;
import dao.PersonDao;

/**
 * Servlet implementation class LoansController
 */
@WebServlet("/LoansController")
public class LoansController extends HttpServlet {
	private static final String LOAN = "static/loans/loan.jsp";
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoansController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward="";
		ArrayList comicList = new ArrayList<>(ComicDao.selectComics().values());
		ArrayList personList = new ArrayList<>(PersonDao.selectPeople().values());
		request.setAttribute("comics", comicList);
		request.setAttribute("persons", personList);
        
        forward=LOAN;
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward="";
		String comicName = request.getParameter("name");
		String person = request.getParameter("person");
		
		LoanDao.insertLoan(person, comicName, Calendar.getInstance());
		
		forward="/welcome.jsp";
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
	}

}

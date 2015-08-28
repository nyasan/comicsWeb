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
import javax.servlet.http.HttpSession;

import dao.ComicDao;
import dao.LoanDao;
import dao.PersonDao;
import entities.Comic;
import entities.Copy;
import entities.Loan;
import entities.Person;

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
		String action = request.getParameter("action");
		HttpSession context= request.getSession();
		ArrayList comicList = new ArrayList<>(ComicDao.selectComics().values());
		ArrayList personList = new ArrayList<>(PersonDao.selectPeople().values());
		request.setAttribute("comics", comicList);
		request.setAttribute("persons", personList);
		if(action.equalsIgnoreCase("edit")){
			forward = LOAN;
        	String name = request.getParameter("name");
        	String comicName = request.getParameter("comicName");
            Loan loan = new Loan(new Person(name,"",""),new Copy(1, new Comic(comicName,null), true));
            context.setAttribute("action", "edit");
            request.setAttribute("loan", loan);
            
		}else
		{
		context.setAttribute("action", "insert");
        forward=LOAN;
		}
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward="";
		HttpSession context= request.getSession();
		String action =(String) context.getAttribute("action");
		String comicName = request.getParameter("name");
		String person = request.getParameter("person");
		if(action.equalsIgnoreCase("edit")){
			LoanDao.updateLoan(person,comicName);
		}else
		{
			LoanDao.insertLoan(person, comicName, Calendar.getInstance());			
		}
				
		response.sendRedirect("/ComicsWebProject/welcome.jsp");
	}

}

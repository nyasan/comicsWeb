package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ComicDao;
import dao.PersonDao;
import entities.Comic;
import entities.Person;

/**
 * Servlet implementation class PersonsController
 */
@WebServlet("/PersonsController")
public class PersonsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String INSERT_OR_EDIT = "static/persons/person.jsp";
    private static String LIST_PERSONS = "index.jsp";
    private static PersonDao dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward="";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")){
            String name = request.getParameter("name");
            dao.deletePerson(name);
            forward = LIST_PERSONS;
            request.setAttribute("comics", dao.selectPeople());    
        } else if (action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            String name = request.getParameter("name");
            dao.updatePerson(name, " ", " ");
            request.setAttribute("person", null);
        } else if (action.equalsIgnoreCase("listPersons")){
            forward = LIST_PERSONS;
            request.setAttribute("persons", dao.selectPeople());
        } else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
	} 

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String personName = request.getParameter("name"); 
		 Person person= (Person)PersonDao.searchPerson(personName);
		 if(person.getAdress().equalsIgnoreCase(""))
		 {
			 dao.insertPerson(request.getParameter("name"),request.getParameter("phone"),request.getParameter("adress"));			 
		 }
		 else{
			 dao.updatePerson(request.getParameter("name"), request.getParameter("phone"), request.getParameter("adress"));
			 request.setAttribute("admin", true);
		 }
		    RequestDispatcher view = request.getRequestDispatcher("/welcome.jsp");
	        view.forward(request, response);
	}

}

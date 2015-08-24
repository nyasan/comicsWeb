package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import transactions.People;

/**
 * Servlet implementation class ListPerson
 */
@WebServlet("/ListPerson")
public class ListPersons extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private People personList = People.getInstance();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListPersons() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		personList.loadMap();
		System.out.println(personList.showMap());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

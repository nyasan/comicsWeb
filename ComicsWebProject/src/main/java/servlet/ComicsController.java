package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ComicDao;
import entities.Comic;
import entities.Genre;

/**
 * Servlet implementation class ComicsController
 */
@WebServlet("/ComicsController")
public class ComicsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String INSERT_OR_EDIT = "static/comics/comic.jsp";
    private static String LIST_USER = "static/comics/listComics.jsp";
    private static ComicDao dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComicsController() {
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
	            dao.deleteComic(name);
	            forward = LIST_USER;
	            request.setAttribute("comics", dao.selectComics());    
	        } else if (action.equalsIgnoreCase("edit")){
	            forward = INSERT_OR_EDIT;
	            String name = request.getParameter("name");
	            Comic comic = (Comic)dao.searchComic(name);
	            request.setAttribute("comic", comic);
	        } else if (action.equalsIgnoreCase("listComics")){
	            forward = LIST_USER;
	            request.setAttribute("comics", dao.selectComics());
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
		    String comicName = request.getParameter("name");
	        
	        dao.insertComic(request.getParameter("name"),request.getParameter("Type") );;
	        
	        RequestDispatcher view = request.getRequestDispatcher(LIST_USER);
	        request.setAttribute("comics", dao.selectComics());
	        view.forward(request, response);
	}

}

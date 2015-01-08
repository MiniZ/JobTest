package servlet.auth;

import java.io.IOException;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.Entry;
import managers.EntryManager;

/**
 * Servlet implementation class addEntry
 */
@WebServlet("/addEntry")
public class addEntry extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addEntry() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		EntryManager manager = (EntryManager) getServletContext().getAttribute(
				EntryManager.ATTRIBUTE_NAME);
		String movieName = request.getParameter("movies");
		String entryType = request.getParameter("types");
		String username = (String) request.getSession()
				.getAttribute("username");
		if (username == null) {
			response.sendRedirect("index.jsp");
			return;
		}
		java.util.Date date= new java.util.Date();
		Timestamp currDate = new Timestamp(date.getTime());
		Entry newEntry = new Entry(username, currDate, movieName, entryType);
		manager.addEntry(newEntry);
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("user.jsp?id=" + username);
		dispatcher.forward(request, response);
	}

}
















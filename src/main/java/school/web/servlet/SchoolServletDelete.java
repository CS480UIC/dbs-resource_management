package school.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import school.dao.SchoolDao;
import school.domain.School;


/**
 * Servlet implementation class UserServlet
 */

public class SchoolServletDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SchoolServletDelete() {
        super();
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		SchoolDao schoolDao = new SchoolDao();
		School school = null;
		if(method.equals("search"))
		{
			try {
				school = schoolDao.findByCode(request.getParameter("username"));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
		
			if(school.getCode()!=null){
						System.out.println(school);
						request.setAttribute("school", school);
						request.getRequestDispatcher("/jsps/school/school_delete_output.jsp").forward(request, response);			
				}
				else{
				request.setAttribute("msg", "School not found");
				request.getRequestDispatcher("/jsps/school/school_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("delete"))
		{	
			try {
				schoolDao.delete(request.getParameter("code"));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "School Deleted");
			request.getRequestDispatcher("/jsps/school/school_read_output.jsp").forward(request, response);
		}
	}
}




package resource.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import resource.dao.ResourceDao;
import resource.domain.Resource;


/**
 * Servlet implementation class UserServlet
 */

public class ResourceServletDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResourceServletDelete() {
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
		ResourceDao resourceDao = new ResourceDao();
		Resource resource = null;
		if(method.equals("search"))
		{
			try {
				resource = resourceDao.findById(request.getParameter("id"));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
		
			if(resource.getId()!=null){
						System.out.println(resource);
						request.setAttribute("resource", resource);
						request.getRequestDispatcher("/jsps/resource/resource_delete_output.jsp").forward(request, response);			
				}
				else{
				request.setAttribute("msg", "Resource not found");
				request.getRequestDispatcher("/jsps/resource/resource_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("delete"))
		{	
			try {
				resourceDao.delete(request.getParameter("id"));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Resource Deleted");
			request.getRequestDispatcher("/jsps/resource/resource_read_output.jsp").forward(request, response);
		}
	}
}




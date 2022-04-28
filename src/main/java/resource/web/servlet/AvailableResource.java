package resource.web.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import resource.service.ResourceService;

/**
 * Servlet implementation class findAll
 */

public class AvailableResource extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ResourceService resourceservice = new ResourceService();
		try {
			request.setAttribute("ResourceList", resourceservice.findAvailableResource()); //todo
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			e.printStackTrace();
		}
//		try {
//			List<Object> li = resourceservice.findall(); //todo	
//			for(int i = 0; i < li.size();i++){
//				System.out.println(li.get(i).toString());
//			}
//			
//		} catch (InstantiationException | IllegalAccessException
//				| ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//		
		
		request.getRequestDispatcher("/jsps/resource/q2_list_resource.jsp").forward(request, response);
	}

}

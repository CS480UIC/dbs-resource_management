package resource.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import resource.dao.ResourceDao;
import resource.domain.Resource;

/**
 * Servlet implementation class UserServlet
 */

public class ResourceServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ResourceServletUpdate() {
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
		ResourceDao resourcedao = new ResourceDao();
		Resource resource = null;

		if(method.equals("search"))
		{
			try {
				resource = resourcedao.findById(request.getParameter("id"));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}

			if(resource.getId()!=null){
				request.setAttribute("resource", resource);
				request.getRequestDispatcher("/jsps/resource/resource_update_output.jsp").forward(request, response);

			}
			else{
				request.setAttribute("msg", "Resource not found");
				request.getRequestDispatcher("/jsps/resource/resource_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("update"))
		{
			Map<String,String[]> paramMap = request.getParameterMap();
			Resource form = new Resource();
			List<String> info = new ArrayList<String>();

			for(String name : paramMap.keySet()) {
				String[] values = paramMap.get(name);
				info.add(values[0]);
			}
		//	form.setSchool_code(info.get(2));
			form.setResource_name(info.get(2));
			form.setResource_location(info.get(3));
			form.setFull_capacity(Integer.parseInt(info.get(4)));
			form.setAvailable_capacity(Integer.parseInt(info.get(5)));
			form.setId(request.getParameter("id"));

			try {
				resourcedao.update(form);

			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Resource Updated");
			request.getRequestDispatcher("/jsps/resource/resource_read_output.jsp").forward(request, response);
		}
	}
}




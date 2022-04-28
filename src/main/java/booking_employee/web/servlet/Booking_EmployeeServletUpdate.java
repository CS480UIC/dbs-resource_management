package booking_employee.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import booking_employee.dao.Booking_EmployeeDao;
import booking_employee.domain.Booking_Employee;

/**
 * Servlet implementation class UserServlet
 */

public class Booking_EmployeeServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Booking_EmployeeServletUpdate() {
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
		Booking_EmployeeDao booking_employeedao = new Booking_EmployeeDao();
		Booking_Employee booking_employee = null;

		if(method.equals("search"))
		{
			try {
				booking_employee = booking_employeedao.findByUserid(request.getParameter("user_id"));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}

			if(booking_employee.getUser_id()!=null){
				request.setAttribute("booking_employee", booking_employee);
				request.getRequestDispatcher("/jsps/booking_employee/booking_employee_update_output.jsp").forward(request, response);

			}
			else{
				request.setAttribute("msg", "Booking Employee not found");
				request.getRequestDispatcher("/jsps/booking_employee/booking_employee_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("update"))
		{
			Map<String,String[]> paramMap = request.getParameterMap();
			Booking_Employee form = new Booking_Employee();
			List<String> info = new ArrayList<String>();

			for(String name : paramMap.keySet()) {
				String[] values = paramMap.get(name);
				info.add(values[0]);
			}
	
			form.setEmployee_name(info.get(2));
			form.setPassword(info.get(3));
			form.setUser_id(request.getParameter("user_id"));

			try {
				booking_employeedao.update(form);

			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Booking Employee Updated");
			request.getRequestDispatcher("/jsps/booking_employee/booking_employee_read_output.jsp").forward(request, response);
		}
	}
}




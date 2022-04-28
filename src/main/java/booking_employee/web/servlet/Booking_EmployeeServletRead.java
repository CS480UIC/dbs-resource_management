package booking_employee.web.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import booking_employee.dao.Booking_EmployeeDao;
import booking_employee.domain.Booking_Employee;


/**
 * Servlet implementation class UserServlet
 */

public class Booking_EmployeeServletRead extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Booking_EmployeeServletRead() {
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
		Booking_Employee booking_employee = null;
		Booking_EmployeeDao booking_employeeDao = new Booking_EmployeeDao();
		
		try {
			booking_employee = booking_employeeDao.findByUserid(request.getParameter("user_id"));
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		}
		
		if(booking_employee.getUser_id()!=null){
					System.out.println(booking_employee);
					request.setAttribute("booking_employee", booking_employee);
					request.getRequestDispatcher("/jsps/booking_employee/booking_employee_read_output.jsp").forward(request, response);
			}
			else{
			request.setAttribute("msg", "Booking Employee not found");
			request.getRequestDispatcher("/jsps/booking_employee/booking_employee_read_output.jsp").forward(request, response);
		}
	}
}




package booking.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import booking.domain.Booking;
import booking.service.BookingException;
import booking.service.BookingService;


/**
 * Servlet implementation class UserServlet
 */

public class BookingServletCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookingServletCreate() {
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
		BookingService bookingservice = new BookingService();
		Map<String,String[]> paramMap = request.getParameterMap();
		Booking form = new Booking();
		List<String> info = new ArrayList<String>();

		for(String name : paramMap.keySet()) {
			String[] values = paramMap.get(name);
			info.add(values[0]);
		}
		form.setBooking_id(info.get(0));
		form.setEmployee_user_id(info.get(1));
		form.setResource_id(info.get(2));
		form.setBooked_capacity(Integer.parseInt(info.get(3)));
		form.setBooking_slot(java.sql.Timestamp.valueOf(info.get(4)));	
		form.setNumber_of_hours(Integer.parseInt(info.get(5)));
		form.setNotes(info.get(6));
		
		try {
			bookingservice.create(form);
			response.sendRedirect( request.getContextPath() + "/jsps/main.jsp");
			
		} catch (ClassNotFoundException | BookingException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} 
		
	}

}

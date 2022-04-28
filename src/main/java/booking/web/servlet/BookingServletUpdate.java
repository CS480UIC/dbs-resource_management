package booking.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import booking.dao.BookingDao;
import booking.domain.Booking;

/**
 * Servlet implementation class UserServlet
 */

public class BookingServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BookingServletUpdate() {
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
		BookingDao bookingdao = new BookingDao();
		Booking booking = null;

		if(method.equals("search"))
		{
			try {
				booking = bookingdao.findByBookingID(request.getParameter("booking_id"));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}

			if(booking.getBooking_id()!=null){
				request.setAttribute("booking", booking);
				request.getRequestDispatcher("/jsps/booking/booking_update_output.jsp").forward(request, response);

			}
			else{
				request.setAttribute("msg", "Booking not found");
				request.getRequestDispatcher("/jsps/booking/booking_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("update"))
		{
			Map<String,String[]> paramMap = request.getParameterMap();
			Booking form = new Booking();
			List<String> info = new ArrayList<String>();

			for(String name : paramMap.keySet()) {
				String[] values = paramMap.get(name);
				info.add(values[0]);
			}
			form.setBooked_capacity(Integer.parseInt(info.get(2)));
			form.setBooking_slot(java.sql.Timestamp.valueOf(info.get(3)));
			form.setNumber_of_hours(Integer.parseInt(info.get(4)));
			form.setNotes(info.get(5));
			form.setBooking_id(request.getParameter("booking_id"));

			try {
				bookingdao.update(form);

			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Booking Updated");
			request.getRequestDispatcher("/jsps/booking/booking_read_output.jsp").forward(request, response);
		}
	}
}




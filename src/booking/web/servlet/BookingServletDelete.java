package booking.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import booking.dao.BookingDao;
import booking.domain.Booking;


/**
 * Servlet implementation class UserServlet
 */

public class BookingServletDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookingServletDelete() {
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
		BookingDao bookingDao = new BookingDao();
		Booking booking = null;
		if(method.equals("search"))
		{
			try {
				booking = bookingDao.findByBookingID(request.getParameter("booking_id"));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
		
			if(booking.getBooking_id()!=null){
						System.out.println(booking);
						request.setAttribute("booking", booking);
						request.getRequestDispatcher("/jsps/booking/booking_delete_output.jsp").forward(request, response);			
				}
				else{
				request.setAttribute("msg", "Booking not found");
				request.getRequestDispatcher("/jsps/booking/booking_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("delete"))
		{	
			try {
				bookingDao.delete(request.getParameter("booking_id"));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Booking Deleted");
			request.getRequestDispatcher("/jsps/booking/booking_read_output.jsp").forward(request, response);
		}
	}
}




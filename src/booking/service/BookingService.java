package booking.service;


import java.util.List;

import booking.dao.BookingDao;
import booking.domain.Booking;

/**
 * logic functions such as register, login
 * @author Madhumitha Rajarajan
 *
 */
public class BookingService {
	private BookingDao bookingDao = new BookingDao();
	
	/**
	 * register a Booking
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(Booking form) throws BookingException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Booking
		Booking booking = bookingDao.findByBookingID(form.getBooking_id());
		if(booking.getBooking_id()!=null && booking.getBooking_id().equals(form.getBooking_id())) throw new BookingException("This booking ID has been already registered!");
		bookingDao.add(form);
	}
	/**
	 * Login function
	 * @param form
	 * @return
	 * @throws UserException 
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	//Implement queries over here and delete comment
	/**
	 * public void login(Booking form) throws BookingException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		Booking user = bookingDao.findByBooking(form.getBooking_id());
		if(user.getBooking_id()==null) throw new BookingException("The user is not in the database");
		
		String password = user.getPassword();
		
		if(password!=null && !password.equals(form.getPassword()))
			throw new BookingException(" The password is not right");
		
	}
		*/


	public List<Object> findUserBooking() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return bookingDao.findUserBooking();
		}
	public List<Object> findBookedResources() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return bookingDao.findBookedResources();
		}

}

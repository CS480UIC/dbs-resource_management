package booking.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import booking.domain.BookedResource;

//import java.util.ArrayList;
//import java.util.List;

import booking.domain.Booking;
import resource.domain.Resource;

/**
 * DDL functions performed in database
 */
public class BookingDao {
	
	/**
	 * user name to connect to the database 
	 */
	private String MySQL_user = "resource_management"; 
	
	/**
	 * password of your username to connect to the database
	 */
	private String MySQL_password = "resource"; 

	public Booking findByBookingID(String booking_id) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Booking booking = new Booking();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/resource_management", MySQL_user, MySQL_password);
		    String sql = "select * from booking where booking_id=?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
			preparestatement.setString(1,booking_id);
		    ResultSet resultSet = preparestatement.executeQuery();

		    while(resultSet.next()){
		    	String book_id = resultSet.getString("booking_id");
		    	if(book_id.equals(booking_id)){
		    		booking.setBooking_id(resultSet.getString("booking_id"));
		    		booking.setEmployee_user_id(resultSet.getString("employee_user_id"));
		    		booking.setResource_id(resultSet.getString("resource_id"));
		    		booking.setBooked_capacity(resultSet.getInt("booked_capacity"));
		    		booking.setBooking_slot(resultSet.getTimestamp("booking_slot"));
		    		booking.setNumber_of_hours(resultSet.getInt("number_of_hours"));
		    		booking.setNotes(resultSet.getString("notes"));
		    	}
		    }
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return booking;
	}	
	

	
	public void add(Booking booking) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/resource_management", MySQL_user, MySQL_password);
			
			String sql = "insert into booking values(?,?,?,?,?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,booking.getBooking_id());
		    preparestatement.setString(2,booking.getEmployee_user_id());
		    preparestatement.setString(3,booking.getResource_id());
		    preparestatement.setInt(4,booking.getBooked_capacity());
		    preparestatement.setTimestamp(5,booking.getBooking_slot());
		    preparestatement.setInt(6,booking.getNumber_of_hours());
		    preparestatement.setString(7,booking.getNotes());
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	/**
	 * @param form
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public void update(Booking booking) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/resource_management", MySQL_user, MySQL_password);
			
			String sql = "UPDATE booking SET booked_capacity = ?,booking_slot = ?,number_of_hours = ?,notes =? where booking_id = ?;";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,booking.getBooked_capacity());
			preparestatement.setTimestamp(2,booking.getBooking_slot());
		    preparestatement.setInt(3,booking.getNumber_of_hours());
		    preparestatement.setString(4,booking.getNotes());
		    preparestatement.setString(5,booking.getBooking_id());
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	
	/**
	 * @param username
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public void delete(String bookingid) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/resource_management", MySQL_user, MySQL_password);
			
			String sql = "delete from booking where booking_id = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,bookingid);
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}



	public List<Object> findUserBooking() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/resource_management", MySQL_user, MySQL_password);
			String sql = "select booking_id, employee_user_id from booking where employee_user_id = 'skati6'";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
				Booking booking = new Booking();
				booking.setBooking_id(resultSet.getString("booking_id"));
				booking.setEmployee_user_id(resultSet.getString("employee_user_id"));
				
	    		list.add(booking);
			 }
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}


	public List<Object> findBookedResources() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/resource_management", MySQL_user, MySQL_password);
			String sql = "select resource.resource_name,booking_employee.employee_name from resource join booking ON resource.id = booking.resource_id join booking_employee ON booking.employee_user_id = booking_employee.user_id\n"
					+ "WHERE booking.booked_capacity > (select min(booking.booked_capacity) from booking) AND booking.number_of_hours > 2 ";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
				BookedResource bookedresource = new BookedResource();
				bookedresource.setResource_name(resultSet.getString("resource_name"));
				bookedresource.setEmployee_name(resultSet.getString("employee_name"));
				
	    		list.add(bookedresource);
			 }
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}



	public List<Object> findMax() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/resource_management", MySQL_user, MySQL_password);
			String sql = "select resource_id, number_of_hours from booking where number_of_hours = (select max(number_of_hours) from booking)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
				Booking booking = new Booking();
				booking.setResource_id(resultSet.getString("resource_id"));
				booking.setNumber_of_hours(resultSet.getInt("number_of_hours"));
				
	    		list.add(booking);
			 }
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
	}

}

package booking_employee.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




//import java.util.ArrayList;
//import java.util.List;

import booking_employee.domain.Booking_Employee;

/**
 * DDL functions performed in database
 */
public class Booking_EmployeeDao {
	
	/**
	 * user name to connect to the database 
	 */
	private String MySQL_user = "resource_management"; //TODO change user
	
	/**
	 * password of your user_id to connect to the database
	 */
	private String MySQL_password = "resource"; //TODO change password

	public Booking_Employee findByUserid(String user_id) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Booking_Employee booking_employee = new Booking_Employee();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/resource_management", MySQL_user, MySQL_password);
		    String sql = "select * from booking_employee where user_id=?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,user_id);
		    ResultSet resultSet = preparestatement.executeQuery();

		    while(resultSet.next()){
		    	String user_name = resultSet.getString("user_id");
		    	if(user_name.equals(user_id)){
		    		booking_employee.setUser_id(resultSet.getString("user_id"));
		    		booking_employee.setSchool_code(resultSet.getString("school_code"));
		    		booking_employee.setEmployee_name(resultSet.getString("employee_name"));
		    		booking_employee.setPassword(resultSet.getString("password"));
		    				
		    	}
		    }
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return booking_employee;
	}	
	
	/**
	 * insert Booking_Employee
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	public void add(Booking_Employee form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/resource_management", MySQL_user, MySQL_password);
			
			String sql = "insert into booking_employee values(?,?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,form.getUser_id());
		    preparestatement.setString(2,form.getSchool_code());
		    preparestatement.setString(3,form.getEmployee_name());
		    preparestatement.setString(4,form.getPassword());
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
	public void update(Booking_Employee form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/resource_management", MySQL_user, MySQL_password);
			
			String sql = "UPDATE booking_employee SET employee_name = ?, password = ? where user_id = ?;";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			preparestatement.setString(1,form.getEmployee_name());
			preparestatement.setString(2,form.getPassword());
		    preparestatement.setString(3,form.getUser_id());
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	
	/**
	 * @param user_id
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public void delete(String user_id) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/resource_management", MySQL_user, MySQL_password);
			
			String sql = "delete from booking_employee where user_id = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,user_id);
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}

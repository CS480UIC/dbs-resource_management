package school.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




//import java.util.ArrayList;
//import java.util.List;

import school.domain.School;

/**
 * DDL functions performed in database
 */
public class SchoolDao {
	
	/**
	 * user name to connect to the database 
	 */
	private String MySQL_user = "resource_management"; //TODO change user
	
	/**
	 * name of your code to connect to the database
	 */
	private String MySQL_name = "resource"; //TODO change name

	public School findByCode(String code) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		School school = new School();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/bookstore", MySQL_user, MySQL_name);
		    String sql = "select * from school where code=?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,code);
		    ResultSet resultSet = preparestatement.executeQuery();

		    while(resultSet.next()){
		    	String school_code = resultSet.getString("code");
		    	if(school_code.equals(code)){
		    		school.setCode(resultSet.getString("code"));
		    		school.setName(resultSet.getString("name"));
		    		school.setAddress(resultSet.getString("address"));
		    		school.setHead(resultSet.getString("head"));
		    		school.setLogin_id(resultSet.getString("login_id"));
		    		school.setPassword(resultSet.getString("password"));	
		    	}
		    }
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return school;
	}	
	
	/**
	 * insert School
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	public void add(School form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/bookstore", MySQL_user, MySQL_name);
			
			String sql = "insert into school values(?,?,?,?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,form.getCode());
		    preparestatement.setString(2,form.getName());
		    preparestatement.setString(3,form.getAddress());
		    preparestatement.setString(4,form.getHead());
		    preparestatement.setString(5,form.getLogin_id());
		    preparestatement.setString(6,form.getPassword());
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
	public void update(School form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/bookstore", MySQL_user, MySQL_name);
			
			String sql = "UPDATE school SET name = ?, address = ?, head = ?, login_id = ?, password = ? where code = ?;";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,form.getName());
			preparestatement.setString(2,form.getAddress());
		    preparestatement.setString(3,form.getHead());
		    preparestatement.setString(4,form.getLogin_id());
			preparestatement.setString(5,form.getPassword());
		    preparestatement.setString(6,form.getCode());
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	/**
	 * @param code
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public void delete(String code) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/bookstore", MySQL_user, MySQL_name);
			
			String sql = "delete from school where code = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,code);
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}

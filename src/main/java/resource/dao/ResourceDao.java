package resource.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import java.util.ArrayList;
//import java.util.List;

import resource.domain.Resource;
import user.domain.User;

/**
 * DDL functions performed in database
 */
public class ResourceDao {
	
	/**
	 * user name to connect to the database 
	 */
	private String MySQL_user = "resource_management"; //TODO change user
	
	/**
	 * password of your id to connect to the database
	 */
	private String MySQL_password = "resource"; //TODO change password

	public Resource findById(String id) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Resource resource = new Resource();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/resource_management", MySQL_user, MySQL_password);
		    String sql = "select * from resource where id=?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,id);
		    ResultSet resultSet = preparestatement.executeQuery();

		    while(resultSet.next()){
		    	String user_name = resultSet.getString("id");
		    	if(user_name.equals(id)){
		    		resource.setId(resultSet.getString("id"));
		    		resource.setSchool_code(resultSet.getString("school_code"));
		    		resource.setResource_name(resultSet.getString("resource_name"));
		    		resource.setResource_location(resultSet.getString("resource_location"));
		    		resource.setFull_capacity(resultSet.getInt("full_capacity"));
		    		resource.setAvailable_capacity(resultSet.getInt("available_capacity"));
		    	}
		    }
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return resource;
	}	
	
	/**
	 * insert Resource
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	public void add(Resource form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/resource_management", MySQL_user, MySQL_password);
			
			String sql = "insert into resource values(?,?,?,?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,form.getId());
		    preparestatement.setString(2,form.getSchool_code());
		    preparestatement.setString(3,form.getResource_name());
		    preparestatement.setString(4,form.getResource_location());
		    preparestatement.setInt(5,form.getFull_capacity());
		    preparestatement.setInt(6,form.getAvailable_capacity());
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
	public void update(Resource form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/resource_management", MySQL_user, MySQL_password);
			
			String sql = "UPDATE resource SET resource_name = ?, resource_location = ?, full_capacity = ?, available_capacity = ?  where id = ?;";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		   // preparestatement.setString(1,form.getSchool_code());
			preparestatement.setString(1,form.getResource_name());
			preparestatement.setString(2,form.getResource_location());
			preparestatement.setInt(3,form.getFull_capacity());
			preparestatement.setInt(4,form.getAvailable_capacity());
		    preparestatement.setString(5,form.getId());
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	/**
	 * @param id
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public void delete(String id) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/resource_management", MySQL_user, MySQL_password);
			
			String sql = "delete from resource where id = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,id);
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}


	public List<Object> findAvailableResource() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/resource_management", MySQL_user, MySQL_password);
			String sql = "select id,resource_name,available_capacity from resource where available_capacity > 10";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
				Resource resource = new Resource();
				resource.setId(resultSet.getString("id"));
				resource.setResource_name(resultSet.getString("resource_name"));
				resource.setAvailable_capacity(resultSet.getInt("available_capacity"));
	    		list.add(resource);
			 }
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}
}

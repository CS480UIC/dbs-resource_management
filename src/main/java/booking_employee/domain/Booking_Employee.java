package booking_employee.domain;

public class Booking_Employee {
	
	private String user_id;
	private String school_code; 
	private String employee_name;
	private String password;
	private Integer count;
	
	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getSchool_code() {
		return school_code;
	}

	public void setSchool_code(String school_code) {
		this.school_code = school_code;
	}

	public String getEmployee_name() {
		return employee_name;
	}

	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Booking_Employee [ user_id=" + user_id + ",school_code=" + school_code +", employee_name=" + employee_name + ", password="
				+ password + "]";
	}
	
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		// TODO Auto-generated method stub
		this.count = count;
		
	}

}

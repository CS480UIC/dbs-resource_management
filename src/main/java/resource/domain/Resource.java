package resource.domain;


public class Resource {
	/*
	 * Correspond to the user table
	 */
	
	private String id;
	private String school_code; 
	private String resource_name;
	private String resource_location;
	private Integer full_capacity; 
	private Integer available_capacity;
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSchool_code() {
		return school_code;
	}

	public void setSchool_code(String school_code) {
		this.school_code = school_code;
	}

	public String getResource_name() {
		return resource_name;
	}

	public void setResource_name(String resource_name) {
		this.resource_name = resource_name;
	}
	public String getResource_location() {
		return resource_location;
	}

	public void setResource_location(String resource_location) {
		this.resource_location = resource_location;
	}
	public Integer getFull_capacity() {
		return full_capacity;
	}

	public void setFull_capacity(Integer full_capacity) {
		this.full_capacity = full_capacity;
	}
	public Integer getAvailable_capacity() {
		return available_capacity;
	}

	public void setAvailable_capacity(Integer available_capacity) {
		this.available_capacity = available_capacity;
	}

	@Override
	public String toString() {
		return "Resource [ id=" + id + ", school_code="
				+ school_code + ", resource_name=" + resource_name +", full_capacity=" + full_capacity +", available_capacity=" + available_capacity +"]";
	}
}

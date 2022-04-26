package school.domain;

public class School {
	private String code;
	private String name; 
	private String address;
	private String head;
	private String login_id; 
	private String password;
	
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}
	public String getLogin_id() {
		return login_id;
	}

	public void setLogin_id(String login_id) {
		this.login_id = login_id;
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "School [ code=" + code + ", name="
				+ name + ", address=" + address +", head=" + head +", login_id=" + login_id +", password=" + password +"]";
	}

}

package booking.domain;
import java.sql.Timestamp;

public class Booking {

	
	private String booking_id;
	private String employee_user_id;
	private String resource_id;
	private Integer booked_capacity; 
	private Timestamp booking_slot;
	private Integer number_of_hours;
	private String notes;
	
	
	
	public String getBooking_id() {
		return booking_id;
	}

	public void setBooking_id(String booking_id) {
		this.booking_id = booking_id;
	}
	
	public String getEmployee_user_id() {
		
		return employee_user_id;
	}
	
	public void setEmployee_user_id(String employee_user_id) {
		this.employee_user_id = employee_user_id;
	}
	
	public String getResource_id() {
		return resource_id;
	}

	public void setResource_id(String resource_id) {
		this.resource_id = resource_id;
	}

	public Integer getBooked_capacity() {
		return booked_capacity;
	}

	public void setBooked_capacity(Integer booked_capacity) {
		this.booked_capacity = booked_capacity;
	}

	public Timestamp getBooking_slot() {
		return booking_slot;
	}

	public void setBooking_slot(Timestamp booking_slot) {
		this.booking_slot = booking_slot;
	}
	
	public Integer getNumber_of_hours() {
		return number_of_hours;
	}

	public void setNumber_of_hours(Integer number_of_hours) {
		this.number_of_hours = number_of_hours;
	}
	
	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	@Override
	public String toString() {
		return "Booking [ booking_id=" + booking_id + ", employee_user_id=" + employee_user_id + ",resource_id=" + resource_id + ", booked_capcity="
				+ booked_capacity + ", booking_slot=" + booking_slot +", number_of_hours=" + number_of_hours +", notes=" + notes +"]";
	}

	

	
}

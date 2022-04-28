package booking_employee.service;


import booking_employee.dao.Booking_EmployeeDao;
import booking_employee.domain.Booking_Employee;

/**
 * logic functions 
 * @author Madhumitha Rajarajan
 *
 */
public class Booking_EmployeeService {
	private Booking_EmployeeDao booking_employeeDao = new Booking_EmployeeDao();
	
	/**
	 * register a Booking_Employee
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(Booking_Employee form) throws Booking_EmployeeException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Booking_Employee
		Booking_Employee booking_employee = booking_employeeDao.findByUserid(form.getUser_id());
		if(booking_employee.getUser_id()!=null && booking_employee.getUser_id().equals(form.getUser_id())) throw new Booking_EmployeeException("This user name has been registered!");
		booking_employeeDao.add(form);
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
//	public void login(Booking_Employee form) throws Booking_EmployeeException, ClassNotFoundException, InstantiationException, IllegalAccessException {
//		Booking_Employee user = booking_employeeDao.findByUserid(form.getUser_id());
//		if(user.getUser_id()==null) throw new Booking_EmployeeException("The user is not in the database");
//		
//		String password = user.getPassword();
//		
//		if(password!=null && !password.equals(form.getPassword()))
//			throw new Booking_EmployeeException(" The password is not right");
//		
//	}
}

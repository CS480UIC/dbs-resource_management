package school.service;


import school.dao.SchoolDao;
import school.domain.School;
 public class SchoolService {
	private SchoolDao schoolDao = new SchoolDao();
	
	/**
	 * register a School
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(School form) throws SchoolException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of School
		School school = schoolDao.findByCode(form.getCode());
		if(school.getCode()!=null && school.getCode().equals(form.getCode())) throw new SchoolException("This school has been registered!");
		schoolDao.add(form);
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
	/*public void login(School form) throws SchoolException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		School user = schoolDao.findByCode(form.getCode());
		if(user.getCode()==null) throw new SchoolException("This school was not found in the database");
		
		String password = user.getPassword();
		
		if(password!=null && !password.equals(form.getPassword()))
			throw new SchoolException(" The password is not right");
		
	} */
}

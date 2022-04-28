package school.service;


import java.util.List;

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



	public List<Object> findSchoolName() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return schoolDao.findSchoolName();
		}
}

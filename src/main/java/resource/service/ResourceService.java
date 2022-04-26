package resource.service;


import resource.dao.ResourceDao;
import resource.domain.Resource;

/**
 * logic functions such as register, login
 * @author Aayush Makharia
 *
 */
public class ResourceService {
	private ResourceDao resourceDao = new ResourceDao();
	
	/**
	 * register a Resource
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(Resource form) throws ResourceException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Resource
		Resource resource = resourceDao.findById(form.getId());
		if(resource.getId()!=null && resource.getId().equals(form.getId())) throw new ResourceException("This Resource ID has been registered!");
		resourceDao.add(form);
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
	/*public void login(Resource form) throws ResourceException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		Resource user = resourceDao.findById(form.getId());
		if(user.getId()==null) throw new ResourceException("The Resource is not in the database");
		
		String password = user.getPassword();
		
		if(password!=null && !password.equals(form.getPassword()))
			throw new ResourceException(" The password is not right");
		
	}*/
}

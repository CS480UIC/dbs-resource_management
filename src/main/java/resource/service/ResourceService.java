package resource.service;


import java.util.List;

import resource.dao.ResourceDao;
import resource.domain.Resource;


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
	
	
	public List<Object> findAvailableResource() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return resourceDao.findAvailableResource();
		}
}

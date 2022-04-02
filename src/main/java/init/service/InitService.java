package init.service;

import java.io.InputStream;


import init.dao.InitDao;


public class InitService {
	private InitDao initDao = new InitDao();
		
	/**
	 * Register a user
	 * @param input 
	 */
	public void initializeDB(InputStream input) throws InitException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		
		
		initDao.initialize(input);
	
	
	}

	
}

	
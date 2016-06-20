/**
 * 
 */
package com.bean;

import java.io.Serializable;

import com.model.User;
import com.service.UserService;

/**
 * @author mac
 *
 */
public class LoginBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	//private static Logger log = Logger.getLogger(UserManagedBean.class);
	private static final String SUCCESS = "success";
	private static final String ERROR   = "error";	
	
	
	
	public LoginBean() {
	}
	
	private String name;
	private String password;
	
	public String getName() {
		return name;
	}
	
	//Don't be changed once setted 
	
	public void setName(final String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(final String password) {
		this.password = password;
	}
	
	
	public String save(){
		String result = null;
		User user = new User();
		user.setName(this.getName());
		user.setPassword(this.getPassword() );
		
		try {
			
			UserService userservice = new UserService();
			userservice.persist(user);
			result = SUCCESS;
			
		} catch (Exception e) {
		
			result = ERROR;
		}
		return result;
			
			
	
	}
	
	
	
}

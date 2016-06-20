package com.service;

import java.util.List;

import com.dao.UserDao;
import com.model.Arret;
import com.model.User;

public class UserService {
	
	private static UserDao userdao;
	
	public UserService(){
		
		userdao = new UserDao();
	}
	
	public void persist(User entity){
		userdao.openCurrentSessionwithTransaction();
		userdao.persist(entity);
		userdao.closeCurrentSessionWithTransaction();	
	}
	
	public void update(User entity){
		userdao.openCurrentSessionwithTransaction();
		userdao.update(entity);
		userdao.closeCurrentSessionWithTransaction();
	}
	
	public User finById(Integer id){
		userdao.openCurrentSession();
		User user = userdao.findById(id);
		userdao.closeCurrentSession();
		return user;
	}
	
	public void delete(Integer id){
		userdao.openCurrentSessionwithTransaction();
		User user = userdao.findById(id);
		userdao.delete(user);
		userdao.closeCurrentSessionWithTransaction();
	}
	
	public List<User> findAll(){
		userdao.openCurrentSession();
		List<User> users = userdao.findAll();
		userdao.closeCurrentSession();
		return users;
		}

	public void deletAll(){
		userdao.openCurrentSessionwithTransaction();
		userdao.deleteAll();
		userdao.closeCurrentSessionWithTransaction();
	}

}

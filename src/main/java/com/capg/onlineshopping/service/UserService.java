package com.capg.onlineshopping.service;

import java.util.List;

import com.capg.onlineshopping.entity.User;
import com.capg.onlineshopping.exceptions.IdNotFoundException;
import com.capg.onlineshopping.exceptions.InvalidEmailException;
import com.capg.onlineshopping.exceptions.InvalidPasswordException;
import com.capg.onlineshopping.exceptions.UserAlreadyExistSException;
import com.capg.onlineshopping.exceptions.UserNotFoundException;

public interface UserService {
	
	public User addUser(User user) throws   UserAlreadyExistSException, InvalidEmailException,InvalidPasswordException;
	public List<User> fetchUsers();
	public User updateUserDetail(int id, User user);
	public User updateUserDetailAddress(int id, String address) ;
	public String deleteUserById(int id);
	public User checkUserLogin(User user) throws UserNotFoundException;
	public String userLogin(String email, String password) throws InvalidEmailException, InvalidPasswordException;
	
	public User getUserProfileById(int userId) throws IdNotFoundException;
}

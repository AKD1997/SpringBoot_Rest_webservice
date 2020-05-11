package com.rest.webservice.restfulwebservicess.User.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.rest.webservice.restfulwebservicess.User.model.User;

@Service
public class UserService {
	private static List<User> users = new ArrayList<>();
	private static int usercount = 3;
	static {
		users.add(new User(1, "Amit", new Date()));
		users.add(new User(2, "Banshi", new Date()));
		users.add(new User(3, "Jitendra", new Date()));
	}

	// here we are create a findAll method to return All users back
	public List<User> FindAll() {

		return users;
	}

//here we are save new users to create 	
	public User save(User user) {

		if (user.getId() == null) {
			user.setId(++usercount);
		}
		if (user.getBdayDate() == null) {
			user.setBdayDate(new Date());
		}
		users.add(user);

		return user;
	}

	// here we find one user by its id
	public User findOne(int id) {

		for (User user : users) {
			if (user.getId().equals(id)) {
				return user;
			}
		}
		return null;
	}

	public User DeleteByID(int id) {

		Iterator<User> iterator = users.iterator();
		while (iterator.hasNext()) {
			User user = iterator.next();
			if (user.getId() == id) {
				iterator.remove();
				return user;
			}
		}
		return null;

	}
}

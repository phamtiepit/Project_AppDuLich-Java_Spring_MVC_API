package com.itplus.dao;

import java.util.HashMap;
import java.util.List;

import com.itplus.entity.User;

public interface UserDao {
	List<User> getAllUser();
	void addUser(User user);
	void updateUser(User user);
	User getUserById(int id);
	void deleteUser(int id);
	HashMap<String, Object> register(User user);

    User getUserByEmail(String email);
    HashMap<String, Object> changePassword(int id, String oldPassword, String newPassword);

    HashMap<String, Object> updatePassword(int id, String newPassword);
}

package com.itplus.dao;

import com.itplus.entity.Admin;

public interface AdminDao {
	public Admin login(String username, String password);
}

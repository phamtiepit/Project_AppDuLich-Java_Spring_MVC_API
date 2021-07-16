package com.itplus.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itplus.dao.AdminDao;
import com.itplus.entity.Admin;
import com.itplus.model.AdminDTO;
import com.itplus.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{
	@Autowired
	AdminDao adminDao;
	@Override
	public AdminDTO login(AdminDTO adminDTO) {
		Admin admin = adminDao.login(adminDTO.getUsername(),adminDTO.getPassword());
		AdminDTO adminDTO2 = new AdminDTO();
		adminDTO2.setId(admin.getId());
		adminDTO2.setUsername(admin.getUsername());
		adminDTO2.setPassword(admin.getPassword());
		adminDTO2.setFullname(admin.getFullname());
		return adminDTO2;		
	}
}

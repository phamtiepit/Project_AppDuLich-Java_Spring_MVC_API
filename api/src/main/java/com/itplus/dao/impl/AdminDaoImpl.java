package com.itplus.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.itplus.dao.AdminDao;
import com.itplus.entity.Admin;


@Repository
public class AdminDaoImpl implements AdminDao{
	private final String TABLE_NAME = "admin";
	@Autowired
	JdbcTemplate jdbcTemplate;
		@Override
		public Admin login(String username, String password) {
			String sql = "select * from "+TABLE_NAME+" where username = ? AND password = ?";
			try {
				return jdbcTemplate.queryForObject(sql, new Object[] {username,password}, new RowMapper<Admin>(){
					@Override
					public Admin mapRow(ResultSet rs, int rowNum) throws SQLException {
						Admin admin = new Admin();
						admin.setId(rs.getInt("id"));
						admin.setUsername(rs.getString("username"));
						admin.setPassword(rs.getString("password"));
						admin.setFullname(rs.getString("fullname"));
						return admin;
					}
				});
			} catch (Exception e) {
				return null;
			}					
		}
			

}

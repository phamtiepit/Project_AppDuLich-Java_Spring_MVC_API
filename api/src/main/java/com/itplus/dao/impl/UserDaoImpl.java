package com.itplus.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.itplus.Util.MD5Util;
import com.itplus.dao.UserDao;
import com.itplus.entity.User;


@Repository
public class UserDaoImpl implements UserDao{

	private final String TABLE_NAME = "user";
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		String sqlString = "Select * from "+TABLE_NAME;
		List<User> listUser= jdbcTemplate.query(sqlString, new Object[] {},new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setPhone(rs.getInt("phone"));
				user.setAddress(rs.getString("address"));
				user.setEmail(rs.getString("email"));
				return user;
			}
			});
		return listUser;
	}
	@Override
	public void addUser(User user) {
		String sql = "insert into "+TABLE_NAME+"(username,password,phone,address,email) values(?,?,?,?,?)";
		jdbcTemplate.update(sql, user.getUsername(), user.getPassword(),user.getPhone(),user.getAddress(),user.getEmail());
		
	}
	@Override
	public void updateUser(User user) {
		String sql = "update "+TABLE_NAME+" set username= ?, password = ?, phone = ?, address=?, email=? where id = ?";
		jdbcTemplate.update(sql, user.getUsername(), MD5Util.toMD5(user.getPassword()),user.getPhone(),user.getAddress(),user.getEmail(), user.getId());
		
	}
	@Override
	public User getUserById(int id) {
		String sql = "select * from "+TABLE_NAME+" where id = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] {id}, new RowMapper<User>(){

			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setPhone(rs.getInt("phone"));
				user.setAddress(rs.getString("address"));
				user.setEmail(rs.getString("email"));
				return user;
			}
		});
	}
	@Override
	public void deleteUser(int id) {
		String sql = "delete from "+TABLE_NAME+" where id = ?";		
		jdbcTemplate.update(sql, id);		
	}
	@Override
	public HashMap<String, Object> register(User user) {
		HashMap<String, Object> result = new HashMap<>();
		String sql = "Select * from " + TABLE_NAME + " where email = ?";
		User check;
		try {
			check = jdbcTemplate.queryForObject(sql, new String[]{user.getEmail()}, new RowMapper<User>() {
				@Override
				public User mapRow(ResultSet resultSet, int i) {
					return new User();
				}
			});
		} catch (EmptyResultDataAccessException exception){
			check =null;
		}

		if (check != null) {
			result.put("success", false);
			result.put("message", "Email is exists");
		} else {
			sql = "INSERT INTO " + TABLE_NAME + " (username, email, password) VALUE (?, ?, ?)";
			int updateResult = jdbcTemplate.update(sql, user.getUsername(), user.getEmail(), MD5Util.toMD5(user.getPassword()));
			if (updateResult > 0){
				User newUser = this.getUserByEmail(user.getEmail());
				result.put("success", true);
				result.put("user", newUser);
			} else{
				result.put("success", false);
				result.put("message", "Please contact support team to get help");
			}
		}
		return result;
	}
	@Override
	public User getUserByEmail(String email) {
		String sql = "Select * from " + TABLE_NAME + " where email = ?";
		try {
			return jdbcTemplate.queryForObject(sql, new String[]{email}, new RowMapper<User>() {
				@Override
				public User mapRow(ResultSet resultSet, int i) {
					User user = new User();
					try {
						user.setId(resultSet.getInt("id"));
						user.setAddress(resultSet.getString("address"));
						user.setUsername(resultSet.getString("username"));
						user.setEmail(resultSet.getString("email"));
						user.setPassword(resultSet.getString("password"));
						user.setPhone(resultSet.getInt("phone"));
						return user;
					} catch (SQLException throwable) {
						return null;
					}
				}
			});
		} catch (EmptyResultDataAccessException exception){
			return null;
		}
	}
	@Override
	public HashMap<String, Object> changePassword(int id, String oldPassword, String newPassword) {
		HashMap<String, Object> result = new HashMap<>();
        boolean success = false;
        String message;
        User user = getUserById(id);
        if (user != null) {
            if (MD5Util.toMD5(oldPassword).equals(user.getPassword())) {
                String sql = "update " + TABLE_NAME + " set password = ? where id = ?";
                int updateResult = jdbcTemplate.update(sql, MD5Util.toMD5(newPassword), user.getId());
                if (updateResult > 0) {
                    success = true;
                    message = "Change password complete";
                } else {
                    message = "Change password fail";
                }
            } else {
                message = "Password not match";
            }
        } else {
            message = "User not found ";
        }
        result.put("success", success);
        result.put("message", message);
        return result;
	}
	@Override
	public HashMap<String, Object> updatePassword(int id, String newPassword) {
		 HashMap<String, Object> result = new HashMap<>();
	        boolean success = false;
	        String message;
	        try {
	            User user = getUserById(id);
	            String sql = "update " + TABLE_NAME + " set password = ? where id = ?";
	            int updateResult = jdbcTemplate.update(sql, MD5Util.toMD5(newPassword), user.getId());
	            if (updateResult > 0) {
	                success = true;
	                message = "Change password complete";
	            } else {
	                message = "Change password fail";
	            }
	        } catch (EmptyResultDataAccessException e) {
	            message = "User not found ";
	        }
	        result.put("success", success);
	        result.put("message", message);
	        return result;
	}

}

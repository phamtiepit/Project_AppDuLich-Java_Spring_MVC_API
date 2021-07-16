package com.itplus.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.itplus.dao.OrderTourDao;
import com.itplus.entity.OrderTour;


@Repository
public class OderTourDaoImpl implements OrderTourDao{
	private final String TABLE_NAME = "ordertour";
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public List<OrderTour> getAllOrderTour() {
		String sqlString = "Select * from "+TABLE_NAME;
		List<OrderTour> listOrderTour = jdbcTemplate.query(sqlString, new Object[] {},new RowMapper<OrderTour>() {

			@Override
			public OrderTour mapRow(ResultSet rs, int rowNum) throws SQLException {
				OrderTour orderTour = new OrderTour();
				orderTour.setId(rs.getInt("id"));
				orderTour.setHoten(rs.getString("hoten"));
				orderTour.setPhone(rs.getString("phone"));
				orderTour.setDiachi(rs.getString("diachi"));
				orderTour.setEmail(rs.getString("email"));
				orderTour.setTourid(rs.getInt("tourid"));
				orderTour.setStatus(rs.getInt("status"));
				return orderTour;
			}
			});
		return listOrderTour;
	}

	@Override
	public void addOrderTour(OrderTour ordertour) {
		String sql = "insert into "+TABLE_NAME+"(hoten,phone,diachi,email,tourid) values(?,?,?,?,?)";
		jdbcTemplate.update(sql, ordertour.getHoten(),ordertour.getPhone(),ordertour.getDiachi(),ordertour.getEmail(),ordertour.getTourid());
	}

	@Override
	public void updateOrderTour(OrderTour ordertour) {
		String sql = "update "+TABLE_NAME+" set hoten=?, phone=?, diachi=?, email=?, tourid=?, status=? where id = ?";
		jdbcTemplate.update(sql, ordertour.getHoten(),ordertour.getPhone(),ordertour.getDiachi(),ordertour.getEmail(),ordertour.getTourid(),ordertour.getStatus(),ordertour.getId());
	}
	@Override
	public OrderTour getOrderTourById(int id) {
		String sql = "select * from "+TABLE_NAME+" where id = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] {id},new RowMapper<OrderTour>() {
			@Override
			public OrderTour mapRow(ResultSet rs, int rowNum) throws SQLException {
				OrderTour orderTour = new OrderTour();
				orderTour.setId(rs.getInt("id"));
				orderTour.setHoten(rs.getString("hoten"));
				orderTour.setPhone(rs.getString("phone"));
				orderTour.setDiachi(rs.getString("diachi"));
				orderTour.setEmail(rs.getString("email"));
				orderTour.setTourid(rs.getInt("tourid"));
				orderTour.setStatus(rs.getInt("status"));
				return orderTour;
			}
			});
	}
	@Override
	public void deleteOrderTour(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public HashMap<String, Object> addOrder(OrderTour ordertour) {
		HashMap<String, Object> result = new HashMap<>();
		String sql = "insert into "+TABLE_NAME+"(hoten,phone,diachi,email,tourid) values(?,?,?,?,?)";
		int updateResult = jdbcTemplate.update(sql, ordertour.getHoten(),ordertour.getPhone(),ordertour.getDiachi(),ordertour.getEmail(),ordertour.getTourid());
		if (updateResult > 0){
			result.put("success", true);
		} else{
			result.put("success", false);
			result.put("message", "Please contact support team to get help");
		}
		return result;
	}

}

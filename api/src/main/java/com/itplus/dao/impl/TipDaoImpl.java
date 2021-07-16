package com.itplus.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.itplus.dao.TipDao;
import com.itplus.entity.Tip;


@Repository
public class TipDaoImpl implements TipDao{
	private final String TABLE_NAME = "tip";
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<Tip> getAllTip() {
		String sqlString = "Select * from "+TABLE_NAME;
		List<Tip> listTip = jdbcTemplate.query(sqlString, new Object[] {},new RowMapper<Tip>() {
			@Override
			public Tip mapRow(ResultSet rs, int rowNum) throws SQLException {
				Tip tip = new Tip();
				tip.setId(rs.getInt("id"));
				tip.setTitle(rs.getString("title"));
				tip.setContent(rs.getString("content"));
				return tip;
			}
			});
		return listTip;
	}

	@Override
	public void addTip(Tip tip) {
		String sql = "insert into "+TABLE_NAME+"(title,content) values(?,?)";
		jdbcTemplate.update(sql,tip.getTitle(),tip.getContent());	
	}
	@Override
	public void updateTip(Tip tip) {
		String sql = "update "+TABLE_NAME+" set title=?, content =? where id = ?";
		jdbcTemplate.update(sql, tip.getTitle(),tip.getContent(),tip.getId());
	}

	@Override
	public void deleteTip(int id) {
		String sql = "delete from "+TABLE_NAME+" where id = ?";		
		jdbcTemplate.update(sql, id);				
	}

	@Override
	public Tip getTipById(int id) {
		String sql = "select * from "+TABLE_NAME+" where id = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] {id}, new RowMapper<Tip>(){
			@Override
			public Tip mapRow(ResultSet rs, int rowNum) throws SQLException {
				Tip tip = new Tip();
				tip.setId(rs.getInt("id"));
				tip.setTitle(rs.getString("title"));
				tip.setContent(rs.getString("content"));
				return tip;
			}
		});
	}
	
}

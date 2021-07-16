package com.itplus.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.itplus.dao.PromotionDao;
import com.itplus.entity.Promotion;

@Repository
public class PromotionDaoImpl implements PromotionDao{
	
	private final String TABLE_NAME = "promotion";
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Override
	public List<Promotion> getAllPromotion() {
		String sqlString = "Select * from "+TABLE_NAME;
		List<Promotion> listPromotion= jdbcTemplate.query(sqlString, new Object[] {},new RowMapper<Promotion>() {
			@Override
			public Promotion mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Promotion promotion = new Promotion();
				promotion.setId(rs.getInt("id"));
				promotion.setCategoryid(rs.getInt("categoryid"));
				promotion.setPromotioncode(rs.getString("promotioncode"));
				promotion.setName(rs.getString("name"));
				promotion.setDiemdi(rs.getString("diemdi"));
				promotion.setDiemden(rs.getString("diemden"));
				promotion.setTimedi(rs.getString("timedi"));
				promotion.setTimeve(rs.getString("timeve"));
				promotion.setDescriptions(rs.getString("descriptions"));
				promotion.setImages(rs.getString("images"));
				promotion.setPrice(rs.getFloat("price"));
				return promotion;
			}
			});
		return listPromotion;
	}
	@Override
	public void addPromotion(Promotion promotion) {
		String sql = "insert into "+TABLE_NAME+"(categoryid,promotioncode,name,diemdi,diemden,timedi,timeve,descriptions,images,price) values(?,?,?,?,?,?,?,?,?,?)";
		jdbcTemplate.update(sql,promotion.getCategoryid(),promotion.getPromotioncode(),promotion.getName(),promotion.getDiemdi(),promotion.getDiemden(),promotion.getTimedi(),promotion.getTimeve(),promotion.getDescriptions(),promotion.getImages(),promotion.getPrice());				
	}
	@Override
	public void updatePromotion(Promotion promotion) {
		String sql = "update "+TABLE_NAME+" set categoryid = ?, promotioncode=?, name=?, diemdi=?, diemden=?, timedi=?, timeve=?, descriptions=?, images=?, price=? where id = ?";
		jdbcTemplate.update(sql,promotion.getCategoryid(),promotion.getPromotioncode(),promotion.getName(),promotion.getDiemdi(),promotion.getDiemden(),promotion.getTimedi(),promotion.getTimeve(),promotion.getDescriptions(),promotion.getImages(),promotion.getPrice(),promotion.getId());
		
	}
	@Override
	public Promotion getPromotionById(int id) {
		String sql = "select * from "+TABLE_NAME+" where id = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] {id}, new RowMapper<Promotion>(){
			@Override
			public Promotion mapRow(ResultSet rs, int rowNum) throws SQLException {
				Promotion promotion = new Promotion();
				promotion.setId(rs.getInt("id"));
				promotion.setCategoryid(rs.getInt("categoryid"));
				promotion.setPromotioncode(rs.getString("promotioncode"));
				promotion.setName(rs.getString("name"));
				promotion.setDiemdi(rs.getString("diemdi"));
				promotion.setDiemden(rs.getString("diemden"));
				promotion.setTimedi(rs.getString("timedi"));
				promotion.setTimeve(rs.getString("timeve"));
				promotion.setDescriptions(rs.getString("descriptions"));
				promotion.setImages(rs.getString("images"));
				promotion.setPrice(rs.getFloat("price"));
				return promotion;
			}
		});
	}
	@Override
	public void deletePromotion(int id) {
		String sql = "delete from "+TABLE_NAME+" where id = ?";		
		jdbcTemplate.update(sql, id);
		
	}
	
}

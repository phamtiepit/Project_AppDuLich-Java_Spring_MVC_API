package com.itplus.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.itplus.dao.TourDao;
import com.itplus.entity.Tour;

@Repository
public class TourDaoImpl implements TourDao{
	private final String TABLE_NAME = "tour";
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Override
	public List<Tour> getAllTour() {
		String sql = "Select * from "+TABLE_NAME;
		List<Tour> listTour = jdbcTemplate.query(sql, new Object[] {}, new RowMapper<Tour>(){

			@Override
			public Tour mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Tour tour = new Tour();
				tour.setId(rs.getInt("id"));
				tour.setCategoryid(rs.getInt("categoryid"));
				tour.setPromotionid(rs.getInt("promotionid"));
				tour.setName(rs.getString("name"));
				tour.setDiemdi(rs.getString("diemdi"));
				tour.setDiemden(rs.getString("diemden"));
				tour.setTimedi(rs.getString("timedi"));
				tour.setTimeve(rs.getString("timeve"));
				tour.setDescriptions(rs.getString("descriptions"));
				tour.setImages(rs.getString("images"));
				tour.setPrice(rs.getFloat("price"));
				return tour;
			}
			});
		return listTour;
	}
	@Override
	public void addTour(Tour tour) {
		String sql = "insert into "+TABLE_NAME+"(categoryid,promotionid,name,diemdi,diemden,timedi,timeve,descriptions,images,price) values(?,?,?,?,?,?,?,?,?,?)";
		jdbcTemplate.update(sql,tour.getCategoryid(),tour.getPromotionid(),tour.getName(),tour.getDiemdi(),tour.getDiemden(),tour.getTimedi(),tour.getTimeve(),tour.getDescriptions(),tour.getImages(),tour.getPrice());	
		
	}
	@Override
	public void updateTour(Tour tour) {
		String sql = "update "+TABLE_NAME+" set categoryid = ?, promotionid = ?, name=?, diemdi=?, diemden=?, timedi=?, timeve=?, descriptions=?, images=?, price=? where id = ?";
		jdbcTemplate.update(sql, tour.getCategoryid(),tour.getPromotionid(),tour.getName(),tour.getDiemdi(),tour.getDiemden(),tour.getTimedi(),tour.getTimeve(),tour.getDescriptions(),tour.getImages(),tour.getPrice(),tour.getId());
		
	}
	@Override
	public Tour getTourById(int id) {
		String sql = "select * from "+TABLE_NAME+" where id = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] {id}, new RowMapper<Tour>(){
			@Override
			public Tour mapRow(ResultSet rs, int rowNum) throws SQLException {
				Tour tour = new Tour();
				tour.setId(rs.getInt("id"));
				tour.setCategoryid(rs.getInt("categoryid"));
				tour.setPromotionid(rs.getInt("promotionid"));
				tour.setName(rs.getString("name"));
				tour.setDiemdi(rs.getString("diemdi"));
				tour.setDiemden(rs.getString("diemden"));
				tour.setTimedi(rs.getString("timedi"));
				tour.setTimeve(rs.getString("timeve"));
				tour.setDescriptions(rs.getString("descriptions"));
				tour.setImages(rs.getString("images"));
				tour.setPrice(rs.getFloat("price"));
				return tour;
			}
		});
	}
	@Override
	public void deleteTour(int id) {
		String sql = "delete from "+TABLE_NAME+" where id = ?";		
		jdbcTemplate.update(sql, id);
		
	}
	@Override
	public List<Tour> getAllTourByCategory(int cateid) {
		String sql = "Select * from "+TABLE_NAME+" where categoryid=?";
		List<Tour> listTour = jdbcTemplate.query(sql, new Object[] {cateid}, new RowMapper<Tour>(){
			@Override
			public Tour mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Tour tour = new Tour();
				tour.setId(rs.getInt("id"));
				tour.setCategoryid(rs.getInt("categoryid"));
				tour.setPromotionid(rs.getInt("promotionid"));
				tour.setName(rs.getString("name"));
				tour.setDiemdi(rs.getString("diemdi"));
				tour.setDiemden(rs.getString("diemden"));
				tour.setTimedi(rs.getString("timedi"));
				tour.setTimeve(rs.getString("timeve"));
				tour.setDescriptions(rs.getString("descriptions"));
				tour.setImages(rs.getString("images"));
				tour.setPrice(rs.getFloat("price"));
				return tour;
			}
			});
		return listTour;
	}

}

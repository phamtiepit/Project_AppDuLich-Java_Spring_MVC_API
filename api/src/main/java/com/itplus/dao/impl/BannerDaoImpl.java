package com.itplus.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.itplus.dao.BannerDao;
import com.itplus.entity.Banner;

@Repository
public class BannerDaoImpl implements BannerDao{
	
	private final String TABLE_NAME = "banner";
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Override
	public List<Banner> getAllBanner() {
		// TODO Auto-generated method stub
		String sqlString = "Select * from "+TABLE_NAME;
		List<Banner> listBanner = jdbcTemplate.query(sqlString, new Object[] {},new RowMapper<Banner>() {

			@Override
			public Banner mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Banner banner = new Banner();
				banner.setId(rs.getInt("id"));
				banner.setName(rs.getString("name"));
				banner.setDescriptions(rs.getString("descriptions"));
				banner.setUrl(rs.getString("url"));
				banner.setImages(rs.getString("images"));
				return banner;
			}
			});
		return listBanner;
	}
	@Override
	public void addBanner(Banner banner) {
		String sql = "insert into "+TABLE_NAME+"(name,descriptions,url,images) values(?,?,?,?)";
		jdbcTemplate.update(sql, banner.getName(),banner.getDescriptions(),banner.getUrl(),banner.getImages());
		
	}
	@Override
	public void updateBanner(Banner banner) {
		String sql = "update "+TABLE_NAME+" set name= ?, descriptions = ?, url = ?, images=? where id = ?";
		jdbcTemplate.update(sql, banner.getName(),banner.getDescriptions(),banner.getUrl(),banner.getImages(),banner.getId());
		
	}
	@Override
	public Banner getBannerById(int id) {
		String sql = "select * from "+TABLE_NAME+" where id = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] {id}, new RowMapper<Banner>(){
			@Override
			public Banner mapRow(ResultSet rs, int rowNum) throws SQLException {
				Banner banner = new Banner();
				banner.setId(rs.getInt("id"));
				banner.setName(rs.getString("name"));
				banner.setDescriptions(rs.getString("descriptions"));
				banner.setUrl(rs.getString("url"));
				banner.setImages(rs.getString("images"));
				return banner;
			}
		});
	}
	@Override
	public void deleteBanner(int id) {
		String sql = "delete from "+TABLE_NAME+" where id = ?";		
		jdbcTemplate.update(sql, id);		
	}
	
}

package com.itplus.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.itplus.dao.CategoryDao;
import com.itplus.entity.Category;

@Repository
public class CategoryDaoImpl implements CategoryDao{
	
	private final String TABLE_NAME = "category";
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Override
	public List<Category> getAllCategory() {
		// TODO Auto-generated method stub
		String sqlString = "Select * from "+TABLE_NAME;
		List<Category> listCategory= jdbcTemplate.query(sqlString, new Object[] {},new RowMapper<Category>() {

			@Override
			public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Category category = new Category();
				category.setId(rs.getInt("id"));
				category.setCategoryname(rs.getString("categoryname"));
				category.setDescriptions(rs.getString("descriptions"));
				category.setImages(rs.getString("images"));
				return category;
			}
			});
		return listCategory;
	}
	@Override
	public void addCategory(Category category) {
		String sql = "insert into "+TABLE_NAME+"(categoryName,descriptions,images) values(?,?,?)";
		jdbcTemplate.update(sql,category.getCategoryname(),category.getDescriptions(),category.getImages());
		
	}
	@Override
	public void updateCategory(Category category) {
		String sql = "update "+TABLE_NAME+" set categoryName= ?, descriptions = ?, images=? where id = ?";
		jdbcTemplate.update(sql, category.getCategoryname(),category.getDescriptions(),category.getImages(),category.getId());
		
	}
	@Override
	public Category getCategoryById(int id) {
		String sql = "select * from "+TABLE_NAME+" where id = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] {id}, new RowMapper<Category>(){
			@Override
			public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
				Category category = new Category();
				category.setId(rs.getInt("id"));
				category.setCategoryname(rs.getString("categoryname"));
				category.setDescriptions(rs.getString("descriptions"));
				category.setImages(rs.getString("images"));
				return category;
			}
		});
	}
	@Override
	public void deleteCategory(int id) {
		String sql = "delete from "+TABLE_NAME+" where id = ?";		
		jdbcTemplate.update(sql, id);
		
	}

}

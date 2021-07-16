package com.itplus.dao;

import java.util.List;

import com.itplus.entity.Category;

public interface CategoryDao {
	List<Category> getAllCategory();
	void addCategory(Category category);
	void updateCategory(Category category);
	Category getCategoryById(int id);
	void deleteCategory(int id);
}

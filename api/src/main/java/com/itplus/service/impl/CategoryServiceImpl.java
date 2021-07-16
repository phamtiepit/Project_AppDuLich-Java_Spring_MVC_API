package com.itplus.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itplus.dao.CategoryDao;
import com.itplus.entity.Category;
import com.itplus.model.CategoryDTO;
import com.itplus.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
	@Autowired
	CategoryDao categoryDao;
	@Override
	public List<CategoryDTO> getAllCategory() {
		// TODO Auto-generated method stub
		List<CategoryDTO> listCategoryDTO = new ArrayList<CategoryDTO>();
		List<Category> listCategory = categoryDao.getAllCategory();
		for (Category category : listCategory) {
			CategoryDTO categoryDTO = new CategoryDTO();
			categoryDTO.setId(category.getId());
			categoryDTO.setCategoryname(category.getCategoryname());
			categoryDTO.setDescriptions(category.getDescriptions());
			categoryDTO.setImages(category.getImages());
			listCategoryDTO.add(categoryDTO);
		}		
		return listCategoryDTO;
	}
	@Override
	public void addCategory(CategoryDTO categoryDTO) {
		Category category = new Category();
		category.setCategoryname(categoryDTO.getCategoryname());
		category.setDescriptions(categoryDTO.getDescriptions());
		category.setImages(categoryDTO.getImages());
		categoryDao.addCategory(category);
		
	}
	@Override
	public void updateCategory(CategoryDTO categoryDTO) {
		Category category = new Category();
		category.setId(categoryDTO.getId());
		category.setCategoryname(categoryDTO.getCategoryname());
		category.setDescriptions(categoryDTO.getDescriptions());
		category.setImages(categoryDTO.getImages());
		categoryDao.updateCategory(category);
		
	}
	@Override
	public CategoryDTO getCategoryById(int id) {
		Category category = categoryDao.getCategoryById(id);
		CategoryDTO categoryDTO = new CategoryDTO();
		categoryDTO.setId(category.getId());
		categoryDTO.setCategoryname(category.getCategoryname());
		categoryDTO.setDescriptions(category.getDescriptions());
		categoryDTO.setImages(category.getImages());
		return categoryDTO;
	}
	@Override
	public void deleteCategory(int id) {
		categoryDao.deleteCategory(id);
		
	}

}

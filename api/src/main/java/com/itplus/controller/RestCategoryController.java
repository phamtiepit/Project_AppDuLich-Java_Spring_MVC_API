package com.itplus.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.itplus.service.CategoryService;

import com.itplus.model.CategoryDTO;

@RestController
@RequestMapping(value = "/category",produces = "application/json")
public class RestCategoryController {
	@Autowired
	CategoryService categoryService;
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listCategory(HttpServletRequest request) {
		List<CategoryDTO> cate = categoryService.getAllCategory();
		Gson gson = new Gson();
		return gson.toJson(cate);
	}

}

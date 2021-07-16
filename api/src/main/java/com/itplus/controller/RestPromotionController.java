package com.itplus.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.itplus.model.PromotionDTO;
import com.itplus.service.PromotionService;

@RestController
@RequestMapping(value = "/promotion",produces = "application/json")
public class RestPromotionController {
	@Autowired
	PromotionService promotionService;
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listUudai(HttpServletRequest request) {
		List<PromotionDTO> uudaiDTO = promotionService.getAllPromotion();
		Gson gson = new Gson();
		return gson.toJson(uudaiDTO);
	}
}

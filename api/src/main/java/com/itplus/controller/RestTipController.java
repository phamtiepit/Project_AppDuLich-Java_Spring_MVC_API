package com.itplus.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.itplus.model.TipDTO;
import com.itplus.service.TipService;

@RestController
@RequestMapping(value = "/tip",produces = "application/json")
public class RestTipController {
	@Autowired
	TipService tipService;
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listUser(HttpServletRequest request) {
		List<TipDTO> tipDTO = tipService.getAllTip();
		Gson gson = new Gson();
		return gson.toJson(tipDTO);
	}
}

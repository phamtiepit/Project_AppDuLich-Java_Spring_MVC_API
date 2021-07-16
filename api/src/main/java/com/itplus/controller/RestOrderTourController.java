package com.itplus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itplus.model.OrderTourDTO;
import com.itplus.service.OrderTourService;

@RestController
@RequestMapping(value = "/ordertour",produces = "application/json")
public class RestOrderTourController {
	@Autowired
	ObjectMapper objectMapper;
	@Autowired
	OrderTourService orderTourService;
	@PostMapping(value = "/")
	@ResponseStatus(HttpStatus.OK)
	public String register(@RequestBody OrderTourDTO orderTourDTO) throws JsonProcessingException {
		return objectMapper.writeValueAsString(orderTourService.addOrder(orderTourDTO));
	}
}

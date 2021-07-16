package com.itplus.admincontroller;


import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;

@Controller
@RequestMapping(value = "/admin/dashboard")
public class DashboardController {
	@RequestMapping(value = "/",method = RequestMethod.GET)
	public String Dashboard(Mode map,HttpSession session) {
		if(session.getAttribute("admin")!=null) {
			return "dashboard";
		}
		return "redirect:/admin/";
		
	}
}
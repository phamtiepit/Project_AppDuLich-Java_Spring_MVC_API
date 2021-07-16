package com.itplus.admincontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.itplus.model.AdminDTO;
import com.itplus.service.AdminService;

@Controller
@RequestMapping(value = "/admin")
public class LoginController {
	String error ="";
	@Autowired
	AdminService adminService;
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String login(HttpServletRequest request,HttpSession session) {
		if(session.getAttribute("admin") == null) {
			request.setAttribute("adminDTO", new AdminDTO());
			request.setAttribute("errorLogin", error);
			error="";
			return "login";
		}
		return "redirect:/admin/dashboard/";
	}
	
	@RequestMapping(value = "/process-login", method = RequestMethod.POST)
	public String doLogin(HttpServletRequest request,HttpSession session,@ModelAttribute("adminDTO") @Valid AdminDTO adminDTO, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "login";
		}
		try {
			AdminDTO adminDTO2 = adminService.login(adminDTO);
			if(adminDTO2 != null) {
				session.setAttribute("admin", adminDTO2);
				//System.out.print(adminDTO2.toString());
				return "redirect:/admin/dashboard/";
			}
		} catch (Exception e) {
			System.out.print("Sai tài khoản hoặc mật khẩu!");
			error = "Sai tài khoản hoặc mật khẩu!";
			return "redirect:/admin/";
		}
		return "redirect:/admin/";
	}
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request,HttpSession session) {
		session.setAttribute("admin", null);
		return "redirect:/admin/";
	}
}

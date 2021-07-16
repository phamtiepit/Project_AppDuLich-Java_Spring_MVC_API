package com.itplus.admincontroller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itplus.model.UserDTO;
import com.itplus.service.UserService;

@Controller
@RequestMapping(value = "/admin/user")
public class UserController {
	@Autowired
	UserService userService;
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getUserList(HttpServletRequest request,HttpSession session) {
		if(session.getAttribute("admin")!=null) {
			List<UserDTO> list = userService.getAllUser();
			request.setAttribute("listUser", list);
			return "user/listUser";
		}
		return "redirect:/admin/";		
	}
//	@RequestMapping(value = "/add", method = RequestMethod.GET)
//	public String addUser(HttpServletRequest request) {
//		request.setAttribute("user", new UserDTO());
//		return "add";
//	}
//	@RequestMapping(value = "/process-add", method = RequestMethod.POST)
//	public String addUser(HttpServletRequest request, @ModelAttribute("userDTO") @Valid UserDTO user, BindingResult bindingResult) {
//		if (bindingResult.hasErrors()) {
//			return "add";
//		}
//		userService.addUser(user);
//		return "redirect:/list-user";
//	}
	@RequestMapping(value="/edit/{id}", method = RequestMethod.GET)
	public String getIdedit(HttpServletRequest request,@PathVariable(name = "id") int id,HttpSession session) {
		if(session.getAttribute("admin")!=null) {
			UserDTO user = userService.getUserById(id);
			request.setAttribute("userDTO", user);
			return "user/editUser";
		}
		return "redirect:/admin/";		
	}
	@RequestMapping(value = "/process-edit", method = RequestMethod.POST)
	public String editUser(HttpServletRequest request, @ModelAttribute("userDTO") @Valid UserDTO userDTO, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "edit";
		}
		userService.updateUser(userDTO);
		return "redirect:/admin/user/";
	}
	@RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
	public String getIddelete(HttpServletRequest request,@PathVariable(name = "id") int id,HttpSession session) {
		if(session.getAttribute("admin")!=null) {
			userService.deleteUser(id);
			return "redirect:/admin/user/";
		}
		return "redirect:/admin/";	
	}
}

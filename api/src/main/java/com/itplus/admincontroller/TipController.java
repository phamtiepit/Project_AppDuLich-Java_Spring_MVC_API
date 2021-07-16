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

import com.itplus.model.TipDTO;
import com.itplus.service.TipService;

@Controller
@RequestMapping(value = "/admin/tip")
public class TipController {
	@Autowired
	TipService tipService;
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getTipList(HttpServletRequest request,HttpSession session) {
		if(session.getAttribute("admin")!=null) {
			List<TipDTO> list = tipService.getAllTip();
			request.setAttribute("listTip", list);
			return "tip/listTip";
		}
		return "redirect:/admin/";		
	}
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addTip(HttpServletRequest request,HttpSession session) {
		if(session.getAttribute("admin")!=null) {
			request.setAttribute("tipDTO", new TipDTO());
			return "tip/addTip";
		}
		return "redirect:/admin/";		
	}
	@RequestMapping(value = "/process-add", method = RequestMethod.POST)
	public String addUser(HttpServletRequest request, @ModelAttribute("tipDTO") @Valid TipDTO tipDTO, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "add";
		}
		tipService.addTip(tipDTO);
		return "redirect:/admin/tip/add";
	}
	@RequestMapping(value="/edit/{id}", method = RequestMethod.GET)
	public String getIdedit(HttpServletRequest request,@PathVariable(name = "id") int id,HttpSession session) {
		if(session.getAttribute("admin")!=null) {
			TipDTO tipDTO = tipService.getTipById(id);
			request.setAttribute("tipDTO", tipDTO);
			return "tip/editTip";
		}
		return "redirect:/admin/";	
	}
	@RequestMapping(value = "/process-edit", method = RequestMethod.POST)
	public String editUser(HttpServletRequest request, @ModelAttribute("tipDTO") @Valid TipDTO tipDTO, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "edit";
		}
		tipService.updateTip(tipDTO);
		return "redirect:/admin/tip/";
	}
	@RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
	public String getIddelete(HttpServletRequest request,@PathVariable(name = "id") int id,HttpSession session) {
		if(session.getAttribute("admin")!=null) {
			tipService.deleteTip(id);
			return "redirect:/admin/tip/";
		}
		return "redirect:/admin/";		
	}
}

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

import com.itplus.model.OrderTourDTO;
import com.itplus.model.TourDTO;
import com.itplus.service.OrderTourService;
import com.itplus.service.TourService;

@Controller
@RequestMapping(value = "/admin/ordertour")
public class OrderTourController {
	@Autowired
	OrderTourService orderTourService;
	@Autowired
	TourService tourService;
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getOrderList(HttpServletRequest request,HttpSession session) {
		if(session.getAttribute("admin")!=null) {
			List<OrderTourDTO> list = orderTourService.getAllOrderTour();
			request.setAttribute("listOrderTour", list);
			return "ordertour/ListOrderTour";
		}
		return "redirect:/admin/";
	}
	@RequestMapping(value="/edit/{id}", method = RequestMethod.GET)
	public String getIdedit(HttpServletRequest request,@PathVariable(name = "id") int id,HttpSession session) {
		if(session.getAttribute("admin")!=null) {
			OrderTourDTO ordertourDTO = orderTourService.getOrderTourById(id);
			TourDTO tourDTO = tourService.getTourById(ordertourDTO.getTourid());
			request.setAttribute("tourDTO", tourDTO);
			request.setAttribute("ordertourDTO", ordertourDTO);
			
			return "ordertour/editOrderTour";
		}
		return "redirect:/admin/";
		
	}
	@RequestMapping(value = "/process-edit", method = RequestMethod.POST)
	public String editUser(HttpServletRequest request, @ModelAttribute("ordertourDTO") @Valid OrderTourDTO ordertourDTO, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "edit";
		}
		orderTourService.updateOrderTour(ordertourDTO);
		return "redirect:/admin/ordertour/";
	}
}

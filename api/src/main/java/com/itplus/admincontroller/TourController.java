package com.itplus.admincontroller;

import java.io.File;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.itplus.model.TourDTO;
import com.itplus.model.CategoryDTO;
import com.itplus.model.PromotionDTO;
import com.itplus.service.TourService;
import com.itplus.service.CategoryService;
import com.itplus.service.PromotionService;

@Controller
@RequestMapping(value = "/admin/tour")
public class TourController {
	
	@Autowired
	TourService tourService;
	@Autowired
	CategoryService categoryService;
	@Autowired
	PromotionService promotionService;
	
	@RequestMapping(value = "/")
	public String getAllTour(HttpServletRequest request,HttpSession session) {
		if(session.getAttribute("admin")!=null) {
			List<TourDTO> listTourDTO = tourService.getAllTour();
			request.setAttribute("listTour", listTourDTO);
			return "tour/listTour";
		}
		return "redirect:/admin/";		
	}
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public  String addTour(HttpServletRequest request,HttpSession session) {
		if(session.getAttribute("admin")!=null) {
			List<CategoryDTO> listCategoryDTO = categoryService.getAllCategory();
			List<PromotionDTO> lisPromotionDTO = promotionService.getAllPromotion();
			request.setAttribute("listCate", listCategoryDTO);
			request.setAttribute("listPro", lisPromotionDTO);
			request.setAttribute("tourDTO", new TourDTO());
			return "tour/addTour";
		}
		return "redirect:/admin/";	
	}

	@RequestMapping(value = "/process-add", method = RequestMethod.POST)
	public  String doAddTour(HttpServletRequest request,@ModelAttribute("tourDTO") @Valid TourDTO tourDTO,BindingResult bindingResult,@RequestParam("img") MultipartFile imgFile ) {
		if (bindingResult.hasErrors()) {
			return "add";
		}
		String imgFileName = imgFile.getOriginalFilename();
		if(!"".equals(imgFileName)){
			String path = request.getServletContext().getRealPath("/") + "images/";
			System.out.println(path);
			File fileDir = new File(path);
			if(!fileDir.exists()){
				fileDir.mkdir();
			}
			try {
				imgFile.transferTo(new File(fileDir+File.separator+imgFileName));
				System.out.println("Upload file thành công!");
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println("Upload file thất bại!");
			}
			tourDTO.setImages(imgFileName);
		}
		tourService.addTour(tourDTO);
		return "redirect:/admin/tour/add";
	}
	@RequestMapping(value="/edit/{id}", method = RequestMethod.GET)
	public String getIdedit(HttpServletRequest request,@PathVariable(name = "id") int id,HttpSession session) {
		if(session.getAttribute("admin")!=null) {
			TourDTO tourDTO = tourService.getTourById(id);
			List<CategoryDTO> listCategoryDTO = categoryService.getAllCategory();
			List<PromotionDTO> lisPromotionDTO = promotionService.getAllPromotion();
			CategoryDTO categotyDTO = categoryService.getCategoryById(tourDTO.getCategoryid());
			PromotionDTO promotionDTO = promotionService.getPromotionById(tourDTO.getPromotionid());
			request.setAttribute("tourDTO", tourDTO);
			request.setAttribute("listCate", listCategoryDTO);
			request.setAttribute("listPro", lisPromotionDTO);
			request.setAttribute("cate", categotyDTO);
			request.setAttribute("pro", promotionDTO);
			return "tour/editTour";
		}
		return "redirect:/admin/";
		
	}
	@RequestMapping(value = "/process-edit", method = RequestMethod.POST)
	public String editTour(HttpServletRequest request, @ModelAttribute("tourDTO") @Valid TourDTO tourDTO, BindingResult bindingResult,@RequestParam("img") MultipartFile imgFile) {
		if (bindingResult.hasErrors()) {
			return "edit";
		}
		String imgFileName = imgFile.getOriginalFilename();
		if(!"".equals(imgFileName)){
			String path = request.getServletContext().getRealPath("/") + "images/";
			System.out.println(path);
			File fileDir = new File(path);
			if(!fileDir.exists()){
				fileDir.mkdir();
			}
			try {
				imgFile.transferTo(new File(fileDir+File.separator+imgFileName));
				File filedel = new File(path+tourDTO.getImages());
				filedel.delete();
				System.out.println("Upload file thành công!");
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println("Upload file thất bại!");
			}
			tourDTO.setImages(imgFileName);
		}
		tourService.updateTour(tourDTO);
		return "redirect:/admin/tour/";
	}
	@RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
	public String getIddelete(HttpServletRequest request,@PathVariable(name = "id") int id,HttpSession session) {
		if(session.getAttribute("admin")!=null) {
			TourDTO tourDTO = tourService.getTourById(id);
			String path = request.getServletContext().getRealPath("/") + "images/";
			if(!"".equals(tourDTO.getImages())){
				try {
					File filedel = new File(path+tourDTO.getImages());
					filedel.delete();
					System.out.println("Xóa file thành công!");
				}catch(Exception e){
					System.out.println(e.getMessage());
					System.out.println("Xóa file thất bại!");
				}
			}
			tourService.deleteTour(id);
			return "redirect:/admin/tour/";
		}
		return "redirect:/admin/";		
	}
}

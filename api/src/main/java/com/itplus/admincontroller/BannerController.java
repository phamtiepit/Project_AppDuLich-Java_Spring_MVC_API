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

import com.itplus.model.BannerDTO;
import com.itplus.service.BannerService;

@Controller
@RequestMapping(value = "/admin/banner")
public class BannerController {
	@Autowired
	BannerService bannerService;
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getBannerList(HttpServletRequest request,HttpSession session) {
		if(session.getAttribute("admin")!=null) {
			List<BannerDTO> list = bannerService.getAllBanner();
			request.setAttribute("listBanner", list);
			return "banner/listBanner";
		}
		return "redirect:/admin/";
	}
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addBanner(HttpServletRequest request,HttpSession session) {
		if(session.getAttribute("admin")!=null) {
			request.setAttribute("bannerDTO", new BannerDTO());
			return "banner/addBanner";
		}
		return "redirect:/admin/";	
	}
	@RequestMapping(value = "/process-add", method = RequestMethod.POST)
	public String addBanner(HttpServletRequest request, @ModelAttribute("bannerDTO") @Valid BannerDTO bannerDTO, BindingResult bindingResult,@RequestParam("img") MultipartFile imgFile) {
		if (bindingResult.hasErrors()) {
			return "add";
		}
		String imgFileName = imgFile.getOriginalFilename();
		if(!"".equals(imgFileName)){
			String path = request.getServletContext().getRealPath("/") + "images/";
			System.out.println(path);
			request.setAttribute("test", path);
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
			bannerDTO.setImages(imgFileName);
		}
		bannerService.addBanner(bannerDTO);
		return "redirect:/admin/banner/add";
	}	
	@RequestMapping(value="/edit/{id}", method = RequestMethod.GET)
	public String getIdedit(HttpServletRequest request,@PathVariable(name = "id") int id,HttpSession session) {
		if(session.getAttribute("admin")!=null) {
			BannerDTO bannerDTO = bannerService.getBannerById(id);
			request.setAttribute("bannerDTO", bannerDTO);
			return "banner/editBanner";
		}
		return "redirect:/admin/";		
	}
	@RequestMapping(value = "/process-edit", method = RequestMethod.POST)
	public String editBanner(HttpServletRequest request, @ModelAttribute("bannerDTO") @Valid BannerDTO bannerDTO, BindingResult bindingResult,@RequestParam("img") MultipartFile imgFile,HttpSession session) {
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
				File filedel = new File(path+bannerDTO.getImages());
				filedel.delete();
				System.out.println("Upload file thành công!");
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println("Upload file thất bại!");
			}			
			bannerDTO.setImages(imgFileName);
		}
		bannerService.updateBanner(bannerDTO);
		return "redirect:/admin/banner/";
	}
	@RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
	public String getIddelete(HttpServletRequest request,@PathVariable(name = "id") int id,HttpSession session) {
		if(session.getAttribute("admin")!=null) {
			BannerDTO bannerDTO = bannerService.getBannerById(id);
			String path = request.getServletContext().getRealPath("/") + "images/";
			if(!"".equals(bannerDTO.getImages())){
				try {
					File filedel = new File(path+bannerDTO.getImages());
					filedel.delete();
					System.out.println("Xóa file thành công!");
				}catch(Exception e){
					System.out.println(e.getMessage());
					System.out.println("Xóa file thất bại!");
				}
			}
			bannerService.deleteBanner(id);
			return "redirect:/admin/banner/";
		}
		return "redirect:/admin/";		
	}
}

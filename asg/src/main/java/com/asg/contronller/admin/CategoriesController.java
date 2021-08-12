package com.asg.contronller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.asg.dto.CategoriesDTO;
import com.asg.dto.UserDTO;
import com.asg.entity.Categories;
import com.asg.entity.User;
import com.asg.mapper.CateMapper;
import com.asg.mapper.UserMapper;
import com.asg.repositories.CateRepository;

@Controller
@RequestMapping("/admin")
public class CategoriesController {
	@Autowired CateRepository cateRepo;
	
	@Autowired
	HttpServletRequest request;

	@Autowired
	private CateMapper mapper;
	
	@GetMapping("/cate")
	public String index(Model model , @ModelAttribute("cateDTO")CategoriesDTO cateDTO) {
		model.addAttribute("TitlePage", "Categories Page");
		model.addAttribute("views", "/views/admin/Categories.jsp");
		
		List<Categories> page= cateRepo.findAll();
		model.addAttribute("page",page);
		return"admin/index";
	}
	
	@GetMapping(value = "/cate/edit/{id}")
	public String edit(@PathVariable("id") Categories cate, Model model) {
		// moddelMapper
//		Link thư viện: https://mvnrepository.com/artifact/org.modelmapper/modelmapper/2.4.4
		
		model.addAttribute("TitlePage", "Categories Page");
		model.addAttribute("views", "/views/admin/Categories.jsp");
		
		CategoriesDTO cateDTO = mapper.convertToDTO(cate);
		model.addAttribute("cateDTO",cateDTO);
//		System.out.print(""+cateDTO.toString());
		
//		Pageable pageable = PageRequest.of(0, 5);
//		Page<User> page= userRepo.findAll(pageable);
		
		List<Categories> page= cateRepo.findAll();
		model.addAttribute("page",page);
		return "admin/index";
	}
	
	@ModelAttribute("categories")
	public List<Categories> getCategories(){
		List<Categories> list = cateRepo.findAll();	
		
		return list;
	}
	

	@PostMapping(value = "/cate/update")
	public String save(
			Model model,
			@Valid  CategoriesDTO cateDTO,
			BindingResult result) {

//		if(result.hasErrors()) {
//			List<ObjectError> errors = result.getAllErrors();
//			
//			System.out.println("message err: " + errors.get(0).getDefaultMessage());
//			
//			model.addAttribute("errors", errors);
//
//			return "redirect:/admin/category";
//		}else {
			Categories cate=mapper.convertToEntity(cateDTO);
			System.out.print("id là: "+cate.getId());
			System.out.print(cate.toString());
			if(cate.getId() != null) {
				cateRepo.save(cate);
				return "redirect:/admin/cate/edit/"+ cate.getId() ;
			}else {
				cateRepo.save(cate);
				return "redirect:/admin/cate";
			}
						
//		}

	}
	
	@GetMapping(value = "/cate/delete/{id}")
	public String delete(@PathVariable("id") Categories cate) {
		System.out.print(cate.toString());
		this.cateRepo.delete(cate);
		return "redirect:/admin/cate";
	}
	
	@PostMapping(value = "/cate/clear")
	public String clear(Model model) {
		Categories cate= new Categories();
		model.addAttribute(cate);
		return "redirect:/admin/cate";
	}
}

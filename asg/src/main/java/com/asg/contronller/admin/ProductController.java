package com.asg.contronller.admin;

import java.util.Date;
import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.asg.dto.ProductDTO;
import com.asg.entity.Categories;
import com.asg.entity.Product;
import com.asg.mapper.ProductMapper;
import com.asg.repositories.CateRepository;
import com.asg.repositories.ProductRepository;

@Controller
@RequestMapping("/admin")
public class ProductController {
	@Autowired
	private ProductRepository prodRepo;
	
	@Autowired
	private CateRepository cateRepo;
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	private ProductMapper mapper;
	
	@ModelAttribute("categories")
	public List<Categories> getCategories(){
		List<Categories> list = cateRepo.findAll();
		
		return list;
	}
	
	@GetMapping("/product")
	public String index(Model model, @ModelAttribute("prod") ProductDTO prod){
		model.addAttribute("TitlePage", "Products Page");
		model.addAttribute("views", "/views/admin/ProductsDetails.jsp");
		
		List<Product> page= prodRepo.findAll();
		model.addAttribute("page",page);
		return "admin/index";
	}
	
	@RequestMapping("/product/edit/{id}")
	private String edit(@PathVariable("id") Product prod,Model model) {
		model.addAttribute("TitlePage", "Products Page");
		model.addAttribute("views", "/views/admin/ProductsDetails.jsp");
		ProductDTO prodDTO=mapper.ConvertToDTO(prod);
		
		
		model.addAttribute("prod",prodDTO);
		System.out.print(prod.getCate().getId() +"\n");
		List<Product> page= prodRepo.findAll();
		model.addAttribute("page",page);
		return"admin/index";
	}
	
	@PostMapping(value = "/product/update/{id}")
	public String save(Model model,@Valid @ModelAttribute("prod") ProductDTO prodDTO) {
		System.out.print("ID là: "+prodDTO.getId());
		Date dateNow= new Date();
		Product prod= mapper.ConvertToEntity(prodDTO);
		prod.setCreate_date(dateNow);
		System.out.print(prod.getId());
		
		
			prodRepo.save(prod);
			System.out.print("Sửa");
			return"redirect:/admin/product/edit/"+prod.getId();
			
			
		
		
	}
	
	@GetMapping(value = "/product/create")
	public String create(Model model,Product prod) {
		model.addAttribute("TitlePage", "Products Page");
		model.addAttribute("views", "/views/admin/createProd.jsp");
		List<Categories> list = cateRepo.findAll();
		model.addAttribute("categories",list);
		model.addAttribute("prod",prod);
		return"admin/index";
	}
	
	@PostMapping(value = "/product/store")
	public String store(Model model,@Valid ProductDTO prodDTO) {
		Date dateNow= new Date();
		Product prod= mapper.ConvertToEntity(prodDTO);
		prod.setCreate_date(dateNow);
		prodRepo.save(prod);
		System.out.print("tạo mới");
		return"redirect:/admin/product";
	}
	
	@PostMapping(value = "/product/clear")
	public String clear(Model model) {
		Product prod= new Product();
		model.addAttribute("prod",prod);
		return "redirect:/admin/product";
	}
	
	@PostMapping(value = "/product/clearcr")
	public String clearCr(Model model) {
		Product prod= new Product();
		model.addAttribute("prod",prod);
		return "redirect:/admin/product/create";
	}
	
	@GetMapping(value = "/product/delete/{id}")
	public String delete(@PathVariable("id") Product prod) {
		
		this.prodRepo.delete(prod);
		return "redirect:/admin/product";
	}
}

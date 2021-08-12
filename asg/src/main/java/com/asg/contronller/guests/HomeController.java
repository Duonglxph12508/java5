package com.asg.contronller.guests;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.asg.entity.Categories;
import com.asg.entity.Product;
import com.asg.repositories.CateRepository;
import com.asg.repositories.ProductRepository;

@Controller
public class HomeController {
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	ProductRepository prodRepo;
	
	@Autowired
	CateRepository cateRepo;
	
	@RequestMapping("/")
	public String home() {
		request.setAttribute("TitlePage", "Home Page");
		request.setAttribute("view", "/views/guests/HotProduct&Slide.jsp");
		
		List<Categories> categories = cateRepo.findAll();
		request.setAttribute("categories", categories);
		
		Sort sortCD=Sort.by(Direction.ASC,"create_date");
		List<Product> newProducts= prodRepo.findProd();
		request.setAttribute("newProducts", newProducts);
		return"layout";
	}
	
	@RequestMapping("/shop/{id}")
	public String showMore(@PathVariable("id") Categories category) {
		request.setAttribute("TitlePage", "Shoping");
		request.setAttribute("view", "/views/guests/AllProducts.jsp");
		request.setAttribute("category", category.getName());
		
		List<Categories> categories = cateRepo.findAll();
		request.setAttribute("categories", categories);
		
		List<Product> products = prodRepo.findByCate(category);
		request.setAttribute("products", products);
		
		return "layout";
	}
}

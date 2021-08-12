package com.asg.contronller.admin;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.asg.entity.Order;
import com.asg.repositories.OrderRepository;



@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	OrderRepository orderRepo;

	@GetMapping("")
	public String index(Model model) {
		model.addAttribute("TitlePage", "Dashboard Page");
		model.addAttribute("views", "/views/admin/dashboard.jsp");
		
		return "/admin/index";
	}
		
	@GetMapping("/bill")
	public String billpaid(
			Model model)
			 {
		model.addAttribute("TitlePage", "Bill Paid Page");
		model.addAttribute("views", "/views/admin/Bill.jsp");
		
		List<Order> order= orderRepo.findAll();
		model.addAttribute("order", order);
		return "/admin/index";
	}
	
}

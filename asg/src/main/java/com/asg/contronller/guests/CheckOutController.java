package com.asg.contronller.guests;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.asg.entity.CartItem;
import com.asg.entity.Categories;
import com.asg.entity.OrderDetail;
import com.asg.entity.Order;
import com.asg.entity.Product;
import com.asg.entity.User;
import com.asg.repositories.CateRepository;
import com.asg.repositories.OrderDetailRepository;
import com.asg.repositories.OrderRepository;
import com.asg.repositories.ProductRepository;
import com.asg.service.ShoppingCartService;

@Controller
public class CheckOutController {
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	OrderDetailRepository oderDRepo;
	
	@Autowired
	OrderRepository oderRepo;
	
	@Autowired
	ProductRepository prodRepo;
	
	@Autowired
	CateRepository cateRepo;
	
	@Autowired
	ShoppingCartService cart;
	
	
	@GetMapping("/cart/checkout")
	public String checkout(Model model) {
		model.addAttribute("TitlePage", "CheckOut Details");
		model.addAttribute("view", "/views/user/checkoutDetails.jsp");
		
		List<Categories> categories = cateRepo.findAll();
		request.setAttribute("categories", categories);
		
		model.addAttribute("cartItems", cart.getItems());
		model.addAttribute("Count", cart.getCount());
		model.addAttribute("Amount", cart.getAmount());
		
		Order order = new Order();
		model.addAttribute("order", order);
		return "layout";
	}
	
	@PostMapping("/cart/checkout")
	public String postCheckOut(
			Model model,
			@ModelAttribute("order") Order order, 
			@RequestParam("fullname") String fullname
			) {
		User user= (User) request.getSession().getAttribute("user");
		order.setUser(user);
//		tạo mới Oder
		oderRepo.save(order);
//		System.out.println("\nSave order: " + order.toString());
		System.out.println("\nNew order fullname: " +user.toString());
		
		for (CartItem item : cart.getItems()) {
//			System.out.println("Save orderDtails: " + item);
			Order o = oderRepo.getById(order.getId());
			Product product = prodRepo.getById(item.getProductId());
			
			System.out.print(product.toString()+"\n");
			System.out.print(o.toString()+"\n");
			
			OrderDetail oddt = new OrderDetail(null, o, product, item.getQuantity(), item.getPrice()); 
			oderDRepo.save(oddt);
		}

		//xoa tat ca san pham trong gio hang
		cart.getItems().clear();
		
		return"redirect:/";
	}
}

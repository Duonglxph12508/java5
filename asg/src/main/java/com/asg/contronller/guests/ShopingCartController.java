package com.asg.contronller.guests;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.asg.entity.CartItem;
import com.asg.entity.Categories;
import com.asg.entity.Product;
import com.asg.repositories.CateRepository;
import com.asg.repositories.ProductRepository;
import com.asg.service.ShoppingCartService;

@Controller
public class ShopingCartController {
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	CateRepository cateRepo;
	
	@Autowired
	ProductRepository prodRepo;
	@Autowired
	ShoppingCartService cart;
	@RequestMapping("/cart/view")
	public String cartView() {
		request.setAttribute("TitlePage", "Cart");
		request.setAttribute("view", "/views/guests/cart.jsp");
		
		List<Categories> categories = cateRepo.findAll();
		request.setAttribute("categories", categories);
		
		request.setAttribute("cartItems", cart.getItems());
		request.setAttribute("Count", cart.getCount());
		request.setAttribute("Amount", cart.getAmount());
		return"layout";
	}
	
	@RequestMapping("/cart/add/{id}")
	public String add(@PathVariable("id") Integer id) {
		Product product= prodRepo.getById(id);
		System.out.println("Add ITEM: " + id);
		if(product != null) {
			CartItem item = new CartItem();
			item.setProductId(product.getId());
			item.setProductName(product.getName());
			item.setPrice(product.getPrice());
			item.setQuantity(1);
			
			cart.add(item);
		}
		return "redirect:/cart/view";
	}
	
	@RequestMapping("/cart/remove/{id}")
	public String remove(@PathVariable("id") Integer id) {
		cart.remove(id);
		
//		System.out.println("Remove ITEM: " + id);
		return "redirect:/cart/view";
	}
	
	@PostMapping("/cart/update/{id}")
	public String update(@PathVariable("id") Integer id, @RequestParam("quantity") Integer quantity) {
		cart.update(id, quantity);
		System.out.println("Update ITEM: " + id + "; Qty = " + quantity);
		return "redirect:/cart/view";
	}

	@RequestMapping("/cart/clear")
	public String clear() {
		cart.clear();

//		System.out.println("CLEAR CART");
		return "redirect:/cart/view";
	}
}

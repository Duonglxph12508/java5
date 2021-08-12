package com.asg.contronller.guests;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.asg.service.ShoppingCartService;



@Controller
public class ProfileController {

	@Autowired
	HttpServletRequest request;

	@Autowired
	ShoppingCartService cart;
	
	
	@RequestMapping("/myProfile")
	public String  viewProfile() {
		request.setAttribute("TitlePage", "My Profile");
		request.setAttribute("view", "/views/user/profile.jsp");
		request.setAttribute("Count", cart.getCount());
		
		return "layout";
	}
}

package com.asg.contronller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.asg.dto.UserDTO;
import com.asg.entity.User;
import com.asg.libs.HashUtils;
import com.asg.mapper.UserMapper;
import com.asg.repositories.UserRepositorry;

@Controller
public class SigUpController {
	
	private UserRepositorry userRepo;

	@Autowired
	HttpServletRequest request;

	@Autowired
	private UserMapper mapper;
	
	@GetMapping("/sigup")
	public String getLoginFrom() {
		return "admin/login";
	}

	
}

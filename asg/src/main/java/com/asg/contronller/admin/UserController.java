package com.asg.contronller.admin;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.asg.dto.UserDTO;
import com.asg.entity.User;
import com.asg.libs.HashUtils;
import com.asg.mapper.UserMapper;
import com.asg.repositories.UserRepositorry;

@Controller
@RequestMapping("/admin")
public class UserController {

	@Autowired // tự tạo một bean để chuyền vào, được gọi dependency injection
	private UserRepositorry userRepo;

	@Autowired
	HttpServletRequest request;

	@Autowired
	private UserMapper mapper;

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String index(Model model, @ModelAttribute("userDTO")UserDTO userDTO) {
		model.addAttribute("TitlePage", "Users Page");
		model.addAttribute("views", "/views/admin/UsersDetails.jsp");
		
		
//		Pageable pageable = PageRequest.of(0, 5);
//		Page<User> page= userRepo.findAll(pageable);
		
		List<User> page=userRepo.findAll();
		model.addAttribute("page", page);
//		model.addAttribute("listUser", listUser);
		return "admin/index";
	}

	@GetMapping(value = "/{id}"// {id} biến id thành 1 thành phần của đường dẫn
	)
	public String show(Model model, @PathVariable(name = "id") User entity) {//show 1 users

		UserDTO userDTO = mapper.convertToDTO(entity);
		model.addAttribute("user", userDTO);
		return "";
	}
	
	//edit
	@GetMapping(value = "/users/edit/{id}")
	public String edit(@PathVariable("id") User entity, Model model) {
		// moddelMapper
//		Link thư viện: https://mvnrepository.com/artifact/org.modelmapper/modelmapper/2.4.4
		
		model.addAttribute("TitlePage", "Users Page");
		model.addAttribute("views", "/views/admin/UsersDetails.jsp");
		
		UserDTO userDTO = mapper.convertToDTO(entity);
		model.addAttribute("userDTO",userDTO);
		
//		Pageable pageable = PageRequest.of(0, 5);
//		Page<User> page= userRepo.findAll(pageable);
		
		List<User> page=userRepo.findAll();
		model.addAttribute("page", page);
		return "admin/index";
	}
	
	@PostMapping(value = "/users/update/{id}")
	public String update(Model model, @Valid UserDTO userDTO, BindingResult result ) {
		System.out.print("ID userDTO:  "+userDTO.toString()+"\n");
		
		User entity = mapper.convertToEntity(userDTO);
		String hashedPwd = HashUtils.Hash(userDTO.getPassword());
		entity.setPassword(hashedPwd);
		System.out.print("user:  "+entity.toString()+"\n");
		this.userRepo.save(entity);
		
		return "redirect:/admin/users";
		
	}
	
	@GetMapping(value = "/users/delete/{id}")
	public String delete(@PathVariable("id") User entity) {
		System.out.print("user:  "+entity.toString()+"\n");
		this.userRepo.delete(entity);
		return "redirect:/admin/users";
	}
	
	
}

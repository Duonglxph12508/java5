package com.asg.contronller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.asg.dto.UserDTO;
import com.asg.entity.User;
import com.asg.libs.HashUtils;
import com.asg.mapper.UserMapper;
import com.asg.repositories.UserRepositorry;



@Controller
public class LoginContronller {
	@Autowired
	private UserRepositorry userRepo;
	
	@Autowired
	private HttpServletRequest request;
	
	@GetMapping("/login")
	public String getLoginFrom() {
		return "login";
	}
	@Autowired
	private UserMapper mapper;
	
	@PostMapping("/login")
	public String login(
			
			@RequestParam("email") String email,
			@RequestParam("password") String password
			) {
		//truy vấn theo email
		User entity=this.userRepo.findByEmail(email);
		System.out.print(entity.toString()+"\n");
		boolean checkPwd= false;
		if(entity!=null) {
		checkPwd=HashUtils.verify(password,entity.getPassword() );
		}
		if(!checkPwd) {
			request.getSession().setAttribute("errorMessage", "Sai email hoặc password");
			return"redirect:/login";
		}
		request.getSession().setAttribute("user", entity);
		System.out.print("Login user: "+request.getSession().getAttribute("user")+"\n");
		
		return "redirect:/";
	}
	@PostMapping(value = "/store")
	public String store(Model model, @Valid UserDTO userDTO, BindingResult result,@RequestParam("email") String email,
			@RequestParam("password") String password) {
		// kiểm tra lỗi
		User entity = mapper.convertToEntity(userDTO);
		
		String hashedPwd = HashUtils.Hash(userDTO.getPassword());
		entity.setPassword(hashedPwd);
		entity.setActivated(1);
		entity.setAdmin(0);
		entity.setPhoto("");
		System.out.print("user thêm mới :  "+entity.toString()+"\n");
		this.userRepo.save(entity);
//		User user=this.userRepo.findByEmail(email);
//		request.getSession().setAttribute("user", entity);
		return "redirect:/login";
	}
//	@RequestMapping(value = "/logout")
//	public String logout(){
//		request.getSession().removeAttribute("user");
//		System.out.print(request.getSession().getAttribute("user"));
//		return"redirect:/login";
//	}
}

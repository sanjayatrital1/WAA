package mum.edu.controller;

import mum.edu.domain.User;
import mum.edu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import java.io.IOException;

@Controller
@SessionAttributes("username")
public class AuthenticationServlet {

	@Autowired
	private UserService userService;

	@GetMapping("/login")
	public String getLoginForm() {
 		
		return "login";
	}

	@PostMapping(value = "/login")
	public String LoginSuccess(Model model, User userName) {
		User user = userService.findByName(userName.getName());
		if(user ==null || !user.getPassword().equals(userName.getPassword())){
			throw new RuntimeException("UserName/Password is incorrect");

		}
	 else {
			model.addAttribute("username",user);
			return "redirect:/adviceForm";
		
		}
	}

	@GetMapping("/successful")
	public String loginPage(Model model){

		return "LoginSuccessful";
	}

	@GetMapping("/logout")
	public String logOut(SessionStatus status){
		status.setComplete();
		return "redirect:/adviceForm";
	}

}

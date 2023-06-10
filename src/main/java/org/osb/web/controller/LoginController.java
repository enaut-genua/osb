package org.osb.web.controller;

import java.util.List;

import org.osb.web.domain.user.dto.UserDto;
import org.osb.web.domain.user.service.UserService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;

	@GetMapping("/index")
	public String home() {
		return "menu";
	}

	@GetMapping("/login")
	public String loginForm() {
		return "login";
	}

	// handler method to handle user registration request
	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		UserDto user = new UserDto();
		model.addAttribute("user", user);
		return "register";
	}

	// handler method to handle register user form submit request
	@PostMapping("/register/save")
	public String registration(@Valid @ModelAttribute("user") UserDto user,
			BindingResult result,
			Model model) {
		if (userService.findUserDtoByEmail(user.getEmail()).isPresent()) {
			result.rejectValue("email", null, "There is already an account registered with that email");
			model.addAttribute("user", user);
			return "register";
		}
		userService.saveUser(user);
		return "redirect:/register?success";
	}

	@GetMapping("/users")
	public String listRegisteredUsers(Model model) {
		List<UserDto> users = userService.findAllUsers();
		model.addAttribute("users", users);
		return "users";
	}

	@GetMapping("/menu")
	public String menu(Model model) {
		return "menu";
	}
}

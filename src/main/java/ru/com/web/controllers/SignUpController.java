package ru.com.web.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.com.web.forms.SignUpForm;
import ru.com.web.services.SignUpService;

@RequiredArgsConstructor
@Controller
@RequestMapping("/signup")
public class SignUpController {
	private final SignUpService signUpService;

	@GetMapping
	public String getSignUpPage() {
		return "signup";
	}

	@PostMapping
	public String signUpUser(SignUpForm form) {
		signUpService.signUpUser(form);
		return "redirect:/signIn";
	}
}

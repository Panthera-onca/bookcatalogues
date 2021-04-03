package com.example.bookcatalogues.validatingforminput;


import javax.validation.Valid;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;


@Controller
public class WebController implements WebMvcConfigurer {
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/user/add").setViewName("form");
		registry.addViewController("/user/save").setViewName("form");
		registry.addViewController("/user/all").setViewName("results");
		registry.addViewController("/user/{id}").setViewName("results");
		registry.addViewController("/user/{username}").setViewName("results");
		registry.addViewController("/user/update/{id}").setViewName("form");
		registry.addViewController("/livre/add").setViewName("livreForm");
		registry.addViewController("/livre/save").setViewName("livreForm");
		registry.addViewController("/livre/all").setViewName("results");
		registry.addViewController("/livre/{id}").setViewName("results");
		registry.addViewController("/livre/{titre}").setViewName("results");
		registry.addViewController("/livre/{genre}").setViewName("results");
		registry.addViewController("/livre/disponibilité/{id}").setViewName("results");
		registry.addViewController("/livre/update/{id}").setViewName("livreForm");
		
		
		
	}

	@GetMapping("/user")
	public String showForm(UserForm userForm) {
		return "form";
	}
	
	@GetMapping("/user")
	public String showLivreForm(LivreForm livreForm) {
		return "livreForm";
	}

	@PostMapping("/user/add")
	public String checkPersonInfo(@Valid UserForm userForm, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "form";
		}

		return "redirect:/results";
	}
	
	@PostMapping("/livre/add")
	public String checkLivreInfo(@Valid LivreForm livreForm, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "livreForm";
		}

		return "redirect:/results";
	}

}

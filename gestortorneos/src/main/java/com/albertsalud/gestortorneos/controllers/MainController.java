package com.albertsalud.gestortorneos.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping(value = "/")
	public String welcome() {
		return "index";
	}

}

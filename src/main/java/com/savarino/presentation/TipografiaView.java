package com.savarino.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class TipografiaView {
	
	@GetMapping("/login")
	public String showClienti() {
		return "index";
	}
	@GetMapping("/showClienti")
	public String mostraNuovoCliente() {
	   return "listaClienti";
	}
	@GetMapping("/showOrdini")
	public String mostraNuovoProdotto() {
	   return "listaOrdini";
	}
	

}


package com.savarino.integration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.savarino.entities.Cliente;
import com.savarino.entities.Ordine;
import com.savarino.repo.ClienteDAO;
import com.savarino.repo.OrdineDAO;
import com.savarino.services.TipografiaService;

@RestController
@RequestMapping("api")
public class TipografiaREST {

	@Autowired
	private TipografiaService tipografiaService;
	@Autowired
	private ClienteDAO clienteDAO;
	@Autowired
	private OrdineDAO ordineDAO;
	
	@GetMapping("clienti")
	public List<Cliente> showClienti(){
		return tipografiaService.getClienti();
	}
	@GetMapping("ordini")
	public List<Ordine>showOrdini(){
		return tipografiaService.getOrdini();
	}
	@PostMapping(value =  "aggiungiCliente",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ResponseEntity<String>addCliente(@ModelAttribute Cliente cliente){
		tipografiaService.addCliente(cliente);
		return ResponseEntity.status(HttpStatus.CREATED).body(Integer.valueOf(cliente.getId()).toString());
	}
	@PostMapping(value = "aggiungiOrdine", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ResponseEntity<String>addProdotto(@ModelAttribute Ordine ordine){
		tipografiaService.addOrdine(ordine);
		return ResponseEntity.status(HttpStatus.CREATED).body(Integer.valueOf(ordine.getId()).toString());
	}
	@PostMapping("eliminaCliente")
	public void eliminaCliente(int id) {
		clienteDAO.deleteById(id);
		
	}
	@PostMapping("eliminaOrdine")
	public void eliminaOrdine(int id) {
		ordineDAO.deleteById(id);
	
	}
	
	
}

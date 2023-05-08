package com.savarino.services;

import java.util.List;

import com.savarino.entities.Cliente;
import com.savarino.entities.Ordine;

public interface TipografiaService {
	
	List<Ordine>getOrdini();
	List<Cliente>getClienti();
	void addCliente(Cliente c);
	void addOrdine(Ordine o);
	

}

package com.savarino.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.savarino.entities.Cliente;
import com.savarino.entities.Ordine;
import com.savarino.repo.ClienteDAO;
import com.savarino.repo.OrdineDAO;

@Service
public class TipografiaServiceImpl implements TipografiaService {

	@Autowired
	private OrdineDAO ordineDAO;
	@Autowired
	private ClienteDAO clienteDAO;
	@Override
	public List<Ordine> getOrdini() {
		// TODO Auto-generated method stub
		return ordineDAO.findAll();
	}

	@Override
	public List<Cliente> getClienti() {
		// TODO Auto-generated method stub
		return clienteDAO.findAll();
	}

	@Override
	public void addCliente(Cliente c) {
		// TODO Auto-generated method stub
		clienteDAO.save(c);
	}

	@Override
	public void addOrdine(Ordine o) {
		// TODO Auto-generated method stub
		ordineDAO.save(o);
		
	}

}

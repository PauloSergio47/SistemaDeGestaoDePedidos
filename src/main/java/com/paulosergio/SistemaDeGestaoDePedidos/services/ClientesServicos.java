package com.paulosergio.SistemaDeGestaoDePedidos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.paulosergio.SistemaDeGestaoDePedidos.entidades.Clientes;
import com.paulosergio.SistemaDeGestaoDePedidos.exception.AppExceptions;
import com.paulosergio.SistemaDeGestaoDePedidos.repository.ClienteRepository;

@Service
public class ClientesServicos {
	
	private ClienteRepository clienteRepository;

	public List<Clientes> findAll() {
		return clienteRepository.findAll();
	}
	
	public Clientes findById(Long id) {
		Optional<Clientes> clientes = clienteRepository.findById(id);
		
		if(clientes.isEmpty()) {
			throw AppExceptions.emptyList();
		}
		
		return clientes.get();
	}
	
	public Clientes register(Clientes cliente) {
		
		if(cliente.getNome() == null || cliente.getNome().trim().isEmpty()) {
			throw AppExceptions.emptyName();
		}
		
		if(cliente.getEmail() == null || cliente.getEmail().trim().isEmpty()) {
			throw AppExceptions.emptyEmail();
		}
		
		if(cliente.getTelefone() == null || cliente.getTelefone().trim().isEmpty()) {
			throw AppExceptions.emptyTelephone();
		}
		
		return clienteRepository.save(cliente);
	}
	
	public Clientes update(Long id, Clientes cliente) {
		Clientes clienteExists = clienteRepository.findById(id)
	            .orElseThrow(() -> AppExceptions.clienteNaoCadastrado(id));
		
		clienteExists.setNome(cliente.getNome());
		clienteExists.setEmail(cliente.getEmail());
		clienteExists.setTelefone(cliente.getTelefone());
		
		return clienteRepository.save(clienteExists);
	}

	public void deletCliente(Long id) {
		if(!clienteRepository.existsById(id)) {
			throw AppExceptions.emptyClient();
		}
		
		clienteRepository.deleteById(id);
	}
}

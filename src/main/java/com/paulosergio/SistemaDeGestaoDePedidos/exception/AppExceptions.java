package com.paulosergio.SistemaDeGestaoDePedidos.exception;

public class AppExceptions extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public AppExceptions(String message) {
		super(message);
	}
	
	public static AppExceptions clienteNaoCadastrado(Long id) {
		return new AppExceptions("Cliente Não Cadastrado! ID: "+id);
	}
	
	public static AppExceptions emptyList() {
		return new AppExceptions("Lista Vazia!");
	}
	
	public static AppExceptions genericErro(String message) {
		return new AppExceptions(message);
	}
	
	public static AppExceptions emptyName() {
		return new AppExceptions("Nome não pode estar vazio!");
	}
	
	public static AppExceptions emptyEmail() {
		return new AppExceptions("Email não pode estar vazio!");
	}
	
	public static AppExceptions emptyTelephone() {
		return new AppExceptions("Telefone não pode estar vazio!");
	}
	
	public static AppExceptions emptyClient() {
		return new AppExceptions("Cliente não encontrado!");
	}
	
}

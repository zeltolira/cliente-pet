package br.com.petz.clientepet.cliente.application.api;

import java.util.UUID;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class ClienteListResponse {

	private UUID idCliente;
	private String nomeCompleto;
	private String cpf;
	private String email;
	private String celular;
}

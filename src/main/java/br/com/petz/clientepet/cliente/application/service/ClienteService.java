package br.com.petz.clientepet.cliente.application.service;

import java.util.List;
import java.util.UUID;

import br.com.petz.clientepet.cliente.application.api.ClienteAlteracaoResquest;
import br.com.petz.clientepet.cliente.application.api.ClienteDetalhadoResponse;
import br.com.petz.clientepet.cliente.application.api.ClienteListResponse;
import br.com.petz.clientepet.cliente.application.api.ClienteResponse;
import br.com.petz.clientepet.cliente.application.api.ClienteResquest;

public interface ClienteService {
	ClienteResponse criaCliente(ClienteResquest clienteRequest);
	List<ClienteListResponse> buscaTodosClientes();
	ClienteDetalhadoResponse buscaClienteAtravesId(UUID idCliente);
	void deletaClienteAtravesId(UUID idCliente);
	void patchAlteraCliente(UUID idCliente,  ClienteAlteracaoResquest clienteAlteracaoRequest);
}

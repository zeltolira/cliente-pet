package br.com.petz.clientepet.pet.application.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.petz.clientepet.cliente.application.service.ClienteService;
import br.com.petz.clientepet.pet.application.api.PetResponse;
import br.com.petz.clientepet.pet.application.api.PetResquest;
import br.com.petz.clientepet.pet.domain.Pet;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class PetApplicationService implements PetService {
	private final ClienteService clienteService;
	private final PetRespository petRespository;
	@Override
	public PetResponse criaPet(UUID idCliente, @Valid PetResquest petRequest) {
		log.info("[strat] PetApplicationService - criaPet");
		clienteService.buscaClienteAtravesId(idCliente);
		Pet pet = petRespository.salvaPet(new Pet(idCliente, petRequest));
		log.info("[finish] PetApplicationService - criaPet");
		return new PetResponse(pet.getIdPet());
	}

}

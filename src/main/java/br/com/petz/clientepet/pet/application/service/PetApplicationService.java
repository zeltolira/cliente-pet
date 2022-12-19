package br.com.petz.clientepet.pet.application.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.petz.clientepet.cliente.application.service.ClienteService;
import br.com.petz.clientepet.pet.application.api.PetClienteDetalhadoResponse;
import br.com.petz.clientepet.pet.application.api.PetClienteListResponse;
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
	@Override
	public List<PetClienteListResponse> buscaPetsDoClienteComId(UUID idCliente) {
		log.info("[strat] PetApplicationService - buscaPetsDoClienteComId");
		clienteService.buscaClienteAtravesId(idCliente);
		List<Pet> petsDoCliente = petRespository.buscaPetsDoClienteComId(idCliente);
		log.info("[finish] PetApplicationService - buscaPetsDoClienteComId");
		return PetClienteListResponse.converte(petsDoCliente);
	}
	@Override
	public PetClienteDetalhadoResponse buscaPetClienteAtravesId(UUID idCliente, UUID idPet) {
		log.info("[strat] PetApplicationService - buscaPetClienteAtravesId");
		clienteService.buscaClienteAtravesId(idCliente);
		Pet pet = petRespository.buscaPetPeloId(idPet);
		log.info("[finish] PetApplicationService - buscaPetClienteAtravesId");
		return new PetClienteDetalhadoResponse(pet);
	}
	@Override
	public void deletaPetClienteAtravesId(UUID idCliente, UUID idPet) {
		log.info("[strat] PetApplicationService - deletaPetClienteAtravesId");
		clienteService.buscaClienteAtravesId(idCliente);
		Pet pet = petRespository.buscaPetPeloId(idPet);
		petRespository.deletaPet(pet);
		log.info("[finish] PetApplicationService - deletaPetClienteAtravesId");
		
	}
	

}

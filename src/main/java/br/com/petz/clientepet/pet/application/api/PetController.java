package br.com.petz.clientepet.pet.application.api;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.RestController;

import br.com.petz.clientepet.pet.application.service.PetService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequiredArgsConstructor
public class PetController implements PetAPI {
	private final PetService petService;
	@Override
	public PetResponse postPet(UUID idCliente, @Valid PetResquest petRequest) {
		log.info("[inicia] PetController - postPet");
		log.info("[idCliente] {} - idCliente");
		PetResponse pet = petService.criaPet(idCliente, petRequest);
		log.info("[finaliza] PetController - postPet");
		return pet;
	}
	@Override
	public List<PetClienteListResponse> GetTodosClientesComId(UUID idCliente) {
		log.info("[inicia] PetController - GetTodosClientesComId");
		log.info("[idCliente] {} - idCliente");
		List<PetClienteListResponse> petsDoCliente = petService.buscaPetsDoClienteComId(idCliente);
		log.info("[finaliza] PetController - GetTodosClientesComId");
		return petsDoCliente;
	}
	@Override
	public PetClienteDetalhadoResponse getPetClienteAtravesId(UUID idCliente, UUID idPet) {
		log.info("[inicia] PetController - getPetClienteAtravesId");
		log.info("[idCliente] {} - [idPet] {} - idCliente, idPet");
		PetClienteDetalhadoResponse pet = petService.buscaPetClienteAtravesId(idCliente, idPet);
		log.info("[finaliza] PetController - getPetClienteAtravesId");
		return pet;
	}
	@Override
	public void deletePetClienteAtravesId(UUID idCliente, UUID idPet) {
		log.info("[inicia] PetController - deletePetClienteAtravesId");
		log.info("[idCliente] {} - [idPet] {} - idCliente, idPet");
		petService.deletaPetClienteAtravesId(idCliente, idPet);
		log.info("[finaliza] PetController - deletePetClienteAtravesId");

	}
	@Override
	public PetResponse patctPet(UUID idCliente, UUID idPet, @Valid PetAlteracaoResquest petAlteracaoRequest) {
		log.info("[inicia] PetController - patctPet");
		log.info("[idCliente] {} - [idPet] {} - idCliente, idPet");
		log.info("[finaliza] PetController - patctPet");
		return null;
	}

}

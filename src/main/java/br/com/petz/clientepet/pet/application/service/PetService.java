package br.com.petz.clientepet.pet.application.service;

import java.util.UUID;

import br.com.petz.clientepet.pet.application.api.PetResponse;
import br.com.petz.clientepet.pet.application.api.PetResquest;
import jakarta.validation.Valid;

public interface PetService {
	PetResponse criaPet(UUID idCliente, @Valid PetResquest petRequest);
}

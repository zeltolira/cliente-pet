package br.com.petz.clientepet.pet.infra;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import br.com.petz.clientepet.pet.application.service.PetRespository;
import br.com.petz.clientepet.pet.domain.Pet;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Repository
@Log4j2
@RequiredArgsConstructor
public class PetInfreRepository implements PetRespository {
	private final PetSpringDataJPARepository petSpringDataJPARepository;
	
	@Override
	public Pet salvaPet(Pet pet) {
		log.info("[start] PetInfreRepository - salvaPet");
		petSpringDataJPARepository.save(pet);
		log.info("[finish] PetInfreRepository - salvaPet");
		return pet;
	}

	@Override
	public List<Pet> buscaPetsDoClienteComId(UUID idCliente) {
		log.info("[start] PetInfreRepository - buscaPetsDoClienteComId");
		log.info("[finish] PetInfreRepository - buscaPetsDoClienteComId");
		return null;
	}

}

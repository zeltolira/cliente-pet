package br.com.petz.clientepet.pet.infra;

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

}

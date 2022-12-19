package br.com.petz.clientepet.pet.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import br.com.petz.clientepet.pet.application.api.PetAlteracaoResquest;
import br.com.petz.clientepet.pet.application.api.PetResquest;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Entity
public class Pet {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(columnDefinition = "uuid", name = "idPet", updatable = false, unique = true, nullable = false)
	private UUID idPet;
	@Column(columnDefinition = "uuid", name = "idClienteTutor", nullable = false)
	private UUID idClienteTutor;
	@NotBlank
	private String nomePet;
	@Enumerated(EnumType.STRING)
	private Porte porte;
	@Enumerated(EnumType.STRING)
	private TipoPet tipo;
	private String microchip;
	private String raca;
	@Enumerated(EnumType.STRING)
	private SexoPet sexo;
	private String pelagemCor;
	@NotNull
	private LocalDate dataNascimento;
	private String rga;
	private Integer peso;
			
	
	private LocalDateTime dataHoraDoCadastro;
	private LocalDateTime dataHoraDaUltimaAlteracao;
	
	public Pet(UUID idCliente, @Valid PetResquest petRequest) {
		this.idClienteTutor = idCliente;
		this.nomePet = petRequest.getNomePet();
		this.porte = petRequest.getPorte();
		this.tipo = petRequest.getTipo();
		this.microchip = petRequest.getMicrochip();
		this.raca = petRequest.getRaca();
		this.sexo = petRequest.getSexo();
		this.pelagemCor = petRequest.getPelagemCor();
		this.dataNascimento = petRequest.getDataNascimento();
		this.rga = petRequest.getRaca();
		this.peso = petRequest.getPeso();
		this.dataHoraDoCadastro = LocalDateTime.now();
	}

	public void altera(PetAlteracaoResquest petRequest) {
		this.nomePet = petRequest.getNomePet();
		this.porte = petRequest.getPorte();
		this.tipo = petRequest.getTipo();
		this.microchip = petRequest.getMicrochip();
		this.raca = petRequest.getRaca();
		this.sexo = petRequest.getSexo();
		this.pelagemCor = petRequest.getPelagemCor();
		this.dataNascimento = petRequest.getDataNascimento();
		this.rga = petRequest.getRaca();
		this.peso = petRequest.getPeso();
		this.dataHoraDaUltimaAlteracao = LocalDateTime.now();
		
	}


}
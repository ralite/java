package fr.hb.ewan.plages.dto;

import java.time.LocalDateTime;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@Data
@FieldDefaults(level=AccessLevel.PRIVATE)
public class ClientDto {

 Long id;
	
	@Column(length=80)
	 String nom;

	 String prenom;

	@Column(length=150)
	 String email;

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	 String motDePasse;
	
	PaysDto paysDto;

	LienDeParenteDto lienDeParenteDto;
	
	LocalDateTime dateHeureInscription;

	

}

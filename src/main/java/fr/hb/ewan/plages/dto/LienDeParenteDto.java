package fr.hb.ewan.plages.dto;

import org.hibernate.validator.constraints.Range;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@Data
@FieldDefaults(level=AccessLevel.PRIVATE)
public class LienDeParenteDto {
	
	private Long id;
	
	String nom;

	@Range(min=0, max=1, message="Le coefficient doit être compris entre 0 et 1")
	float coefficient;
}

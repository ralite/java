package fr.hb.ewan.plages.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import fr.hb.ewan.plages.business.LienDeParente;
import fr.hb.ewan.plages.dto.LienDeParenteDto;

@Mapper(componentModel = "spring")
public interface LienDeParenteMapper {
	/**
     * Méthode qui convertit un métier en Dto
     * 
     * @param lienDeParente
     * @return un objet Dto
     */
    LienDeParenteDto toDto(LienDeParente lienDeParente);

    /**
     * Méthode qui convertit un Dto en métier
     * 
     * @param lienDeParenteDto
     * @return un objet métier
     */
    @Mapping(target = "id", ignore = true)
    // @Mapping(target = "clients", ignore = true)
    LienDeParente toEntity(LienDeParenteDto lienDeParenteDto);
}

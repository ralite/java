package fr.hb.ewan.plages.mapper;

import org.mapstruct.Mapper;

import fr.hb.ewan.plages.business.Pays;
import fr.hb.ewan.plages.dto.PaysDto;

@Mapper(componentModel = "spring")
public interface PaysMapper {

    /**
     * Méthode qui convertit un métier en Dto
     * 
     * @param pays
     * @return un objet Dto
     */
    PaysDto toDto(Pays pays);

    /**
     * Méthode qui convertit un Dto en métier
     * 
     * @param paysDto
     * @return un objet métier
     */
    Pays toEntity(PaysDto paysDto);
}

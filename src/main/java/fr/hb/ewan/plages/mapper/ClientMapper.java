package fr.hb.ewan.plages.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants.ComponentModel;
import org.mapstruct.factory.Mappers;

import fr.hb.ewan.plages.business.Client;
import fr.hb.ewan.plages.dto.ClientDto;

@Mapper(componentModel = ComponentModel.SPRING, uses = { PaysMapper.class, LienDeParenteMapper.class })
public interface ClientMapper {

    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    @Mapping(source = "paysDto", target = "pays")
    @Mapping(source = "lienDeParenteDto", target = "lienDeParente")
    @Mapping(target = "reservations", ignore = true)
    @Mapping(target = "dateHeureInscription", ignore = true)
    Client toEntity(ClientDto clientDto);

    @Mapping(source = "pays", target = "paysDto")
    @Mapping(source = "lienDeParente", target = "lienDeParenteDto")
    ClientDto toDto(Client client);

}
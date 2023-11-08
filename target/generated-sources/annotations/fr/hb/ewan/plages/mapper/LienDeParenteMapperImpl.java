package fr.hb.ewan.plages.mapper;

import fr.hb.ewan.plages.business.LienDeParente;
import fr.hb.ewan.plages.dto.LienDeParenteDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-14T14:49:59+0200",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 3.34.0.v20230523-1233, environment: Java 20.0.1 (Eclipse Adoptium)"
)
@Component
public class LienDeParenteMapperImpl implements LienDeParenteMapper {

    @Override
    public LienDeParenteDto toDto(LienDeParente lienDeParente) {
        if ( lienDeParente == null ) {
            return null;
        }

        LienDeParenteDto lienDeParenteDto = new LienDeParenteDto();

        lienDeParenteDto.setCoefficient( lienDeParente.getCoefficient() );
        lienDeParenteDto.setId( lienDeParente.getId() );
        lienDeParenteDto.setNom( lienDeParente.getNom() );

        return lienDeParenteDto;
    }

    @Override
    public LienDeParente toEntity(LienDeParenteDto lienDeParenteDto) {
        if ( lienDeParenteDto == null ) {
            return null;
        }

        LienDeParente lienDeParente = new LienDeParente();

        lienDeParente.setCoefficient( lienDeParenteDto.getCoefficient() );
        lienDeParente.setNom( lienDeParenteDto.getNom() );

        return lienDeParente;
    }
}

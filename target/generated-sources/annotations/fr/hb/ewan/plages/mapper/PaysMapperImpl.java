package fr.hb.ewan.plages.mapper;

import fr.hb.ewan.plages.business.Pays;
import fr.hb.ewan.plages.dto.PaysDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-14T14:49:59+0200",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 3.34.0.v20230523-1233, environment: Java 20.0.1 (Eclipse Adoptium)"
)
@Component
public class PaysMapperImpl implements PaysMapper {

    @Override
    public PaysDto toDto(Pays pays) {
        if ( pays == null ) {
            return null;
        }

        PaysDto paysDto = new PaysDto();

        paysDto.setCode( pays.getCode() );
        paysDto.setNom( pays.getNom() );

        return paysDto;
    }

    @Override
    public Pays toEntity(PaysDto paysDto) {
        if ( paysDto == null ) {
            return null;
        }

        Pays pays = new Pays();

        pays.setCode( paysDto.getCode() );
        pays.setNom( paysDto.getNom() );

        return pays;
    }
}

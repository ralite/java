package fr.hb.ewan.plages.mapper;

import fr.hb.ewan.plages.business.Client;
import fr.hb.ewan.plages.dto.ClientDto;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-14T14:50:00+0200",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 3.34.0.v20230523-1233, environment: Java 20.0.1 (Eclipse Adoptium)"
)
@Component
public class ClientMapperImpl implements ClientMapper {

    @Autowired
    private PaysMapper paysMapper;
    @Autowired
    private LienDeParenteMapper lienDeParenteMapper;

    @Override
    public Client toEntity(ClientDto clientDto) {
        if ( clientDto == null ) {
            return null;
        }

        Client.ClientBuilder<?, ?> client = Client.builder();

        client.pays( paysMapper.toEntity( clientDto.getPaysDto() ) );
        client.lienDeParente( lienDeParenteMapper.toEntity( clientDto.getLienDeParenteDto() ) );
        client.email( clientDto.getEmail() );
        client.id( clientDto.getId() );
        client.motDePasse( clientDto.getMotDePasse() );
        client.nom( clientDto.getNom() );
        client.prenom( clientDto.getPrenom() );

        return client.build();
    }

    @Override
    public ClientDto toDto(Client client) {
        if ( client == null ) {
            return null;
        }

        ClientDto clientDto = new ClientDto();

        clientDto.setPaysDto( paysMapper.toDto( client.getPays() ) );
        clientDto.setLienDeParenteDto( lienDeParenteMapper.toDto( client.getLienDeParente() ) );
        clientDto.setDateHeureInscription( client.getDateHeureInscription() );
        clientDto.setEmail( client.getEmail() );
        clientDto.setId( client.getId() );
        clientDto.setMotDePasse( client.getMotDePasse() );
        clientDto.setNom( client.getNom() );
        clientDto.setPrenom( client.getPrenom() );

        return clientDto;
    }
}

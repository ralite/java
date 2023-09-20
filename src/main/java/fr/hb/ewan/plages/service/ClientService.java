package fr.hb.ewan.plages.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import fr.hb.ewan.plages.business.Client;
import fr.hb.ewan.plages.business.LienDeParente;
import fr.hb.ewan.plages.business.Pays;
import fr.hb.ewan.plages.dto.ClientDto;

public interface ClientService {

	/**
	 * La méthode renvoie une page de Client
	 * 
	 * @param pageable qui correspond à une demande de page
	 * @return une page de clients
	 */
	Page<Client> recupererClients(Pageable pageable);
	
	List<Client> recupererClients();
	
	List<Client> recupererClientsParPays(Pays pays);

	List<Client> recupererClientsParLienDeParente(LienDeParente lienDeParente);
	
	Client recupererClient(Long idClient);

	Client enregistrerClient(Client client);

	boolean supprimerClient(Long id);

	Client enregistrerClient(ClientDto clientDto);
}

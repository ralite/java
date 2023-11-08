package fr.humanbooster.fx.plages.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import fr.humanbooster.fx.plages.business.Client;

public interface ClientService {

	/**
	 * La méthode renvoie une page de Client
	 * 
	 * @param pageable qui correspond à une demande de page
	 * @return une page de clients
	 */
	Page<Client> recupererClients(Pageable pageable);

	Client recupererClient(Long idClient);

	Client enregistrerClient(Client client);

	boolean supprimerClient(Long id);
}

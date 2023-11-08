package fr.humanbooster.fx.plages.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.humanbooster.fx.plages.business.Client;
import fr.humanbooster.fx.plages.dao.ClientDao;
import fr.humanbooster.fx.plages.exception.ClientInexistantException;
import fr.humanbooster.fx.plages.exception.SuppressionClientImpossibleException;
import fr.humanbooster.fx.plages.service.ClientService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {

	private ClientDao clientDao;
	
	@Transactional(readOnly = true)
	@Override
	public Page<Client> recupererClients(Pageable pageable) {
		return clientDao.findAll(pageable);
	}

	@Override
	public Client recupererClient(Long idClient) {
		return clientDao.findById(idClient).orElse(null);
	}

	@Override
	public Client enregistrerClient(Client client) {
		return clientDao.save(client);
	}

	@Override
    public boolean supprimerClient(Long id) {
		Client client = recupererClient(id);
		if (client==null) {
			throw new ClientInexistantException("Ce client n'existe pas");
		}
		if (!client.getReservations().isEmpty()) {
			throw new SuppressionClientImpossibleException("Le client ne peut être supprimé car il a effectué des réservations");
		}
        clientDao.delete(client);
        return true;
    }
}

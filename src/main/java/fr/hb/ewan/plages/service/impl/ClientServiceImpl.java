package fr.hb.ewan.plages.service.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.hb.ewan.plages.business.Client;
import fr.hb.ewan.plages.business.LienDeParente;
import fr.hb.ewan.plages.business.Pays;
import fr.hb.ewan.plages.dao.ClientDao;
import fr.hb.ewan.plages.dto.ClientDto;
import fr.hb.ewan.plages.exception.ClientInexistantException;
import fr.hb.ewan.plages.exception.SuppressionClientImpossibleException;
import fr.hb.ewan.plages.mapper.ClientMapper;
import fr.hb.ewan.plages.service.ClientService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {

	private ClientDao clientDao;
	private ClientMapper clientMapper;
	
	@Transactional(readOnly = true)
	@Override
	public Page<Client> recupererClients(Pageable pageable) {
		return clientDao.findAll(pageable);
	}

	@Override
	public List<Client> recupererClients() {
		return clientDao.findAll();
	}

	
	
	
	@Override
	public List<Client> recupererClientsParPays(Pays pays) {
		return clientDao.findByPays(pays);
	}
	
	@Override
	public List<Client> recupererClientsParLienDeParente(LienDeParente lienDeParente) {
		return clientDao.findAllByLienDeParente(lienDeParente);
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
	
	@Override
	public Client enregistrerClient(ClientDto clientDto) {
		return clientDao.save(clientMapper.toEntity(clientDto));
	}
	
}

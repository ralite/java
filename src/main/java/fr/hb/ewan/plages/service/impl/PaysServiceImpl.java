package fr.hb.ewan.plages.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.hb.ewan.plages.business.Pays;
import fr.hb.ewan.plages.dao.PaysDao;
import fr.hb.ewan.plages.dto.PaysDto;
import fr.hb.ewan.plages.exception.PaysExistantException;
import fr.hb.ewan.plages.exception.PaysInexistantException;
import fr.hb.ewan.plages.mapper.PaysMapper;
import fr.hb.ewan.plages.service.PaysService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PaysServiceImpl implements PaysService {

	private final PaysDao paysDao;
	private final PaysMapper paysMapper;

	@Override
	public List<Pays> recupererPays() {
		return paysDao.findAll();
	}

	/**
	 * Cette méthode ajoute un nouveau pays en utilisant le code et le nom donnés en paramètre
	 * 
	 * si le code est déjà présent en base, la méthode lève une exception PaysExistantException
	 * 
	 */
	@Override
	
	public Pays ajouterPays(String code, String nom) {
		if (paysDao.findByCode(code)==null) {
			return paysDao.save(new Pays(code, nom));			
		}
		else {
			throw new PaysExistantException("Ce pays existe déjà");
		}
	}

	@Override
	public Pays mettreAJour(String code, String nouveauNom) {
		Pays pays = paysDao.findByCode(code);
		if (pays != null) {
			pays.setNom(nouveauNom);
			return paysDao.save(pays);
		}
		else {
			// C'est le rôle des services de lever des exceptions maison
			throw new PaysInexistantException("Pays inexistant");
		}
	}

	@Override
	public Pays recupererPays(String code) {
		return paysDao.findByCode(code);
	}

	@Override
	public Pays enregistrerPays(Pays pays) {
		return paysDao.save(pays);
	}

	@Override
	public boolean supprimerPays(String code) {
		Pays pays = recupererPays(code);
		if (pays!=null) {
			paysDao.delete(pays);
			return true;
		}
		return false;
	}

	@Override
	public Pays enregistrerPays(PaysDto paysDto) {
		return paysDao.save(paysMapper.toEntity(paysDto));
	}

}
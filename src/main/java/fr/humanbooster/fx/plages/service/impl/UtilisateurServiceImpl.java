package fr.humanbooster.fx.plages.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.humanbooster.fx.plages.business.Utilisateur;
import fr.humanbooster.fx.plages.dao.UtilisateurDao;
import fr.humanbooster.fx.plages.service.UtilisateurService;
import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class UtilisateurServiceImpl implements UtilisateurService {

	private final UtilisateurDao utilisateurDao;
	
	@Override
	@Transactional(readOnly=true)
	public Utilisateur recupererUtilisateur(String email, String motDePasse) {
		return utilisateurDao.findLastByEmailAndMotDePasse(email, motDePasse);
	}

	@Override
	public Utilisateur recupererUtilisateur(Long idUtilisateur) {
		return utilisateurDao.findById(idUtilisateur).orElse(null);
	}


}

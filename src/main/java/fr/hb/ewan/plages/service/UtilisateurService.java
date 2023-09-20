package fr.hb.ewan.plages.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import fr.hb.ewan.plages.business.Utilisateur;

public interface UtilisateurService {

	Utilisateur recupererUtilisateur(String email, String motDePasse);

	Utilisateur recupererUtilisateur(Long idUtilisateur);

	Utilisateur recupererUtilisateur(String email);
}

package fr.hb.ewan.plages.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.hb.ewan.plages.business.Utilisateur;

public interface UtilisateurDao extends JpaRepository<Utilisateur, Long> {

	boolean existsByEmail(String email);

	Utilisateur findLastByEmailAndMotDePasse(String email, String motDePasse);
	
	Utilisateur findByEmail(String email);
}

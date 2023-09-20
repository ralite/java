package fr.hb.ewan.plages.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.hb.ewan.plages.business.LienDeParente;

public interface LienDeParenteDao extends JpaRepository<LienDeParente, Long> {

	// Query-method
	// Requête par dérivation
	LienDeParente findByNom(String nom);

}

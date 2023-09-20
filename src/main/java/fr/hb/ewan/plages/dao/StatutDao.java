package fr.hb.ewan.plages.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.hb.ewan.plages.business.Statut;

public interface StatutDao extends JpaRepository<Statut, Long> {

	Statut findByNom(String nom);

}

package fr.hb.ewan.plages.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.hb.ewan.plages.business.Concessionnaire;

public interface ConcessionnaireDao extends JpaRepository<Concessionnaire, Long> {

}

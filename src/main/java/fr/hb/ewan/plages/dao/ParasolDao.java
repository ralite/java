package fr.hb.ewan.plages.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.hb.ewan.plages.business.File;
import fr.hb.ewan.plages.business.Parasol;

public interface ParasolDao extends JpaRepository<Parasol, Long> {

	@Query("""
			FROM Parasol
			WHERE file=:file
			""")
	List<Parasol> findByFile(File file);

	// Query method : requête par dérivation
	Page<Parasol> findByFileId(Pageable pageable, Long idFile);

	// Query method : requête par dérivation
	List<Parasol> findByNumEmplacementLessThan(byte i);
	
}

package fr.hb.ewan.plages.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.hb.ewan.plages.business.LienDeParente;
import fr.hb.ewan.plages.dao.LienDeParenteDao;
import fr.hb.ewan.plages.dto.LienDeParenteDto;
import fr.hb.ewan.plages.exception.PaysExistantException;
import fr.hb.ewan.plages.mapper.LienDeParenteMapper;
import fr.hb.ewan.plages.service.LienDeParenteService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LienDeParenteServiceImpl implements LienDeParenteService {

	private LienDeParenteDao lienDeParenteDao;
	private LienDeParenteMapper lienDeParenteMapper;
	
	@Override
	public List<LienDeParente> recupererLiensDeParente() {
		return lienDeParenteDao.findAll();
	}

	@Override
	public LienDeParente recupererLienDeParente(Long id) {
		return lienDeParenteDao.findById(id).orElse(null);
	}

	@Override
	public LienDeParente ajouterLienDeParente(String nom, float coefficient) {
		if (lienDeParenteDao.findByNom(nom)==null) {
			return lienDeParenteDao.save(new LienDeParente(nom, coefficient));			
		}
		else {
			throw new PaysExistantException("Ce pays existe déjà");
		}
	}
	
	@Override
	public boolean supprimerLienDeParente(String nom) {
		LienDeParente lienDeParente = lienDeParenteDao.findByNom(nom);
		if (lienDeParente!=null) {
			lienDeParenteDao.delete(lienDeParente);
			return true;
		}
		return false;
	}
	
	@Override
    public LienDeParente enregistrerLienDeParente(LienDeParente lienDeParente) {
        return lienDeParenteDao.save(lienDeParente);
    }
	
	@Override
	public LienDeParente mettreAJourNom(String ancienNom, String nouveauNom) {
		LienDeParente lienDeParente = lienDeParenteDao.findByNom(ancienNom);
		if (lienDeParente != null) {
			lienDeParente.setNom(nouveauNom);
			return lienDeParenteDao.save(lienDeParente);
		}
		else {
			return null;
		}
	}

	@Override
	public LienDeParente mettreAJourCoeff(String nom,float nouveauCoeff) {
		LienDeParente lienDeParente = lienDeParenteDao.findByNom(nom);
		if (lienDeParente != null) {
			lienDeParente.setCoefficient(nouveauCoeff);
			return lienDeParenteDao.save(lienDeParente);
		}
		else {
			return null;
		}
	}
	
	@Override
	public LienDeParente enregistrerLienDeParente(LienDeParenteDto lienDeParenteDto) {
		return lienDeParenteDao.save(lienDeParenteMapper.toEntity(lienDeParenteDto));
	}
	
}

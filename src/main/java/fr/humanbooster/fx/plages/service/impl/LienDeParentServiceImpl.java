package fr.humanbooster.fx.plages.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.humanbooster.fx.plages.business.LienDeParente;
import fr.humanbooster.fx.plages.dao.LienDeParenteDao;
import fr.humanbooster.fx.plages.service.LienDeParenteService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LienDeParentServiceImpl implements LienDeParenteService {

	private LienDeParenteDao lienDeParenteDao;
	
	@Override
	public List<LienDeParente> recupererLiensDeParente() {
		return lienDeParenteDao.findAll();
	}

	@Override
	public LienDeParente recupererLienDeParente(Long id) {
		return lienDeParenteDao.findById(id).orElse(null);
	}

}

package fr.hb.ewan.plages.service;

import java.util.List;

import fr.hb.ewan.plages.business.LienDeParente;
import fr.hb.ewan.plages.business.Pays;
import fr.hb.ewan.plages.dto.LienDeParenteDto;

public interface LienDeParenteService {

	LienDeParente ajouterLienDeParente(String nom, float coefficient);
	
	List<LienDeParente> recupererLiensDeParente();

	LienDeParente recupererLienDeParente(Long id);
	
	boolean supprimerLienDeParente(String nom);
	
	LienDeParente enregistrerLienDeParente(LienDeParente lienDeParente);
	public LienDeParente enregistrerLienDeParente(LienDeParenteDto lienDeParenteDto);
	
	LienDeParente mettreAJourNom(String ancienNom, String nouveauNom);
	public LienDeParente mettreAJourCoeff(String nom,float nouveauCoeff);
	
	

}
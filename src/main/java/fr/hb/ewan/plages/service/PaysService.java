package fr.hb.ewan.plages.service;

import java.util.List;

import fr.hb.ewan.plages.business.Pays;
import fr.hb.ewan.plages.dto.PaysDto;

public interface PaysService {

	List<Pays> recupererPays();

	Pays ajouterPays(String code, String nom);

	Pays mettreAJour(String code, String nouveauNom);

	Pays recupererPays(String code);

	Pays enregistrerPays(Pays pays);

	boolean supprimerPays(String code);

	Pays enregistrerPays(PaysDto paysDto);

}
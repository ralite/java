package fr.humanbooster.fx.plages.service;

import java.util.List;

import fr.humanbooster.fx.plages.business.Pays;

public interface PaysService {

	List<Pays> recupererPays();

	Pays ajouterPays(String code, String nom);

	Pays mettreAJour(String code, String nouveauNom);

	Pays recupererPays(String code);

	Pays enregistrerPays(Pays pays);

	boolean supprimerPays(String code);

}
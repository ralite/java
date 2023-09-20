package fr.hb.ewan.plages.controller.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.hb.ewan.plages.business.Client;
import fr.hb.ewan.plages.business.LienDeParente;
import fr.hb.ewan.plages.dto.LienDeParenteDto;
import fr.hb.ewan.plages.service.ClientService;
import fr.hb.ewan.plages.service.LienDeParenteService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("api/") // L'API des liens de parenté sera isolée sur une URL qui débute par api/
public class LienDeParenteRestController {
	private LienDeParenteService lienDeParenteService;
	private ClientService clientService;

	/**
	 * Cette méthode renvoie la liste des pays au format Json
	 * 
	 * @return
	 */
	@GetMapping("lienDeParente/")
	public List<LienDeParente> getLiensDeParente() {
		return lienDeParenteService.recupererLiensDeParente();
	}

	@GetMapping("liendeparente/{id}")
	public LienDeParente getLienDeParente(@PathVariable Long id) {
		return lienDeParenteService.recupererLienDeParente(id);
	}

	@GetMapping("lienDeParente/{id}/clients")
	public List<Client> getClientWithLienDeParente(@PathVariable Long id) {
		LienDeParente lienDeParente = lienDeParenteService.recupererLienDeParente(id);
		return clientService.recupererClientsParLienDeParente(lienDeParente);
	}

	@PostMapping("lienDeParente")
	@ResponseStatus(code = HttpStatus.CREATED)
	public LienDeParente postLienDeParente(@RequestBody LienDeParenteDto lienDeParenteDto) {
		return lienDeParenteService.enregistrerLienDeParente(lienDeParenteDto);
	}

	/*
	@PostMapping("lienDeParente/{nom}/{coefficient}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public LienDeParente postLienDeParente(@PathVariable String nom, @PathVariable String coefficient) {
		return lienDeParenteService.ajouterLienDeParente(nom, Float.parseFloat(coefficient));
	}
	*/
	
	@Operation(description = "Supprime un lien de parenté")
	@DeleteMapping("lienDeParente/{nom}")
	public boolean supprimerLienDeParente(@PathVariable String nom) {
		return lienDeParenteService.supprimerLienDeParente(nom);
	}

	@PatchMapping("lienDeParente/patch/{id}")
    public LienDeParente patchLienDeParente(@PathVariable Long id, @RequestBody LienDeParenteDto lienDeParenteDto) {
        LienDeParente lienDeParente = lienDeParenteService.recupererLienDeParente(id);
        lienDeParente.setNom(lienDeParenteDto.getNom());
        lienDeParente.setCoefficient(lienDeParenteDto.getCoefficient());
        return lienDeParenteService.enregistrerLienDeParente(lienDeParente);
    }
	
	/*
	@PatchMapping("lienDeParente/patch/{id}/{nouveauNom}")
	public LienDeParente patchLienDeParente(@PathVariable Long id, @PathVariable String nouveauNom) {
		LienDeParente lienDeParente = lienDeParenteService.recupererLienDeParente(id);
		lienDeParente.setNom(nouveauNom);
		return lienDeParenteService.enregistrerLienDeParente(lienDeParente);
	}
	*/

	@PutMapping("lienDeParente/put/{id}")
    public LienDeParente putLienDeParente(@PathVariable Long id, @RequestBody LienDeParenteDto lienDeParenteDto) {
        LienDeParente lienDeParente = lienDeParenteService.recupererLienDeParente(id);
        lienDeParente.setNom(lienDeParenteDto.getNom());
        lienDeParente.setCoefficient(lienDeParenteDto.getCoefficient());
        return lienDeParenteService.enregistrerLienDeParente(lienDeParente);
    }
	
	/*
	@PutMapping("lienDeParente/put/{id}")
	public LienDeParente putLienDeParente(@PathVariable Long id, @RequestBody LienDeParenteDto lienDeParenteDto,
			@PathVariable float nouveauCoefficient) {
		LienDeParente lienDeParente = lienDeParenteService.recupererLienDeParente(id);
		lienDeParente.setNom(nouveauNom);
		lienDeParente.setCoefficient(nouveauCoefficient);
		return lienDeParenteService.enregistrerLienDeParente(lienDeParente);
	}
	*/
	
	/*
	@PutMapping("liendeparente/put/{id}/{nouveauNom}/{nouveauCoefficient}")
	public LienDeParente putLienDeParente(@PathVariable Long id, @PathVariable String nouveauNom,
			@PathVariable float nouveauCoefficient) {
		LienDeParente lienDeParente = lienDeParenteService.recupererLienDeParente(id);
		lienDeParente.setNom(nouveauNom);
		lienDeParente.setCoefficient(nouveauCoefficient);
		return lienDeParenteService.enregistrerLienDeParente(lienDeParente);
	}
    */
	
}

package fr.hb.ewan.plages.controller.rest;

import java.util.List;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
import fr.hb.ewan.plages.business.Pays;
import fr.hb.ewan.plages.dto.PaysDto;
import fr.hb.ewan.plages.exception.PaysExistantException;
import fr.hb.ewan.plages.service.ClientService;
import fr.hb.ewan.plages.service.PaysService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("api/") // L'API des pays sera isolée sur une URL qui débute par api/
public class PaysRestController {

	// Dépendance(s)
	private PaysService paysService;
	private ClientService clientService;

	/**
	 * Cette méthode renvoie la liste des pays au format Json
	 * 
	 * @return
	 */
	@GetMapping("pays")
	public List<Pays> getPays() {
		return paysService.recupererPays();
	}

	@GetMapping("pays/{code}/clients")
	public List<Client> getClientsParPays(@PathVariable String code) {
		Pays pays = paysService.recupererPays(code);
		return clientService.recupererClientsParPays(pays);
	}

	@ExceptionHandler(PaysExistantException.class)
	@ResponseStatus(code = HttpStatus.CONFLICT)
	public String traiterPaysExistantException(PaysExistantException e) {
	    Throwable f = e.getCause();
		return f.getMessage();
	}
	
	
	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY)
	public String traiterConstraintValidationException(ConstraintViolationException e) {
		 String erreur = "";
	        for(ConstraintViolation<?> constraint : e.getConstraintViolations()) {
	            erreur += constraint.getMessage() + "; ";
	        }
	        return erreur;
	}
	

	@PostMapping("pays")
    @ResponseStatus(code = HttpStatus.CREATED)
    // https://sonarsource.atlassian.net/browse/RSPEC-4684
    public Pays postPays(@RequestBody PaysDto paysDto) {
        return paysService.enregistrerPays(paysDto);
    }

	
	@PostMapping("pays/{code}/{nom}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Pays postPays(@PathVariable String code, @PathVariable String nom) throws PaysExistantException {
		return paysService.ajouterPays(code, nom);
	}

	@Operation(description = "Supprime un pays")
	@DeleteMapping("pays/{code}")
	public boolean supprimerPays(@PathVariable String code) {
		return paysService.supprimerPays(code);
	}

	@PatchMapping("pays/{code}/{nouveauNom}")
	public Pays editerPays(@PathVariable String code, @PathVariable String nouveauNom) {
		return paysService.mettreAJour(code, nouveauNom);

	}
	/*
	 * @PutMapping("pays/put/{ancienCode}/{nouveauCode}/{nouveauNom}") public Pays
	 * putPays(@PathVariable String ancienCode, @PathVariable String
	 * nouveauCode, @PathVariable String nouveauNom) { Pays pays =
	 * paysService.recupererPays(ancienCode); pays.setCode(nouveauCode);
	 * pays.setNom(nouveauNom); return paysService.enregistrerPays(pays); }
	 */

	@PutMapping("pays/{code}")
	// https://sonarsource.atlassian.net/browse/RSPEC-4684
	public Pays putPays(@PathVariable String code, @RequestBody Pays pays) {
		return paysService.enregistrerPays(pays);
	}

}
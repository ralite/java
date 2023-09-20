package fr.hb.ewan.plages.controller.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.hb.ewan.plages.business.Client;
import fr.hb.ewan.plages.dto.ClientDto;
import fr.hb.ewan.plages.service.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("api/") // L'API des clients sera isolée sur une URL qui débute par api/
@Validated
public class ClientRestController {
	   // Dépendance(s)
		private ClientService clientService;

		@GetMapping("clients")
		public List<Client> getClients() {
			return clientService.recupererClients();
		}
		
		@Operation(description = "Supprime un client")
		@DeleteMapping("client/{id}")
		public boolean supprimerPays(@PathVariable Long id) {
			return clientService.supprimerClient(id);
		}
		
		@PostMapping("client/")
		@ResponseStatus(code = HttpStatus.CREATED)
		public Client postClient(@RequestBody ClientDto clientDto) {
			return clientService.enregistrerClient(clientDto);
		}
		
		
}

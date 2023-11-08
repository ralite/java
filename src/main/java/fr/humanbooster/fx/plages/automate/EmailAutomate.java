package fr.humanbooster.fx.plages.automate;

import org.springframework.context.annotation.DependsOn;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import fr.humanbooster.fx.plages.initialisation.AjoutDonneesInitiales;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
@DependsOn("ajoutDonneesInitiales")
public class EmailAutomate {
	
	private AjoutDonneesInitiales ajoutDonneesInitiales;
	
	@Scheduled(cron = "* * * * * *")
	private void envoyerMails() {
		System.out.println("Ajout Client");
		ajoutDonneesInitiales.ajouterClientsSansCondition(1);
	}
}

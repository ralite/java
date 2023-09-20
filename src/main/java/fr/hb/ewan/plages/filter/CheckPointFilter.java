package fr.hb.ewan.plages.filter;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.core.annotation.Order;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import fr.hb.ewan.plages.business.Utilisateur;
import fr.hb.ewan.plages.service.UtilisateurService;
import lombok.AllArgsConstructor;

@Component
@Order(1) // Premier filtre à exécuter lorsque le serveur reçoit une requête HTTP
@AllArgsConstructor
public class CheckPointFilter implements Filter {

	private UtilisateurService utilisateurService;
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// On enrichit l'objet request avec un nouvel attribut msDepart
		Date date = new Date();
		System.out.println(date + " passage dans CheckPointFilter");
		((HttpServletRequest) request).setAttribute("msDepart", date.getTime());
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		
		if(!authentication.getPrincipal().equals("anonymousUser")) {
			User user = (User) authentication.getPrincipal();
			Utilisateur utilisateur = utilisateurService.recupererUtilisateur(user.getUsername());
			request.setAttribute("utilisateur", utilisateur);
		}
		// On passe la main
		chain.doFilter(request, response);

	}

}

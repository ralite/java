package fr.hb.ewan.plages.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.hb.ewan.plages.business.Utilisateur;
import fr.hb.ewan.plages.dao.UtilisateurDao;
import fr.hb.ewan.plages.service.UtilisateurService;
import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class UtilisateurServiceImpl implements UtilisateurService, UserDetailsService {

	private final UtilisateurDao utilisateurDao;

	@Override
	@Transactional(readOnly = true)
	public Utilisateur recupererUtilisateur(String email, String motDePasse) {
		return utilisateurDao.findLastByEmailAndMotDePasse(email, motDePasse);
	}

	@Override
	public Utilisateur recupererUtilisateur(Long idUtilisateur) {
		return utilisateurDao.findById(idUtilisateur).orElse(null);
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Utilisateur utilisateur = utilisateurDao.findByEmail(email);

		List<GrantedAuthority> roles = new ArrayList<>();

		if (utilisateur.getClass().getSimpleName().equals("Concessionnaire")) {
			roles.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		} else {
			roles.add(new SimpleGrantedAuthority("ROLE_USER"));
		}

		// return
		// User.builder().username(utilisateur.getEmail()).password(utilisateur.getMotDePasse()).roles(roles).build();
		return new User(utilisateur.getEmail(), utilisateur.getMotDePasse(), roles);
	}

	@Override
	public Utilisateur recupererUtilisateur(String email) {
		return utilisateurDao.findByEmail(email);
	}

}

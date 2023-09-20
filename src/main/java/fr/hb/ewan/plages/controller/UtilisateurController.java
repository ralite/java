package fr.hb.ewan.plages.controller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import fr.hb.ewan.plages.service.UtilisateurService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@AllArgsConstructor
@Log4j2
public class UtilisateurController {

	private final UtilisateurService utilisateurService;
	private final HttpSession httpSession;
	
	protected static final String DOSSIER_IMAGES = "src/main/webapp/images/";
	
	
	
	@GetMapping(value = { "/", "index"})
    public ModelAndView getConnexion() {        
        log.warn(new Date() + " dans getConnexion()");
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");     
        return mav;
    }
	
	
	
	@GetMapping("televerserAvatar")
	public ModelAndView getAvatarUtilisateur(@RequestParam(name="ID_UTILISATEUR") Long idUtilisateur) {
		ModelAndView mav = new ModelAndView("televersementAvatar");
		mav.addObject("utilisateur", utilisateurService.recupererUtilisateur(idUtilisateur));
		return mav;
	}
	
	@PostMapping("televersementAvatar")
	public ModelAndView postAvatarUtilisateur(
			@RequestParam("FICHIER") MultipartFile fichier, 
			@RequestParam(name="ID_UTILISATEUR") Long idUtilisateur) {
		try {
			enregisterFichier(idUtilisateur + ".jpg", fichier);
		} catch (IOException e) {
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("redirect:clients");
        mav.addObject("message","avatar correctement ajoute");
        return mav;
	}
	
	@GetMapping("deconnexion")
	public ModelAndView getDeconnexion() {
		httpSession.invalidate();
		ModelAndView mav = new ModelAndView("redirect:/index");
		mav.addObject("notification", "Au revoir");
		return mav;
	}
	
	protected static void enregisterFichier(String nom, MultipartFile multipartFile) throws IOException {
		Path chemin = Paths.get(DOSSIER_IMAGES);

		if (!Files.exists(chemin)) {
			Files.createDirectories(chemin);
		}

		try (InputStream inputStream = multipartFile.getInputStream()) {
			Path cheminFichier = chemin.resolve(nom);
			Files.copy(inputStream, cheminFichier, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException ioe) {
			throw new IOException("Erreur d'écriture : " + nom, ioe);
		}
	}
}

package fr.hb.ewan.plages.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc // On demande à Spring de créer et de configurer un objet
// qui va imiter ce que fait le navigateur Internet
// @TestMethodOrder(MethodOrderer.OrderAnnotation.class) // A évoquer ce jour
public class ClientControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	@WithMockUser(roles = "ADMIN")
	void testerPostAvatar() throws Exception {
		// MockMultipartFile mf1 = new MockMultipartFile("FICHIER", "1.png", "multipart/form-data",
		//		new FileInputStream(new File("C:\\Users\\Adnane HumanBooster\\Downloads\\79748_account_msn_icon.png")));
		
		MockMultipartFile mf1 = new MockMultipartFile(
                "FICHIER",
                "avatar.jpg",
                MediaType.IMAGE_JPEG_VALUE,
                new byte[18]
        );
		
		mockMvc.perform(MockMvcRequestBuilders.multipart("/televersementAvatar").
				file(mf1).
				param("ID_UTILISATEUR", "1"))
		        .andExpect(status().isFound())
				.andExpect(MockMvcResultMatchers.redirectedUrl("clients"))
				//.andExpect(MockMvcResultMatchers.model().attribute("message","avatar correctement ajouter")) dans un context de non redirection
                .andExpect(MockMvcResultMatchers.redirectedUrl("clients?message=avatar+correctement+ajoute"))
				.andDo(MockMvcResultHandlers.print());
	}

	@Test
	@WithMockUser(roles = "USER")
	void testerConnexionInterditePourClient() throws Exception {

		// La méthode remplit le champ username, le champ password et clique sur le
		// bouton de connexion
		mockMvc.perform(MockMvcRequestBuilders.get("/clients"))
				// .andExpect(forwardedUrl("/WEB-INF/erreur.jsp"))

				.andExpect(status().isForbidden());
	}
}

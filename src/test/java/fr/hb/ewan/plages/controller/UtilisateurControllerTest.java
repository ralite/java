package fr.hb.ewan.plages.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
// import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc // On demande à Spring de créer et de configurer un objet
// qui va imiter ce que fait le navigateur Internet
@TestMethodOrder(MethodOrderer.OrderAnnotation.class) // A évoquer ce jour
//@WithMockUser(roles = "USER")
class UtilisateurControllerTest {

    @Autowired
    private MockMvc mockMvc;
    
    @Test
    void testerAccueil() throws Exception {
    
        // On prépare une requête en HTTP en indiquant la méthode (ds l'ex : get) puis en paramètre l'url
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/");

        mockMvc.perform(requestBuilder)
            .andExpect(view().name("index"))
            .andExpect(status().isOk());
    }
    
    @Test
    void testerConnexionPeppeAvecSucces() throws Exception {
    
        // La méthode remplit le champ username, le champ password et clique sur le bouton de connexion
        mockMvc.perform(MockMvcRequestBuilders.post("/login")
            .accept(MediaType.TEXT_HTML)
            .param("username", "peppe@humanbooster.fr")
            .param("password", "12345678"))
            .andExpect(MockMvcResultMatchers.redirectedUrl("clients"))
            .andExpect(status().isFound());
    }

    @Test
    void testerConnexionPeppeAvecEchec() throws Exception {
    
        mockMvc.perform(MockMvcRequestBuilders.post("/login")
            .accept(MediaType.TEXT_HTML)
            .param("username", "peppe@humanbooster.fr")
            .param("password", "abcd"))
            .andExpect(MockMvcResultMatchers.redirectedUrl("/index"))
            .andExpect(status().isFound());
    }
    
    @Test
    void testerConnexionMarcelAvecSucces() throws Exception {
    
        // La méthode remplit le champ username, le champ password et clique sur le bouton de connexion
        mockMvc.perform(MockMvcRequestBuilders.post("/login")
            .accept(MediaType.TEXT_HTML)
            .param("username", "marcel.pivot@humanbooster.fr")
            .param("password", "87654321"))
            .andExpect(MockMvcResultMatchers.redirectedUrl("parasols"))
            .andExpect(status().isFound());
    }
    
    @Test
    void testerConnexionMarcelAvecEchec() throws Exception {
    
        // La méthode remplit le champ username, le champ password et clique sur le bouton de connexion
        mockMvc.perform(MockMvcRequestBuilders.post("/login")
            .accept(MediaType.TEXT_HTML)
            .param("username", "marcel.pivot@humanbooster.fr")
            .param("password", "07654320"))
            .andExpect(MockMvcResultMatchers.redirectedUrl("/index"))
            .andExpect(status().isFound());
    }
    
    
}

package fr.hb.ewan.plages.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc // On demande à Spring de créer et de configurer un objet
// qui va imiter ce que fait le navigateur Internet
@TestMethodOrder(MethodOrderer.OrderAnnotation.class) // A évoquer ce jour
//@WithMockUser(roles = "USER")
public class ParasolControllerTest {
	
	@Autowired
    private MockMvc mockMvc;

	@Test
    void testerCreationParasol() throws Exception {
    
       
        mockMvc.perform(MockMvcRequestBuilders.post("/parasol")
            .accept(MediaType.TEXT_HTML)
            .param("numEmplacement", "27")
            .param("file", "3"))
            .andExpect(MockMvcResultMatchers.redirectedUrl("parasols"))
            .andExpect(status().isFound());
    }

	
}

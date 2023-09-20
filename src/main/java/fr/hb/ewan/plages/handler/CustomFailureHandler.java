package fr.hb.ewan.plages.handler;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class CustomFailureHandler implements AuthenticationFailureHandler {
	
	@Override
    public void onAuthenticationFailure(
      HttpServletRequest request,
      HttpServletResponse response,
      AuthenticationException exception) 
      throws IOException, ServletException {
          log.warn("Echec de connexion pour " + request.getParameter("username") + ", mdp " + request.getParameter("password")); 
          response.sendRedirect("/index");
	}		

}

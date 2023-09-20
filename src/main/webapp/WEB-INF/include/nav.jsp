<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<a href="/clients">Clients</a> 
<a href="/parasols">Parasols</a> 
<a href="/reservations">Réservations</a>
<span>Utilisateur connecté : ${utilisateur.prenom} ${utilisateur.nom}  </span>
<a href="/logout">Déconnexion</a>
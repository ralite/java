package fr.hb.ewan.plages.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import fr.hb.ewan.plages.business.Client;
import fr.hb.ewan.plages.business.Concessionnaire;
import fr.hb.ewan.plages.business.Reservation;
import fr.hb.ewan.plages.business.Statut;

public interface ReservationService {

	/**
	 * @param Reservation reservation 
	 * @return
	 */
	Reservation enregistrerReservation(Reservation reservation);

	/**
	 * @param Long id 
	 * @return
	 */
	Reservation recupererReservation(Long id);

	/**
	 * @param Client client 
	 * @return
	 */
	List<Reservation> recupererReservations(Client client);

	/**
	 * @param Pageable pageable 
	 * @return
	 */
	Page<Reservation> recupererReservations(Pageable pageable);

	/**
	 * @param Pageable pageable 
	 * @param Statut statut 
	 * @return
	 */
	Page<Reservation> recupererReservations(Pageable pageable, Statut statut);

	/**
	 * @return
	 */
	List<Reservation> recupererReservations();

	/**
	 * @param Reservation reservation 
	 * @param Concessionnaire concessionnaire 
	 * @return
	 */
	Reservation traiterReservation(Reservation reservation, Concessionnaire concessionnaire);

	List<Reservation> recupererReservationsDeLaSemaineEnCours();

}
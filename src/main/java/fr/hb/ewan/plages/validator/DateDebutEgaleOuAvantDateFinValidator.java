package fr.hb.ewan.plages.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import fr.hb.ewan.plages.annotation.DateDebutEgaleOuAvantDateFin;
import fr.hb.ewan.plages.business.Reservation;

public class DateDebutEgaleOuAvantDateFinValidator implements ConstraintValidator<DateDebutEgaleOuAvantDateFin, Reservation> {

	@Override
	public boolean isValid(Reservation reservation, ConstraintValidatorContext context) {
		return (reservation.getDateDebut().equals(reservation.getDateFin()) || reservation.getDateDebut().isBefore(reservation.getDateFin()));
	}

}
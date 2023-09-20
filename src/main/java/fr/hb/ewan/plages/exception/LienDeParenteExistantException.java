package fr.hb.ewan.plages.exception;

public class LienDeParenteExistantException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public LienDeParenteExistantException(String message) {
		super(message);
	}
}

package fr.projet.evenement.exception;

public class UtilisateurInconnu extends Exception {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public UtilisateurInconnu() {
		super();

	}

	public UtilisateurInconnu(String message, Throwable cause) {
		super(message, cause);
	}

	public UtilisateurInconnu(String message) {
		super(message);
	}

	public UtilisateurInconnu(Throwable cause) {
		super(cause);
	}

}

package fr.projet.evenement.exception;

public class MauvaisMotDePasse extends Exception {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public MauvaisMotDePasse() {
		super();
	}

	public MauvaisMotDePasse(String message, Throwable cause) {
		super(message, cause);
	}

	public MauvaisMotDePasse(String message) {
		super(message);
	}

	public MauvaisMotDePasse(Throwable cause) {
		super(cause);
	}

}

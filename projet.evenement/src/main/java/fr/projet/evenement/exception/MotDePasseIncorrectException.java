package fr.projet.evenement.exception;

/**
 * Erreur d'authentification.
 */
public class MotDePasseIncorrectException extends ErreurAuthentificationException {
	private static final long serialVersionUID = 1L;

	/**
	 * Constructeur de l'objet.
	 */
	public MotDePasseIncorrectException() {
		super();
	}

	/**
	 * Constructeur de l'objet.
	 *
	 * @param pMessage
	 */
	public MotDePasseIncorrectException(String pMessage) {
		super(pMessage);
	}

	/**
	 * Constructeur de l'objet.
	 *
	 * @param pCause
	 */
	public MotDePasseIncorrectException(Throwable pCause) {
		super(pCause);
	}

	/**
	 * Constructeur de l'objet.
	 *
	 * @param pMessage
	 * @param pCause
	 */
	public MotDePasseIncorrectException(String pMessage, Throwable pCause) {
		super(pMessage, pCause);
	}
}
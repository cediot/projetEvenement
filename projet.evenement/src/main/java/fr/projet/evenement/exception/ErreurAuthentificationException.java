package fr.projet.evenement.exception;

/**
 * Erreur d'authentification.
 */
public class ErreurAuthentificationException extends ErreurFonctionnelleException {
	private static final long serialVersionUID = 1L;

	/**
	 * Constructeur de l'objet.
	 */
	public ErreurAuthentificationException() {
		super();
	}

	/**
	 * Constructeur de l'objet.
	 *
	 * @param pMessage
	 */
	public ErreurAuthentificationException(String pMessage) {
		super(pMessage);
	}

	/**
	 * Constructeur de l'objet.
	 *
	 * @param pCause
	 */
	public ErreurAuthentificationException(Throwable pCause) {
		super(pCause);
	}

	/**
	 * Constructeur de l'objet.
	 *
	 * @param pMessage
	 * @param pCause
	 */
	public ErreurAuthentificationException(String pMessage, Throwable pCause) {
		super(pMessage, pCause);
	}
}
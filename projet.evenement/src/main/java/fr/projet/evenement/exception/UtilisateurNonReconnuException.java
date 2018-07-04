package fr.projet.evenement.exception;

/**
 * Erreur d'authentification.
 */
public class UtilisateurNonReconnuException extends ErreurAuthentificationException {
	private static final long serialVersionUID = 1L;

	/**
	 * Constructeur de l'objet.
	 */
	public UtilisateurNonReconnuException() {
		super();
	}

	/**
	 * Constructeur de l'objet.
	 *
	 * @param pMessage
	 */
	public UtilisateurNonReconnuException(String pMessage) {
		super(pMessage);
	}

	/**
	 * Constructeur de l'objet.
	 *
	 * @param pCause
	 */
	public UtilisateurNonReconnuException(Throwable pCause) {
		super(pCause);
	}

	/**
	 * Constructeur de l'objet.
	 *
	 * @param pMessage
	 * @param pCause
	 */
	public UtilisateurNonReconnuException(String pMessage, Throwable pCause) {
		super(pMessage, pCause);
	}
}
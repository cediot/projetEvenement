package fr.projet.evenement.exception;

/**
 * Erreur de creation d evenement.
 */
public class EvenemenetNonReconnuException extends Exception {
	private static final long serialVersionUID = 1L;

	/**
	 * Constructeur de l'objet.
	 */
	public EvenemenetNonReconnuException() {
		super();
	}

	/**
	 * Constructeur de l'objet.
	 *
	 * @param pMessage
	 */
	public EvenemenetNonReconnuException(String pMessage) {
		super(pMessage);
	}

	/**
	 * Constructeur de l'objet.
	 *
	 * @param pCause
	 */
	public EvenemenetNonReconnuException(Throwable pCause) {
		super(pCause);
	}

	/**
	 * Constructeur de l'objet.
	 *
	 * @param pMessage
	 * @param pCause
	 */
	public EvenemenetNonReconnuException(String pMessage, Throwable pCause) {
		super(pMessage, pCause);
	}
}
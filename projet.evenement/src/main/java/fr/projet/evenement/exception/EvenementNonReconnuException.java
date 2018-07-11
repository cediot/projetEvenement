package fr.projet.evenement.exception;

/**
 * Erreur de creation d evenement.
 */
public class EvenementNonReconnuException extends Exception {
	private static final long serialVersionUID = 1L;

	/**
	 * Constructeur de l'objet.
	 */
	public EvenementNonReconnuException() {
		super();
	}

	/**
	 * Constructeur de l'objet.
	 *
	 * @param pMessage
	 */
	public EvenementNonReconnuException(String pMessage) {
		super(pMessage);
	}

	/**
	 * Constructeur de l'objet.
	 *
	 * @param pCause
	 */
	public EvenementNonReconnuException(Throwable pCause) {
		super(pCause);
	}

	/**
	 * Constructeur de l'objet.
	 *
	 * @param pMessage
	 * @param pCause
	 */
	public EvenementNonReconnuException(String pMessage, Throwable pCause) {
		super(pMessage, pCause);
	}
}
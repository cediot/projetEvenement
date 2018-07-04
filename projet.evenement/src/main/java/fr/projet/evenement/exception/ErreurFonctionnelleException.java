package fr.projet.evenement.exception;

/**
 * Erreur fontionnelle.
 */
public class ErreurFonctionnelleException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructeur de l'objet.
	 */
	public ErreurFonctionnelleException() {
		super();
	}

	/**
	 * Constructeur de l'objet.
	 *
	 * @param pMessage
	 */
	public ErreurFonctionnelleException(String pMessage) {
		super(pMessage);
	}

	/**
	 * Constructeur de l'objet.
	 *
	 * @param pCause
	 */
	public ErreurFonctionnelleException(Throwable pCause) {
		super(pCause);
	}

	/**
	 * Constructeur de l'objet.
	 *
	 * @param pMessage
	 * @param pCause
	 */
	public ErreurFonctionnelleException(String pMessage, Throwable pCause) {
		super(pMessage, pCause);
	}

}

package fr.projet.evenement.exception;

/**
 * Erreur sur une entite introuvable.
 */
public class EntiteIntrouvableException extends ErreurFonctionnelleException {
	private static final long serialVersionUID = 1L;

	/**
	 * Constructeur de l'objet.
	 */
	public EntiteIntrouvableException() {
		super();
	}

	/**
	 * Constructeur de l'objet.
	 *
	 * @param pMessage
	 */
	public EntiteIntrouvableException(String pMessage) {
		super(pMessage);
	}

	/**
	 * Constructeur de l'objet.
	 *
	 * @param pCause
	 */
	public EntiteIntrouvableException(Throwable pCause) {
		super(pCause);
	}

	/**
	 * Constructeur de l'objet.
	 *
	 * @param pMessage
	 * @param pCause
	 */
	public EntiteIntrouvableException(String pMessage, Throwable pCause) {
		super(pMessage, pCause);
	}
}
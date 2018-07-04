package fr.projet.evenement.json;

public class EvenementUtilisateurJson {

	private int idUtilisateur;
	private boolean evenementValider;
	private boolean evenementParticiper;
	private boolean evenementCreateur;

	public int getIdUtilisateur() {
		return this.idUtilisateur;
	}

	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public boolean isEvenementValider() {
		return this.evenementValider;
	}

	public void setEvenementValider(boolean evenementValider) {
		this.evenementValider = evenementValider;
	}

	public boolean isEvenementParticiper() {
		return this.evenementParticiper;
	}

	public void setEvenementParticiper(boolean evenementParticiper) {
		this.evenementParticiper = evenementParticiper;
	}

	public boolean isEvenementCreateur() {
		return this.evenementCreateur;
	}

	public void setEvenementCreateur(boolean evenementCreateur) {
		this.evenementCreateur = evenementCreateur;
	}

}

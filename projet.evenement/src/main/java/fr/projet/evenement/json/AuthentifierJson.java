package fr.projet.evenement.json;

/**
 * Le json devra etre : <br/>
 * {"email":"toto@oll.com", "pwd":"tata"}
 *
 */
public class AuthentifierJson {

	private String email;
	private String pwd;

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AuthentifierJson [email=");
		builder.append(this.email);
		builder.append(", pwd=");
		builder.append(this.pwd);
		builder.append("]");
		return builder.toString();
	}

}

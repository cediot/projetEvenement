package fr.projet.evenement.json;

public class ExceptionJson {
	private String message;
	private String type;

	public ExceptionJson() {
		super();
	}

	public ExceptionJson(Exception e) {
		super();
		this.setMessage(e.getMessage());
		this.setType(e.getClass().getSimpleName());
	}

	public ExceptionJson(String message, String type) {
		super();
		this.message = message;
		this.type = type;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ExceptionJson [message=");
		builder.append(this.message);
		builder.append(", type=");
		builder.append(this.type);
		builder.append("]");
		return builder.toString();
	}

}

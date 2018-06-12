package fr.projet_Evenement.lib;

public class User {
	private int age;
	private String LastName;
	private String firstName;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	@Override
	public String toString() {
		return "User [age=" + age + ", LastName=" + LastName + ", firstName=" + firstName + "]";
	}
	
	
}

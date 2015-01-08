package data;

public class User {
	public static final String ATTRIBUTE_NAME = "user";
	private String username;
	private String hashedPassword;
	private String firstName;
	private String lastName;
	
	public User (String username, String hashedPassword, String firstName, String lastName) {
		this.username = username;
		this.hashedPassword = hashedPassword;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getHashedPassword() {
		return hashedPassword;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("Username: " + username + "; ");
		result.append("HashedPassword: " + hashedPassword + "; ");
		result.append("FirstName: " + firstName + "; ");
		result.append("LastName: " + lastName + "; ");
		return result.toString();
	}
	
}










package models;

public class UserModel {

	private int id;
	private String firstName, lastName, login, password, role;
	
	public UserModel(int id, String firstName, String lastName, String login, String role, String password) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.login = login;
		this.password = password;
		this.role=role;
	}
	
	public UserModel() {
		super();
	}

	public UserModel(String firstName, String lastName, String login,String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.login = login;
		this.password = password;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

	
	
	
}

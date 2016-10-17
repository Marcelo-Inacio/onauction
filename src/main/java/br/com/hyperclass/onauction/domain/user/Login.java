package br.com.hyperclass.onauction.domain.user;

public class Login {
	
	private String username;
	private String password;
	
	public Login(final String username, final String password) {
		this.username = username;
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
}

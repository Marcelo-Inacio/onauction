package br.com.hyperclass.onauction.restapi.wrapper;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import br.com.hyperclass.onauction.restapi.serializer.LoginDeserializer;

@JsonDeserialize(using = LoginDeserializer.class)
public class LoginWrapper {
	
	private String username;
	private String password;
	
	public LoginWrapper(final String username, final String password) {
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

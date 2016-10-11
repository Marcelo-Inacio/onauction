package br.com.hyperclass.onauction.user;

import java.io.Serializable;

public abstract class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String name;
	private final ProfileType profile;
	
	protected User(final String name, final ProfileType profile) {
		this.name = name;
		this.profile = profile;
	}
	
	public String getName() {
		return name;
	}
	
	public ProfileType getProfile() {
		return profile;
	}

}

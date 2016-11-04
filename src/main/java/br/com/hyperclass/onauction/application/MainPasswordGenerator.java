package br.com.hyperclass.onauction.application;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class MainPasswordGenerator {
	
	public static void main(String[] args) {
		final BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder(5);
		final String hash = bcrypt.encode("admin");
		System.out.println(hash);
	}

}

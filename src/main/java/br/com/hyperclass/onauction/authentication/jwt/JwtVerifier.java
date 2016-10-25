package br.com.hyperclass.onauction.authentication.jwt;

import com.nimbusds.jwt.JWT;

public interface JwtVerifier {
	
	public void verify(final JWT jwt);

}

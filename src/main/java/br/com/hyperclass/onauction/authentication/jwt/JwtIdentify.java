package br.com.hyperclass.onauction.authentication.jwt;

import java.text.ParseException;

import com.nimbusds.jwt.JWT;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.JWTParser;

public class JwtIdentify {
	
	public String identify(final String token) {
		final String tokenUser = String.valueOf(token).substring(6).trim();
		final JWT jwt;
        final JWTClaimsSet claims;

        try {
            jwt = JWTParser.parse(tokenUser);
            claims = jwt.getJWTClaimsSet();
        } catch (final ParseException exception) {
            throw new JwtTokenException("The given JWT could not be parsed.");
        }
        final String profile = (String) claims.getClaim("profile");
        return profile;
	}

}

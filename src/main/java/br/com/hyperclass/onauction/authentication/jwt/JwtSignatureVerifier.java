/*
 * @(#)JwtSignatureVerifier.java 1.0 26/10/2016
 *
 * Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.hyperclass.onauction.authentication.jwt;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWT;
import com.nimbusds.jwt.SignedJWT;

public class JwtSignatureVerifier implements JwtVerifier {
	
	private final JWSVerifier verifier;
	
	public JwtSignatureVerifier(final String secret) throws JOSEException {
        super();
        this.verifier = new MACVerifier(secret);
    }

	@Override
	public void verify(final JWT jwt) {
		final SignedJWT signedJwt = (SignedJWT) jwt;
        try {
            if (!signedJwt.verify(verifier)) {
                throw new JwtTokenException("Invalid signature.");
            }
        } catch (final JOSEException exception) {
            throw new JwtTokenException("The JWT signature could not be verified.");
        }
        
	}

}

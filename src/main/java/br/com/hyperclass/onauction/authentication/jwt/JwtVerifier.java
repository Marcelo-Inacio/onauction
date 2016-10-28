/*
 * @(#)JwtVerifier.java 1.0 26/10/2016
 *
 * Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.hyperclass.onauction.authentication.jwt;

import com.nimbusds.jwt.JWT;

public interface JwtVerifier {
	
	public void verify(final JWT jwt);

}

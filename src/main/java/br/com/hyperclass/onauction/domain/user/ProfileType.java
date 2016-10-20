/*
 * @(#)ProfileType.java 1.0 11/10/2016
 *
 * Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.hyperclass.onauction.domain.user;

import org.springframework.security.core.GrantedAuthority;

public enum ProfileType implements GrantedAuthority {
	
	ADMIN, AUCTIONNER, BUYER;

	@Override
	public String getAuthority() {
		return this.name();
	}

}

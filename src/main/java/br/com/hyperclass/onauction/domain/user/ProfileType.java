/*
 * @(#)ProfileType.java 1.0 11/10/2016
 *
 * Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.hyperclass.onauction.domain.user;
/**
 * O enum <code>ProfileType<code> representa os perfis que os usuários podem assumir no leilão.
 * 
 * @author Marcelo
 *
 */
public enum ProfileType {
	
	ADMIN, AUCTIONEER, BUYER;
	
	public boolean isAdmin() {
		return this.equals(ADMIN);
	}

}

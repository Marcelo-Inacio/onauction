/*
 * @(#)ReferenceDateClaimsVerifier.java 1.0 26/10/2016
 *
 * Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.hyperclass.onauction.domain.batch;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

import br.com.hyperclass.onauction.domain.auction.AuctionException;
/**
 * A clase <code>NoBatchIsOpenException</code> representa a exce��o que
 * n�o h� nehum lote em andamento no leil�o e devolvo um status personalizado
 * dizendo que n�o h� conte�do a ser devolvido.
 * 
 * @author Marcelo
 *
 */
@ResponseStatus(HttpStatus.NO_CONTENT)
public class NoBatchIsOpenException extends AuctionException {

	private static final long serialVersionUID = 1L;
	
	public NoBatchIsOpenException() {
		super();
	}

}

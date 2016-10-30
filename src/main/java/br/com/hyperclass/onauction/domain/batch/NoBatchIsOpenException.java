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
 * A clase <code>NoBatchIsOpenException</code> representa a exceção que
 * não há nehum lote em andamento no leilão e devolvo um status personalizado
 * dizendo que não há conteúdo a ser devolvido.
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

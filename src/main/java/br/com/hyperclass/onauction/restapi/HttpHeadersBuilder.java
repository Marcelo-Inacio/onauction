/*
 * @(#)HttpHeadersBuilder.java 1.0 26/10/2016
 *
 * Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.hyperclass.onauction.restapi;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import java.net.URI;
/**
 * A classe <code>HttpHeadersBuilder<code> tem a função de criar  no header do response
 * a localização do recurso criado.
 * 
 * @author Marcelo
 *
 */
@Component
public class HttpHeadersBuilder extends HttpHeaders {

	private static final long serialVersionUID = 1L;
	
	private static final String DEFAULT_PATH = "/onauction/batch/%d";
	
	public HttpHeadersBuilder() {
		super();
	}
	
	public HttpHeadersBuilder batchId(final int id) {
		setLocation(URI.create(String.format(DEFAULT_PATH, id)));
		return this;
	}
	
	public HttpHeaders build() {
		return this;
	}

}

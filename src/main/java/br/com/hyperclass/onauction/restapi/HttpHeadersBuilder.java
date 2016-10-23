package br.com.hyperclass.onauction.restapi;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import java.net.URI;

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

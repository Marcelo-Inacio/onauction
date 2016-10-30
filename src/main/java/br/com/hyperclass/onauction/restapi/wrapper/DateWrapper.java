/*
 * @(#)DateWrapper.java 1.0 26/10/2016
 *
 * Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.hyperclass.onauction.restapi.wrapper;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import br.com.hyperclass.onauction.restapi.serializer.DateDeserializer;
/**
 * A classe <code>DateWrapper</code> representa um data customizada para o formato brasileiro.
 * 
 * @author Marcelo
 *
 */
@JsonDeserialize(using = DateDeserializer.class)
public class DateWrapper {
	
	private final Date date;
	
	public DateWrapper(final Date date) {
		this.date = date;
	}
	
	public String getDateFormatPtBr() {
		return formatPtBr(date);
	}
	/**
	 * Método que formata um objeto Date para String com o formato de data do Brasil.
	 *  
	 * @param date
	 * @return
	 */
	private String formatPtBr(final Date date) {
		final SimpleDateFormat fmt = new SimpleDateFormat("dd-MM-yyyy");
		return fmt.format(date);
	}

}

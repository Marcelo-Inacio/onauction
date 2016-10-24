package br.com.hyperclass.onauction.restapi.wrapper;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import br.com.hyperclass.onauction.restapi.serializer.DateDeserializer;

@JsonDeserialize(using = DateDeserializer.class)
public class DateWrapper {
	
	private final Date date;
	
	public DateWrapper(final Date date) {
		this.date = date;
	}
	
	public String getDateFormatPtBr() {
		return formatPtBr(date);
	}
	
	private String formatPtBr(final Date date) {
		final SimpleDateFormat fmt = new SimpleDateFormat("dd-MM-yyyy");
		return fmt.format(date);
	}

}

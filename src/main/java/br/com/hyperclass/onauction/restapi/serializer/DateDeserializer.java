package br.com.hyperclass.onauction.restapi.serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import br.com.hyperclass.onauction.restapi.wrapper.DateWrapper;

public class DateDeserializer extends JsonDeserializer<DateWrapper> {

	@Override
	public DateWrapper deserialize(JsonParser arg0, DeserializationContext arg1)
			throws IOException, JsonProcessingException {
		// TODO Auto-generated method stub
		return null;
	}

}

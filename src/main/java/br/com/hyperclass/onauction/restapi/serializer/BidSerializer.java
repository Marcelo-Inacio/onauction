package br.com.hyperclass.onauction.restapi.serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import br.com.hyperclass.onauction.restapi.wrapper.BidWrapper;

public class BidSerializer extends JsonSerializer<BidWrapper> {

	@Override
	public void serialize(final BidWrapper bidWrapper, final JsonGenerator generator, final SerializerProvider arg2)
			throws IOException {

		generator.writeStartObject();
		generator.writeNumberField("value", bidWrapper.getValue());
		generator.writeEndObject();
		
	}

}
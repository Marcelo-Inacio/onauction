package br.com.hyperclass.onauction.restapi.serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import br.com.hyperclass.onauction.restapi.wrapper.BatchWrapper;

public class BatchSerializer extends JsonSerializer<BatchWrapper> {

	@Override
	public void serialize(final BatchWrapper batchWrapper, final JsonGenerator generator, final SerializerProvider arg2)
			throws IOException {
		
		generator.writeStartObject();
		generator.writeNumberField("code", batchWrapper.getCode());
		generator.writeStringField("status", batchWrapper.getStatus());
		generator.writeStringField("product", batchWrapper.getProduct());
		generator.writeEndObject();
		
	}
	
	

}

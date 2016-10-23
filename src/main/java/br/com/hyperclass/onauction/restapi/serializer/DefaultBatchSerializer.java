package br.com.hyperclass.onauction.restapi.serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;

import br.com.hyperclass.onauction.domain.batch.Batch;

public class DefaultBatchSerializer {
	
	public void serialize(final Batch batch, final JsonGenerator generator) throws IOException {
		generator.writeStartObject();
		generator.writeNumberField("code", batch.getCode());
		generator.writeStringField("status", batch.getStatus());
		generator.writeStringField("product", batch.getProduct());
		generator.writeNumberField("initialValue", batch.getInitialValue());
		generator.writeNumberField("valueInterval", batch.getValueInterval());
		generator.writeEndObject();
	}

}

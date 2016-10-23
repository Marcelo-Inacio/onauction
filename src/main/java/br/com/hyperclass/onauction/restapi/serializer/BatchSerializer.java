package br.com.hyperclass.onauction.restapi.serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import br.com.hyperclass.onauction.restapi.wrapper.BatchWrapper;

public class BatchSerializer extends JsonSerializer<BatchWrapper> {
	
	private DefaultBatchSerializer defaultBatchSerializer = new DefaultBatchSerializer();

	@Override
	public void serialize(final BatchWrapper batchWrapper, final JsonGenerator generator, final SerializerProvider arg2)
			throws IOException {
		
		defaultBatchSerializer.serialize(batchWrapper.getBatch(), generator);
		/*generator.writeStartObject();
		generator.writeNumberField("code", batchWrapper.code());
		generator.writeStringField("status", batchWrapper.status());
		generator.writeStringField("product", batchWrapper.product());
		generator.writeNumberField("initialValue", batchWrapper.initialValue());
		generator.writeNumberField("valueInterval", batchWrapper.valueInterval());
		generator.writeEndObject();*/
		
	}
	
}

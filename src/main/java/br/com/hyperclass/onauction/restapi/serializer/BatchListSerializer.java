package br.com.hyperclass.onauction.restapi.serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import br.com.hyperclass.onauction.domain.batch.Batch;
import br.com.hyperclass.onauction.restapi.wrapper.BatchWrapperList;

public class BatchListSerializer extends JsonSerializer<BatchWrapperList> {
	
	private DefaultBatchSerializer defaultBatchSerializer = new DefaultBatchSerializer();

	@Override
	public void serialize(BatchWrapperList batchWrapperList, JsonGenerator generator, SerializerProvider arg2)
			throws IOException {

		generator.writeStartArray();
		for(final Batch batch : batchWrapperList.getBatchList()){
			defaultBatchSerializer.serialize(batch, generator);
			generator.writeNumberField("finalValue", batch.getLastBidValue());
		}
		generator.writeEndArray();
		
		
	}

}

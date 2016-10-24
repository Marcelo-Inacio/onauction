package br.com.hyperclass.onauction.restapi.serializer;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import br.com.hyperclass.onauction.domain.batch.Batch;
import br.com.hyperclass.onauction.restapi.wrapper.BatchWrapperHistoricList;

public class BatchListHistoricSerializer extends JsonSerializer<BatchWrapperHistoricList> {
	
	private DefaultBatchSerializer defaultBatchSerializer;

	@Override
	public void serialize(final BatchWrapperHistoricList batchWrapperHistoric, final JsonGenerator generator, final SerializerProvider arg2)
			throws IOException {
		
		generator.writeStartArray();
		for(final Batch batch : batchWrapperHistoric.getBatchList()){
			generator.writeStartObject();
			defaultBatchSerializer.serialize(batch, generator);
			generator.writeNumberField("finalValue", batch.getLastBidValue());
			generator.writeEndObject();
		}
		generator.writeEndArray();	
	}
	
	@Autowired
	public void setDefaultBatchSerializer(final DefaultBatchSerializer defaultBatchSerializer) {
		this.defaultBatchSerializer = defaultBatchSerializer;
	}

}

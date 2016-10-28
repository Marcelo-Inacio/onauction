/*
 * @(#)BatchHistoricListSerializer.java 1.0 26/10/2016
 *
 * Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.hyperclass.onauction.restapi.serializer;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import br.com.hyperclass.onauction.domain.batch.Batch;
import br.com.hyperclass.onauction.restapi.wrapper.BatchHistoricListWrapper;

public class BatchHistoricListSerializer extends JsonSerializer<BatchHistoricListWrapper> {
	
	private DefaultBatchSerializer defaultBatchSerializer;

	@Override
	public void serialize(final BatchHistoricListWrapper batchWrapperHistoric, final JsonGenerator generator, final SerializerProvider arg2)
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

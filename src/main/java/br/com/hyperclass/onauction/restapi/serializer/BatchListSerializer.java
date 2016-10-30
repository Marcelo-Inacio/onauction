/*
 * @(#)BatchListSerializer.java 1.0 26/10/2016
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
import br.com.hyperclass.onauction.restapi.wrapper.BatchListWrapper;
/**
 * A classe <code>BatchListSerializer</code> cuida de serializar para json uma lista de objetos lotes.
 * 
 * @author Marcelo
 *
 */
public class BatchListSerializer extends JsonSerializer<BatchListWrapper> {
	
	private DefaultBatchSerializer defaultBatchSerializer;

	@Override
	public void serialize(final BatchListWrapper batchWrapperList, final JsonGenerator generator,
			final SerializerProvider arg2) throws IOException {

		generator.writeStartArray();
		for(final Batch batch : batchWrapperList.getBatchList()){
			generator.writeStartObject();
			defaultBatchSerializer.serialize(batch, generator);
			generator.writeStringField("status", batch.getStatus());
			generator.writeNumberField("valueInterval", batch.getValueInterval());
			generator.writeEndObject();
		}
		generator.writeEndArray();
	}
	
	@Autowired
	public void setDefaultBatchSerializer(final DefaultBatchSerializer defaultBatchSerializer) {
		this.defaultBatchSerializer = defaultBatchSerializer;
	}

}

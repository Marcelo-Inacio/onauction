/*
 * @(#)BatchSerializer.java 1.0 26/10/2016
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

import br.com.hyperclass.onauction.restapi.wrapper.BatchWrapper;

public class BatchSerializer extends JsonSerializer<BatchWrapper> {
	
	
	private DefaultBatchSerializer defaultBatchSerializer;

	@Override
	public void serialize(final BatchWrapper batchWrapper, final JsonGenerator generator, final SerializerProvider arg2)
			throws IOException {
		
		generator.writeStartObject();
		defaultBatchSerializer.serialize(batchWrapper.getBatch(), generator);
		generator.writeStringField("status", batchWrapper.status());
		generator.writeNumberField("valueInterval", batchWrapper.valueInterval());
		generator.writeEndObject();
		
	}
	
	@Autowired
	public void setDefaultBatchSerializer(final DefaultBatchSerializer defaultBatchSerializer) {
		this.defaultBatchSerializer = defaultBatchSerializer;
	}
	
}

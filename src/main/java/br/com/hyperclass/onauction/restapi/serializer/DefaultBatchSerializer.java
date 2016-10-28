/*
 * @(#)DefaultBatchSerializer.java 1.0 26/10/2016
 *
 * Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.hyperclass.onauction.restapi.serializer;

import java.io.IOException;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonGenerator;

import br.com.hyperclass.onauction.domain.batch.Batch;

@Component
public class DefaultBatchSerializer implements Serializer {
	
	public void serializeDefaultValues(final Batch batch, final JsonGenerator generator) throws IOException {
		
		generator.writeNumberField("code", batch.getCode());
		generator.writeStringField("product", batch.getProduct());
		generator.writeNumberField("initialValue", batch.getInitialValue());
		
	}

	@Override
	public void serialize(Batch batch, JsonGenerator generator) throws IOException {
		serializeDefaultValues(batch, generator);
	}

}

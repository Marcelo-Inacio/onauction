/*
 * @(#)BatchDeserializer.java 1.0 26/10/2016
 *
 * Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.hyperclass.onauction.restapi.serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import br.com.hyperclass.onauction.domain.batch.Batch;
import br.com.hyperclass.onauction.domain.batch.Product;
import br.com.hyperclass.onauction.restapi.wrapper.BatchWrapper;
/**
 * A classe <code>BatchDeserializer</code> cuida de desserializar
 * um lote vindo como json do cliente.
 * 
 * @author Marcelo
 *
 */
public class BatchDeserializer extends JsonDeserializer<BatchWrapper> {

	@Override
	public BatchWrapper deserialize(final JsonParser jsonParser, final DeserializationContext context)
			throws IOException {
		
		final ObjectCodec oc = jsonParser.getCodec();
        final JsonNode node = oc.readTree(jsonParser);

		return new BatchWrapper(new Batch(new Product(node.get("product").asText()),
				node.get("initialBid").asDouble(),
				node.get("valueInterval").asDouble()));
	}

}

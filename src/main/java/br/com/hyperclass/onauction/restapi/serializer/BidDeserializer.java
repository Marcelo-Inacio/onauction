/*
 * @(#)BidDeserializer.java 1.0 26/10/2016
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

import br.com.hyperclass.onauction.restapi.wrapper.BidWrapper;
/**
 * A classe <code>BidDeserializer</code> cuida de desserializar o valor de um
 * lance json vindo do cliente.
 * 
 * @author Marcelo
 *
 */
public class BidDeserializer extends JsonDeserializer<BidWrapper> {

	@Override
	public BidWrapper deserialize(final JsonParser jsonParser, final DeserializationContext arg1)
			throws IOException {

		final ObjectCodec oc = jsonParser.getCodec();
        final JsonNode node = oc.readTree(jsonParser);
        
		return new BidWrapper(node.get("value").asDouble(), null, 0);
	}

}

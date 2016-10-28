/*
 * @(#)DateDeserializer.java 1.0 26/10/2016
 *
 * Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.hyperclass.onauction.restapi.serializer;

import java.io.IOException;
import java.util.Date;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import br.com.hyperclass.onauction.restapi.wrapper.DateWrapper;

public class DateDeserializer extends JsonDeserializer<DateWrapper> {

	@Override
	public DateWrapper deserialize(final JsonParser jsonParser, final DeserializationContext arg1)
			throws IOException {

		final ObjectCodec oc = jsonParser.getCodec();
        final JsonNode node = oc.readTree(jsonParser);
        
		return new DateWrapper(new Date(node.get("date").asLong()));
	}

}

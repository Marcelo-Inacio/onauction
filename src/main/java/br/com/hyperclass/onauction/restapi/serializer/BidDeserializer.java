package br.com.hyperclass.onauction.restapi.serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import br.com.hyperclass.onauction.restapi.wrapper.BidWrapper;

public class BidDeserializer extends JsonDeserializer<BidWrapper> {

	@Override
	public BidWrapper deserialize(final JsonParser jsonParser, final DeserializationContext arg1)
			throws IOException {

		final ObjectCodec oc = jsonParser.getCodec();
        final JsonNode node = oc.readTree(jsonParser);
        
		return new BidWrapper(node.get("value").asDouble());
	}

}

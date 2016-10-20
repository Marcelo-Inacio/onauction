package br.com.hyperclass.onauction.restapi.serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import br.com.hyperclass.onauction.restapi.wrapper.LoginWrapper;

public class LoginDeserializer extends JsonDeserializer<LoginWrapper> {

	@Override
	public LoginWrapper deserialize(final JsonParser jsonParser, final DeserializationContext context)
			throws IOException {
		
		final ObjectCodec oc = jsonParser.getCodec();
        final JsonNode node = oc.readTree(jsonParser);
        
        return new LoginWrapper(node.get("username").asText(),
        		node.get("password").asText());
	}

}

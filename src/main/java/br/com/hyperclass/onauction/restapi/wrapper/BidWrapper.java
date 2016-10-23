package br.com.hyperclass.onauction.restapi.wrapper;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.com.hyperclass.onauction.restapi.serializer.BidDeserializer;
import br.com.hyperclass.onauction.restapi.serializer.BidSerializer;

@JsonDeserialize(using = BidDeserializer.class)
@JsonSerialize(using = BidSerializer.class)
public class BidWrapper {
	
	private final double value;
	
	public BidWrapper(final double value) {
		this.value = value;
	}
	
	public double getValue() {
		return value;
	}

}

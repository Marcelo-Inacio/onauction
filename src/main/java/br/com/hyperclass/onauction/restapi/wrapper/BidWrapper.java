/*
 * @(#)BidWrapper.java 1.0 26/10/2016
 *
 * Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.hyperclass.onauction.restapi.wrapper;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.com.hyperclass.onauction.restapi.serializer.BidDeserializer;
import br.com.hyperclass.onauction.restapi.serializer.BidSerializer;

@JsonDeserialize(using = BidDeserializer.class)
@JsonSerialize(using = BidSerializer.class)
public class BidWrapper {
	
	private final double value;
	private final String product;
	private final double valueInterval;
	
	public BidWrapper(final double value, final String product, final double valueInterval) {
		this.value = value;
		this.product = product;
		this.valueInterval = valueInterval;
	}
	
	public double getValue() {
		return value;
	}
	
	public String getProduct() {
		return product;
	}
	
	public double getValueInterval() {
		return valueInterval;
	}

}

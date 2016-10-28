/*
 * @(#)BatchWrapper.java 1.0 26/10/2016
 *
 * Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.hyperclass.onauction.restapi.wrapper;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.com.hyperclass.onauction.domain.batch.Batch;
import br.com.hyperclass.onauction.restapi.serializer.BatchDeserializer;
import br.com.hyperclass.onauction.restapi.serializer.BatchSerializer;

@JsonDeserialize(using = BatchDeserializer.class)
@JsonSerialize(using = BatchSerializer.class)
public class BatchWrapper {
	
	private final Batch batch;
	
	public BatchWrapper(final Batch batch) {
		this.batch = batch;
	}
	
	public Batch getBatch() {
		return batch;
	}
	
	public int code() {
		return batch.getCode();
	}
	
	public String status() {
		return batch.getStatus();
	}
	
	public String product() {
		return batch.getProduct();
	}
	
	public Double valueInterval() {
		return batch.getValueInterval();
	}
	
	public Double initialValue() {
		return batch.getInitialValue();
	}

}

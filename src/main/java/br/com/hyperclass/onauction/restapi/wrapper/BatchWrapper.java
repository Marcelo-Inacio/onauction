package br.com.hyperclass.onauction.restapi.wrapper;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.com.hyperclass.onauction.domain.batch.Product;
import br.com.hyperclass.onauction.domain.batch.StatusBatch;
import br.com.hyperclass.onauction.restapi.serializer.BatchDeserializer;
import br.com.hyperclass.onauction.restapi.serializer.BatchSerializer;

@JsonDeserialize(using = BatchDeserializer.class)
@JsonSerialize(using = BatchSerializer.class)
public class BatchWrapper {
	
	private int code;
	private StatusBatch status;
	private final Product product;
	private final double interval;
	private final double minimumValue;
	
	public BatchWrapper(final int code, final Product product, final double minimumValue, final double interval) {
		this.code = code;
		this.product = product;
		this.interval = interval;
		this.minimumValue = minimumValue;
	}
	
	public int getCode() {
		return code;
	}
	
	public String getStatus() {
		return status.name();
	}
	
	public String getProduct() {
		return product.getDescription();
	}
	
	public double getInterval() {
		return interval;
	}
	
	public double getminimumValue() {
		return minimumValue;
	}

}

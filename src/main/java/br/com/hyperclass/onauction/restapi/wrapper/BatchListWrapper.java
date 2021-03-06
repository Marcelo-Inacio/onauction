/*
 * @(#)BatchListWrapper.java 1.0 26/10/2016
 *
 * Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.hyperclass.onauction.restapi.wrapper;

import java.util.Collection;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.com.hyperclass.onauction.domain.batch.Batch;
import br.com.hyperclass.onauction.restapi.serializer.BatchListSerializer;

@JsonSerialize(using = BatchListSerializer.class) 
public class BatchListWrapper  extends AbstractBatchListWrapper {
		
	public BatchListWrapper(final Collection<Batch> batches) {
		super(batches);
	}
	
}

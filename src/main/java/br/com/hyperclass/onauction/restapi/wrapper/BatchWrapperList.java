package br.com.hyperclass.onauction.restapi.wrapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.com.hyperclass.onauction.domain.batch.Batch;
import br.com.hyperclass.onauction.restapi.serializer.BatchListSerializer;

@JsonSerialize(using = BatchListSerializer.class) 
public class BatchWrapperList {
	
	private final List<Batch> batchList = new ArrayList<>();
	
	public BatchWrapperList(final Collection<Batch> batches) {
		this.batchList.clear();
		this.batchList.addAll(batches);
	}
	
	public List<Batch> getBatchList() {
		return Collections.unmodifiableList(batchList);
	}

}

package br.com.hyperclass.onauction.restapi.wrapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import br.com.hyperclass.onauction.domain.batch.Batch;

public abstract class AbstractBatchListWrapper {
	
	private final List<Batch> batchList = new ArrayList<>();
	
	public AbstractBatchListWrapper(final Collection<Batch> batches) {
		this.batchList.clear();
		this.batchList.addAll(batches);
	}
	
	public List<Batch> getBatchList() {
		return Collections.unmodifiableList(batchList);
	}

}

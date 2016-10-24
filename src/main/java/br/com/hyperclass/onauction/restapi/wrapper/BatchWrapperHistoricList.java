package br.com.hyperclass.onauction.restapi.wrapper;

import java.util.Collection;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.com.hyperclass.onauction.domain.batch.Batch;
import br.com.hyperclass.onauction.restapi.serializer.BatchListHistoricSerializer;

@JsonSerialize(using = BatchListHistoricSerializer.class)
public class BatchWrapperHistoricList extends AbstractBatchWrapperList {
	
	//private final List<Batch> batchList = new ArrayList<>();
	
	public BatchWrapperHistoricList(final Collection<Batch> batches) {
		super(batches);
		//this.batchList.clear();
		//this.batchList.addAll(batches);
	}
	
	/*public List<Batch> getBatchList() {
		return Collections.unmodifiableList(batchList);
	}*/

}

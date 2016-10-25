package br.com.hyperclass.onauction.domain.batch;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Component;

@Component
public class BatchRepository implements Repository<Integer, Batch> {
	
	private int sequence = 1;
	private final Map<Integer, Batch> batchMap = new HashMap<>();
	
	public Batch save(final Batch batch) {
		final int id = nextId();
		batch.setCode(id);
		batchMap.put(id, batch);
		return batchMap.get(id);
	}
	
	public void delete(final int id) {
		batchMap.remove(id);
	}
	
	public Batch findById(final int id) {
		return batchMap.get(id);
	}
	
	public Collection<Batch> findAll() {
		return Collections.unmodifiableCollection(batchMap.values());
	}
	
	public Collection<Batch> findByDate(final String date) {
		final List<Batch> batchesList = new ArrayList<>();
		for(final Batch batch : batchMap.values()) {
			final String dateOfBatch = batch.getDate();
			if(dateOfBatch.equals(date)) {
				batchesList.add(batch);
			}
		}
		return batchesList;
	}
	
	private int nextId() {
		return sequence++;
	}

}

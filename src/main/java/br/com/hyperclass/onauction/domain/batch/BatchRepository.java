/*
 * @(#)ReferenceDateClaimsVerifier.java 1.0 26/10/2016
 *
 * Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.hyperclass.onauction.domain.batch;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Component;
/**
 * A classe <code>BatchRepository</code> representa o repositório onde são armazenados todos lotes
 * cadastrados no leilão.
 * 
 * @author Marcelo
 *
 */
@Component
public class BatchRepository implements Repository<Integer, Batch> {
	
	private int sequence = 1;
	private final Map<Integer, Batch> batchMap = new HashMap<>();
	/**
	 * Método que cria um novo lote no leilão setando um id.
	 * @param batch
	 * @return
	 */
	public Batch save(final Batch batch) {
		final int id = nextId();
		batch.setCode(id);
		batchMap.put(id, batch);
		return batchMap.get(id);
	}
	/**
	 * Método que exclui um lote do leilão por um id.
	 * @param id
	 */
	public void delete(final int id) {
		batchMap.remove(id);
	}
	/**
	 * Método que recupra um lote do leilão por um id.
	 * @param id
	 * @return
	 */
	public Batch findById(final int id) {
		return batchMap.get(id);
	}
	/**
	 * Método que recupra todos lotes cadastrados no leilão.
	 * @return
	 */
	public Collection<Batch> findAll() {
		return Collections.unmodifiableCollection(batchMap.values());
	}
	/**
	 * Método que recupera uma lista de lotes de uma determinada data.
	 * @param date
	 * @return
	 */
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
	/**
	 * Método que recupera o próximo id válido, simulando um auto incremento do banco de dados.
	 * @return
	 */
	private int nextId() {
		return sequence++;
	}

}

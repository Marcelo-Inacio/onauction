/*
 * @(#)Serializer.java 1.0 26/10/2016
 *
 * Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.hyperclass.onauction.restapi.serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;

import br.com.hyperclass.onauction.domain.batch.Batch;

public interface Serializer {
	
	public void serialize(final Batch batch, final JsonGenerator generator) throws IOException;

}

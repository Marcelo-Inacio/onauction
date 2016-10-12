/*
 * @(#)Product.java 1.0 11/10/2016
 *
 * Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.hyperclass.onauction.domain.batch;

public class Product {
	
	private final String description;
	
	public Product(final String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}

}

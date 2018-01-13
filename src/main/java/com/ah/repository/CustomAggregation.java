package com.ah.repository;

import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperationContext;

import com.mongodb.DBObject;

/**
 * @author Mehraj Malik
 *
 */
public class CustomAggregation implements AggregationOperation {

	private DBObject operation;

	public CustomAggregation(DBObject operation) {
		this.operation = operation;
	}

	@Override
	public DBObject toDBObject(AggregationOperationContext context) {
		return context.getMappedObject(operation);
	}

}

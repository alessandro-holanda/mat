package br.com.alerman.material.measure;

import java.math.BigDecimal;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIgnore;

@DynamoDBDocument
public class Measure {

	@DynamoDBAttribute(attributeName = "measure")
	private String measure;
	
	@DynamoDBAttribute(attributeName = "unit")
	private String unit;
	
	@DynamoDBAttribute(attributeName = "value")
	private String expression;

	@DynamoDBIgnore
	private BigDecimal value;
	
	public Measure() {
		super();
	}

	public Measure(String measure, String unit, String expression) {
		super();
		this.measure = measure;
		this.unit = unit;
		this.expression = expression;
	}

	public String getMeasure() {
		return measure;
	}

	public void setMeasure(String measure) {
		this.measure = measure;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getExpression() {
		return expression;
	}

	public void setExpression(String expression) {
		this.expression = expression;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}
		
}

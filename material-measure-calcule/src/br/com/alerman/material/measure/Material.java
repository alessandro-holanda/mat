package br.com.alerman.material.measure;

import java.util.List;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName="material")
public class Material {

	@DynamoDBHashKey(attributeName="code")
	private String code;
	
	@DynamoDBAttribute(attributeName="description") 
	private String description;
	
	@DynamoDBAttribute(attributeName = "measures")
	private List<Measure> measures;

	public Material() {
		super();
	}

	public Material(String code, String description) {
		super();
		this.code = code;
		this.description = description;
	}

	public Material(String code, String description, List<Measure> measures) {
		super();
		this.code = code;
		this.description = description;
		this.measures = measures;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Measure> getMeasures() {
		return measures;
	}

	public void setMeasures(List<Measure> measures) {
		this.measures = measures;
	}

}

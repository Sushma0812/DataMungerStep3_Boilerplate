package com.stackroute.datamunger.query;

public class DataTypeDefinitions {
	/*
	 * This class should contain a member variable which is a String array, to hold
	 * the data type for all columns for all data types
	 */
	String[] array;
	public DataTypeDefinitions(String[] array){
		super();
		this.array = array;
	}

	public void setArray(String[] array) {
		this.array = array;
	}

	public String[] getArray() {
		return array;
	}

	public String[] getDataTypes() {

		return array;
	}
}

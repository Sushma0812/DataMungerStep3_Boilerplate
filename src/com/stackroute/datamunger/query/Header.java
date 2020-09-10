package com.stackroute.datamunger.query;

public class Header {
	/*
	 * This class should contain a member variable which is a String array, to hold
	 * the headers.
	 */
	String[] storeHeaders;
	public Header(String[] storeHeaders){
		super();
		this.storeHeaders=storeHeaders;
	}

	public void setStoreHeaders(String[] storeHeaders) {
		this.storeHeaders = storeHeaders;
	}

	public String[] getStoreHeaders() {
		return storeHeaders;
	}

	public String[] getHeaders() {

		return storeHeaders;
	}

}

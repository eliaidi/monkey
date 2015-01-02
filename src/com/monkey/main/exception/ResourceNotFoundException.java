package com.monkey.main.exception;

public class ResourceNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String resourcePath;

	public ResourceNotFoundException(String resourcePath) {
		super();
		this.resourcePath = resourcePath;
	}

	public ResourceNotFoundException(Exception e) {
		super(e);
	}

	public String getResourcePath() {
		return resourcePath;
	}

}

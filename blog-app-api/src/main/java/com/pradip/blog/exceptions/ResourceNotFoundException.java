package com.pradip.blog.exceptions;

public class ResourceNotFoundException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String resourceName;
	private String resourceId;
	private long fieldValue;
	public String getResourceName() {
		return resourceName;
	}
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	public String getResourceId() {
		return resourceId;
	}
	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}
	public long getFieldValue() {
		return fieldValue;
	}
	public void setFieldValue(long fieldValue) {
		this.fieldValue = fieldValue;
	}
	public ResourceNotFoundException(String resourceName, String resourceId, long fieldValue) {
		super(String.format("%s not found with this name %s : %s", resourceName,resourceId,fieldValue));
		this.resourceName = resourceName;
		this.resourceId = resourceId;
		this.fieldValue = fieldValue;
	}
	

}

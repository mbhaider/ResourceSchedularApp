package com.jpmorgan.resourceschedular.base;

/***
 * The Message interface represents a single message to be sent to the Gateway
 * @author mbhaider
 *
 */
public abstract class Message {
	
	// defualt name when no name is specified
	private static final String DEFAULT_NAME = "unnamed";
	private static final String DEFAULT_GROUP = "1";
	private String group;
	private String name;
	private String data;
	
	public Message() {
		name = DEFAULT_NAME;
		group = DEFAULT_GROUP;
	}
	
	public Message(String name, String group) {
		this.name = name;
		this.group = group;
	}
	
	public Message(String name, String group, String data) {
		this.name = name;
		this.group = group;
		this.data = data;
	}

	/***
	 * This method is called when the message has been sent to the gateway.
	 */
	public abstract void completed();
	
	/***
	 * This method returns true if the complete() method of this message is already called.
	 * @return
	 */
	public abstract boolean isCompleted();
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return the group
	 */
	public String getGroup() {
		return group;
	}

	/**
	 * @param group the group to set
	 */
	public void setGroup(String group) {
		this.group = group;
	}
	
	/**
	 * @return the data
	 */
	public String getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(String data) {
		this.data = data;
	}
	

	/**
	 * @return the isTermination
	 */
	public boolean isTermination() {
		return false;
	}

	@Override
	public String toString() {
		return name + " - " + group;
	}
}

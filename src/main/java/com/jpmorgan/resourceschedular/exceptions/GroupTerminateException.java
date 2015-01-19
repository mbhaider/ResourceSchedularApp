package com.jpmorgan.resourceschedular.exceptions;

/***
 * This exception is raised when the resource scheduler receives a message that belongs 
 * to a terminated group.
 * @author mbhaider
 *
 */
public class GroupTerminateException extends Exception {

	/**
	 * Auto-generated serialVersionUID
	 */
	private static final long serialVersionUID = -6152901025706255802L;
	private static final String ERROR_MESSAGE = "Received a message from a terminated group.";
	
	public GroupTerminateException(String message) {
		super(ERROR_MESSAGE + " " + message);
	}
	
	public GroupTerminateException() {
		super(ERROR_MESSAGE);
	}
}


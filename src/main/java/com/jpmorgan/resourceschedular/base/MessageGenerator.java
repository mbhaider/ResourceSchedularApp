package com.jpmorgan.resourceschedular.base;

/***
 * The MessageGenerator is used for creating 
 * Messages 
 * @author mbhaider
 *
 */
public abstract class MessageGenerator {
	/***
	 * This method returns a new message of the group.
	 * @param group
	 * @return new message
	 */
	public abstract Message createMessage(String group);
	
	/***
	 * This method a new termination message of the group
	 * @param group
	 * @return new termination message
	 */
	public abstract Message createTerminationMessage(String group);
}

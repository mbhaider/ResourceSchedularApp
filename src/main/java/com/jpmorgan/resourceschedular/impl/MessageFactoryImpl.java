package com.jpmorgan.resourceschedular.impl;

import com.jpmorgan.resourceschedular.base.Message;
import com.jpmorgan.resourceschedular.base.MessageGenerator;

/***
 * A simple implementation of MessageFactory. Returns a new object of the requested 
 * class.
 * @author mbhaider
 *
 */
public class MessageFactoryImpl extends MessageGenerator {
	
	private int index = 0;
	
	/***
	 * Simple implementation of createMessage. Returns a new MessageImpl object
	 * with an increasing index number as the name.
	 */
	@Override
	public Message createMessage(String group) {
		index++;
		Message msg = new MessageImpl(index, group);
		return msg;
	}

	/***
	 * Simple implementation of createTerminationMessage. Returns a new MessageTermination 
	 * object
	 */
	@Override
	public Message createTerminationMessage(String group) {
		Message msg = new MessageTermination(group);
		return msg;
	}
}

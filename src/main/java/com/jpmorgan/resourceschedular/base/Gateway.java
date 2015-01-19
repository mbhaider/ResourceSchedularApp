package com.jpmorgan.resourceschedular.base;

/***
 * The Gateway interface is the destination where message 
 * are to be sent. 
 * @author mbhaider
 *
 */
public interface Gateway {
	/***
	 * Send the message to the gateway
	 */
	public void send(Message msg);
}

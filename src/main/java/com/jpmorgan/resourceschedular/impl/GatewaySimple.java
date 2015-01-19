package com.jpmorgan.resourceschedular.impl;

import com.jpmorgan.resourceschedular.base.Gateway;
import com.jpmorgan.resourceschedular.base.Message;

/***
 * A simple implementation of the Gateway interface.
 * @author mbhaider
 *
 */
public class GatewaySimple implements Gateway {

	/***
	 * Very simple implementation of send(). Just call the method completed()
	 * of the Message object, without any further processing.
	 */
	public void send(Message msg) {
		if (!msg.isCompleted())
			msg.completed();
	}

}

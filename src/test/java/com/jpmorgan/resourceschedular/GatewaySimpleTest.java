package com.jpmorgan.resourceschedular;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.jpmorgan.resourceschedular.base.Message;
import com.jpmorgan.resourceschedular.impl.GatewaySimple;
import com.jpmorgan.resourceschedular.impl.MessageImpl;

public class GatewaySimpleTest {
	
	private GatewaySimple gateway;
	
	@Before
	public void setUp() throws Exception {
		gateway = new GatewaySimple();
	}

	@After
	public void tearDown() throws Exception {
	}

	/***
	 * Test the send() method of GatewaySimple. The messasge's 
	 * isCompleted() method should return true afterwards.
	 */
	@Test
	public void testSend() {
		Message msg = new MessageImpl(1, "1");
		gateway.send(msg);
		assertTrue(msg.isCompleted());
	}

}

package com.jpmorgan.resourceschedular;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.jpmorgan.resourceschedular.base.Message;
import com.jpmorgan.resourceschedular.base.MessageGenerator;
import com.jpmorgan.resourceschedular.impl.MessageFactoryImpl;
import com.jpmorgan.resourceschedular.impl.MessageImpl;

public class MessageFactoryImplTest {
	
	private static final int MESSAGE_INDEX = 2;
	private static final String GROUP_2 = "2";
	private static final String GROUP_1 = "1";
	private MessageGenerator msgGenerator;
	
	@Before
	public void setUp() throws Exception {
		msgGenerator = new MessageFactoryImpl();
	}

	@After
	public void tearDown() throws Exception {
	}

	/***
	 * Test the method createMessage(). 
	 * The message's group and name attributes should be 
	 * correctly set by the message factory.
	 */
	@Test
	public void testCreateMessage() {
		Message msg1 = msgGenerator.createMessage(GROUP_1);
		Message msg2 = new MessageImpl(MESSAGE_INDEX - 1, GROUP_1);
		for (int i = 0; i < MESSAGE_INDEX - 1; i++) {
			msg2 = msgGenerator.createMessage(GROUP_2);
		}
		
		assertTrue(msg1.getGroup().equals(GROUP_1));
		assertTrue(msg2.getName().equals(MESSAGE_INDEX + ""));
	}

}

package com.jpmorgan.resourceschedular.testsample;

import com.jpmorgan.resourceschedular.base.Gateway;
import com.jpmorgan.resourceschedular.base.Message;
import com.jpmorgan.resourceschedular.base.MessageGenerator;
import com.jpmorgan.resourceschedular.base.ResourceManager;
import com.jpmorgan.resourceschedular.base.ResourceScheduler;
import com.jpmorgan.resourceschedular.exceptions.GroupTerminateException;
import com.jpmorgan.resourceschedular.impl.GatewaySimple;
import com.jpmorgan.resourceschedular.impl.MessageFactoryImpl;
import com.jpmorgan.resourceschedular.impl.ResourceManagerSimple;
import com.jpmorgan.resourceschedular.impl.ResourceSchedulerGroupPriority;

/***
 * This is the starting point of the program simulation. 
 * The whole scheduler system is initialised and executed. 
 * 
 * IMPORTANT: Note that the system may seem to run SLOWLY. However, that is due to 
 * the 1 - 2 seconds of sleeping time of Resource, as a way to simulate the delay 
 * caused by remote resources running in real-time. 
 * If this delay is removed, the system will perform tasks almost instantaneously. 
 * To remove the delay, modify the values of both minProcessingTime and maxProcessingTime 
 * in ResourceSimple to 0. 
 * 
 * To make the process more visible, several System.out.print commands have been put 
 * throughout the system. One can be found in 
 * ResourceManagerSimple.processMessage(Resource, Message, Gateway), the others are in 
 * ResourceSchedulerAbstract.SchedulerThread.run().
 * @author mbhaider
 *
 */
public class SchedulerSystemSimulation {
	public static void main(String[] args) throws InterruptedException, GroupTerminateException {
		Gateway gateway = new GatewaySimple();
		ResourceManager resManager = new ResourceManagerSimple();
		ResourceScheduler rs = new ResourceSchedulerGroupPriority(resManager,
				gateway);
		
		// Start the scheduler
		rs.start();
		MessageGenerator mf = new MessageFactoryImpl();
		
		// Can add resources before or after starting the scheduler
		resManager.addResource("1");

		String[][] MESSAGE_QUEUE_TEST_CASES = { 
				{ "2", "1", "2", "3" }, // Case 1
		};

		for (int i = 0; i < MESSAGE_QUEUE_TEST_CASES.length; i++) {
			for (int j = 0; j < MESSAGE_QUEUE_TEST_CASES[i].length; j++) {
				Message msg = mf.createMessage(MESSAGE_QUEUE_TEST_CASES[i][j]);

				rs.addMessage(msg);
			}
		}

	}
}

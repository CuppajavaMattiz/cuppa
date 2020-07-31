package com.mattiz.jbpm;

import java.util.ArrayList;
import java.util.Random;

import org.jbpm.JbpmConfiguration;
import org.jbpm.JbpmContext;
import org.jbpm.graph.def.ProcessDefinition;

import com.mattiz.jbpm.dto.ItemRequest;
import com.mattiz.jbpm.handler.CounterHandler;

public class JBPMTest {

	private Random randomGenerator;

	private ArrayList<String> catalogue;

	public JBPMTest() {
		catalogue = new ArrayList<String>();
		catalogue.add("1");
		catalogue.add("2");
		catalogue.add("3");
		catalogue.add("4");
		catalogue.add("5");
		randomGenerator = new Random();
	}

	public String anyItem() {
		int index = randomGenerator.nextInt(catalogue.size());
		String item = catalogue.get(index);
		System.out.println("Managers choice this week" + item
				+ "our recommendation to you");
		return item;
	}

	public static void main(String args[]) {
		// new JBPMTest().setupOfferSchema();//run this only once//setup
		new JBPMTest().testHelloWorldProcess();

	}

	public void testHelloWorldProcess() {
		ItemRequest itemRequest = new ItemRequest();
		itemRequest.setId("1");
		itemRequest.setName("My Item Request");
		itemRequest.setStatus("Submitted");		
		new ItemRequestController().createItemRequest(itemRequest);
		System.out.println("PENDING  "
				+ CounterHandler.itemRequestsPendingCounter);
		System.out.println("CONFIRMED "
				+ CounterHandler.itemRequestsConfirmedCounter);
		System.out.println("===================================");
		String oldStatus = itemRequest.getStatus();
		itemRequest.setStatus("Approved");		
		new ItemRequestController().updateItemRequest(itemRequest, oldStatus);
		System.out.println("PENDING  "
				+ CounterHandler.itemRequestsPendingCounter);
		System.out.println("CONFIRMED "
				+ CounterHandler.itemRequestsConfirmedCounter);
		System.out.println("===================================");
		oldStatus = itemRequest.getStatus();
		itemRequest.setStatus("Cancelled");		
		new ItemRequestController().updateItemRequest(itemRequest, oldStatus);
		System.out.println("PENDING  "
				+ CounterHandler.itemRequestsPendingCounter);
		System.out.println("CONFIRMED "
				+ CounterHandler.itemRequestsConfirmedCounter);
		System.out.println("===================================");
		System.out.println("===================================");
		
		itemRequest = new ItemRequest();
		itemRequest.setId("2");
		itemRequest.setName("My Second Item Request");
		itemRequest.setStatus("Submitted");		
		new ItemRequestController().createItemRequest(itemRequest);
		System.out.println("PENDING  "
				+ CounterHandler.itemRequestsPendingCounter);
		System.out.println("CONFIRMED "
				+ CounterHandler.itemRequestsConfirmedCounter);
		System.out.println("===================================");
		oldStatus = itemRequest.getStatus();
		itemRequest.setStatus("Approved");		
		new ItemRequestController().updateItemRequest(itemRequest, oldStatus);
		System.out.println("PENDING  "
				+ CounterHandler.itemRequestsPendingCounter);
		System.out.println("CONFIRMED "
				+ CounterHandler.itemRequestsConfirmedCounter);
		System.out.println("===================================");
		oldStatus = itemRequest.getStatus();
		itemRequest.setStatus("Rejected");		
		new ItemRequestController().updateItemRequest(itemRequest, oldStatus);
		System.out.println("PENDING  "
				+ CounterHandler.itemRequestsPendingCounter);
		System.out.println("CONFIRMED "
				+ CounterHandler.itemRequestsConfirmedCounter);
		System.out.println("===================================");
		System.out.println("===================================");
		
		itemRequest = new ItemRequest();
		itemRequest.setId("3");
		itemRequest.setName("My Third Item Request");
		itemRequest.setStatus("Submitted");		
		new ItemRequestController().createItemRequest(itemRequest);
		System.out.println("PENDING  "
				+ CounterHandler.itemRequestsPendingCounter);
		System.out.println("CONFIRMED "
				+ CounterHandler.itemRequestsConfirmedCounter);
		System.out.println("===================================");
		oldStatus = itemRequest.getStatus();
		itemRequest.setStatus("Approved");		
		new ItemRequestController().updateItemRequest(itemRequest, oldStatus);
		System.out.println("PENDING  "
				+ CounterHandler.itemRequestsPendingCounter);
		System.out.println("CONFIRMED "
				+ CounterHandler.itemRequestsConfirmedCounter);
		System.out.println("===================================");
		System.out.println("===================================");
		
		itemRequest = new ItemRequest();
		itemRequest.setId("4");
		itemRequest.setName("My Fourth Item Request");
		itemRequest.setStatus("Submitted");		
		new ItemRequestController().createItemRequest(itemRequest);
		System.out.println("PENDING  "
				+ CounterHandler.itemRequestsPendingCounter);
		System.out.println("CONFIRMED "
				+ CounterHandler.itemRequestsConfirmedCounter);
		System.out.println("===================================");
		oldStatus = itemRequest.getStatus();
		itemRequest.setStatus("Approved");		
		new ItemRequestController().updateItemRequest(itemRequest, oldStatus);
		System.out.println("PENDING  "
				+ CounterHandler.itemRequestsPendingCounter);
		System.out.println("CONFIRMED "
				+ CounterHandler.itemRequestsConfirmedCounter);
		System.out.println("===================================");
		oldStatus = itemRequest.getStatus();
		itemRequest.setStatus("Rejected");		
		new ItemRequestController().updateItemRequest(itemRequest, oldStatus);
		System.out.println("PENDING  "
				+ CounterHandler.itemRequestsPendingCounter);
		System.out.println("CONFIRMED "
				+ CounterHandler.itemRequestsConfirmedCounter);
		System.out.println("===================================");
		System.out.println("===================================");
		
		
	}

	public void setupOfferSchema() {
		JbpmConfiguration config = JbpmConfiguration
				.parseResource("jbpm.cfg.xml");
		ProcessDefinition processDefinition = ProcessDefinition
				.parseXmlResource("processdefinition.xml");
		// create schema.
		config.createSchema();
		JbpmContext context = config.createJbpmContext();
		// deploy process definition.
		try {
			context.deployProcessDefinition(processDefinition);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			context.close();
		}
	}
}

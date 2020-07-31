package com.mattiz.jbpm.handler;

import org.jbpm.graph.def.ActionHandler;
import org.jbpm.graph.exe.ExecutionContext;

public class StatusHandler implements ActionHandler {

	private String status;

	public void execute(ExecutionContext executionContext) throws Exception {
		String itemRequestId = (String) executionContext.getContextInstance()
				.getVariable("ItemRequestId");
		executionContext.getContextInstance().setVariable("status", status);
		//do something important like update the status in the database using the itemRequestId
	}
}

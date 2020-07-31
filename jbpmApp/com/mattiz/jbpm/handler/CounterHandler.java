package com.mattiz.jbpm.handler;

import java.util.HashMap;
import java.util.Map;

import org.jbpm.graph.def.ActionHandler;
import org.jbpm.graph.exe.ExecutionContext;

public class CounterHandler implements ActionHandler {

	private static Map<String, String> actionForStatusChange = new HashMap<String, String>();

	public static int itemRequestsPendingCounter;

	public static int itemRequestsConfirmedCounter;

	private String status;
	static {
		actionForStatusChange.put("NEW" + "_" + "Submitted",
				"addToItemRequestsPending");
		actionForStatusChange.put("Submitted" + "_" + "Approved",
				"addToItemRequestsConfirmedAndSubtractFromItemRequestsPending");
		actionForStatusChange.put("Approved" + "_" + "Rejected",
				"subtractFromItemRequestsConfirmed");
		actionForStatusChange.put("Submitted" + "_" + "Rejected",
				"subtractFromItemRequestsPending");
		actionForStatusChange.put("Approved" + "_" + "Cancelled",
				"subtractFromItemRequestsConfirmed");
	}

	public void execute(ExecutionContext executionContext) throws Exception {
		String oldStatus = (String) executionContext.getContextInstance()
				.getVariable("oldStatus");
		if (oldStatus == null) {
			oldStatus = "NEW";
		}
		String action = actionForStatusChange.get(oldStatus + "_" + status);
		if (null != action) {
			if (action.equals("addToItemRequestsPending")) {
				itemRequestsPendingCounter++;
			} else if (action.equals("addToItemRequestsConfirmed")) {
				itemRequestsConfirmedCounter++;
			} else if (action.equals("subtractFromItemRequestsConfirmed")) {
				itemRequestsConfirmedCounter--;
			} else if (action.equals("subtractFromItemRequestsPending")) {
				itemRequestsPendingCounter--;
			}else if (action.equals("addToItemRequestsConfirmedAndSubtractFromItemRequestsPending")){
				itemRequestsPendingCounter--;
				itemRequestsConfirmedCounter++;
			}else if (action.equals("subtractFromItemRequestsPending")){
				itemRequestsPendingCounter--;
			}
		}
	}
}

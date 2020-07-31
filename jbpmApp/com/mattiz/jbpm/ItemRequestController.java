package com.mattiz.jbpm;

import java.util.ArrayList;
import java.util.List;

import com.mattiz.jbpm.dto.ItemRequest;
import com.mattiz.jbpm.workflow.JBPMWorkFlow;

public class ItemRequestController {
	JBPMWorkFlow workflowService = new JBPMWorkFlow();

	public List<String> createItemRequest(ItemRequest itemRequest) {
		Long processInstanceId = workflowService
				.createItemRequestFlow(itemRequest);
		itemRequest.setProcessInstanceId(processInstanceId);
		workflowService.makeCounterChanges(processInstanceId, null);
		List<String> transitions = workflowService.makeTransition(
				itemRequest.getProcessInstanceId(), itemRequest.getStatus());
		return transitions;
	}

	public void updateItemRequest(ItemRequest itemRequest, String oldStatus) {
		Long processInstanceId = itemRequest.getProcessInstanceId();
		workflowService.makeCounterChanges(processInstanceId, oldStatus);
		workflowService.makeTransition(processInstanceId, itemRequest
				.getStatus());
	}
}

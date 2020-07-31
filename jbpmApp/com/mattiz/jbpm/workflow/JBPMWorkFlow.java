package com.mattiz.jbpm.workflow;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.jbpm.JbpmConfiguration;
import org.jbpm.JbpmContext;
import org.jbpm.JbpmException;
import org.jbpm.graph.def.ProcessDefinition;
import org.jbpm.graph.def.Transition;
import org.jbpm.graph.exe.ProcessInstance;
import org.springframework.util.StringUtils;

import com.mattiz.jbpm.dto.ItemRequest;

public class JBPMWorkFlow {

	JbpmConfiguration config = JbpmConfiguration.parseResource("jbpm.cfg.xml");
	
	// public List<String> getInitialStepsForItemRequestFlow(String actor) {
	//
	// JbpmContext context = config.createJbpmContext();
	// List<String> transitionNames = new ArrayList<String>();
	// try {
	// ProcessDefinition pd = context.getGraphSession()
	// .findLatestProcessDefinition("Mattiz_Process_Flow");
	// Node rootNode = pd.findNode("Create");
	// List<Transition> leavingTransitions = rootNode
	// .getLeavingTransitions();
	// for (Transition t : leavingTransitions) {
	// transitionNames.add(t.getName());
	// }
	// System.out.println("leavingTransitions " + leavingTransitions);
	// } catch (Exception e) {
	// System.out.println("Exception Occured!");
	// } finally {
	// context.close();
	// }
	// return transitionNames;
	// }

	public Long createItemRequestFlow(ItemRequest ItemRequest) {
		if (ItemRequest == null || ItemRequest.getId() == null) {
			throw new RuntimeException();
		}
		JbpmContext context = config.createJbpmContext();
		ProcessInstance pi = null;
		String status = null;
		try {
			pi = context.newProcessInstance("Mattiz_Process_Flow");
			pi.getContextInstance().setVariable("ItemRequestId",
					ItemRequest.getId());
			System.out.println();
			pi.signal();
			status = (String) pi.getContextInstance().getVariable("status");
		} catch (Exception e) {
			status = null;
			throw new RuntimeException(e);
		} finally {
			context.close();
		}
		if (status != null) {
			ItemRequest.setStatus(status);//??
		}
		return pi.getId();
	}

	// public List<String> getNextTransitions(Long processInstanceId) {
	// if (processInstanceId == null) {
	// throw new RuntimeException();
	// }
	// List<String> transitionNames = new ArrayList<String>();
	// JbpmContext context = config.createJbpmContext();
	// try {
	// ProcessInstance pi = context.getProcessInstance(processInstanceId);
	// List<Transition> leavingTransitions = pi.getRootToken().getNode()
	// .getLeavingTransitions();
	// for (Transition t : leavingTransitions) {
	// transitionNames.add(t.getName());
	// }
	// } catch (JbpmException e) {
	// System.out.println("Exception occured!");
	// } finally {
	// context.close();
	// }
	// return transitionNames;
	// }

	public List<String> makeTransition(Long processInstanceId,
			String transitionName) throws RuntimeException {
		return makeTransition(processInstanceId, transitionName, null);
	}

	public List<String> makeTransition(Long processInstanceId,
			String transitionName, Map<String, Object> parameterMap)
			throws RuntimeException {
		if (processInstanceId == null || transitionName == null) {
			throw new RuntimeException();
		}
		JbpmContext context = config.createJbpmContext();
		List<String> transitionNames = new ArrayList<String>();
		try {
			ProcessInstance pi = context.getProcessInstance(processInstanceId);
			List<Transition> leavingTransitions = pi.getRootToken().getNode()
					.getLeavingTransitions();
			for (Transition t : leavingTransitions) {
				transitionNames.add(t.getName());
			}
			System.out.println("Choices are "+leavingTransitions);
			System.out.println("ACTION IS--->"+transitionName);
			if (parameterMap != null) {
				pi.getContextInstance().setVariables(parameterMap);
			}
			if (StringUtils.hasText(transitionName)) {
				pi.signal(transitionName);
			} else {
				pi.signal();
			}
			String failure = (String) pi.getContextInstance().getVariable(
					"failure");
			if (StringUtils.hasText(failure)) {
				throw new RuntimeException(failure);
			}
		} catch (JbpmException e) {
			throw new RuntimeException(e);
		} finally {
			context.close();
		}
		return transitionNames;
	}

	public void makeCounterChanges(Long processInstanceId, String oldStatus)
			throws RuntimeException {
		if (processInstanceId == null) {
			throw new RuntimeException();
		}
		JbpmContext context = config.createJbpmContext();
		try {
			ProcessInstance pi = context.getProcessInstance(processInstanceId);
			pi.getContextInstance().setVariable("oldStatus", oldStatus);
			String failure = (String) pi.getContextInstance().getVariable(
					"failure");// ??
		} catch (JbpmException e) {
			throw new RuntimeException();
		} finally {
			context.close();
		}
	}

}

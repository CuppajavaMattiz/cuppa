<%@page contentType="text/html"%>
<%@ taglib uri="/WEB-INF/html_basic.tld" prefix="h"%>
<%@ taglib uri="/WEB-INF/jsf_core.tld" prefix="f"%>
<html>
	<head>
		<title>authorPage.jsp</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
	</head>
	<body>
		<f:view>
			<h:form>
				<%if (request.getAttribute("count") != null) {
				int count = Integer.parseInt(request.getAttribute("count")
						.toString());
				int start = Integer.parseInt(request.getAttribute("start")
						.toString());
				int end = Integer.parseInt(request.getAttribute("end")
						.toString());
				int totRows = Integer.parseInt(request.getAttribute("totRows")
						.toString());

				%>
					<h:dataTable width="100%" border="0" id="values" value="#{authorBean.authorsList}" var="authorDTO" style="font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 12px;font-weight: bold; color: #000000">
						<h:column>
							<h:outputText value="#{authorDTO.isbnCode}" style="color: #000099;font-family: Verdana, Arial, Helvetica, sans-serif;font-size: 10px;font-weight: bold;" />
						</h:column>
						<h:column>
							<h:outputText value="#{authorDTO.author}" style="color: #000099;font-family: Verdana, Arial, Helvetica, sans-serif;font-size: 10px;font-weight: bold;" />
						</h:column>
					</h:dataTable>
				
				<%if (!(start == 1)) {%>
				<h:commandLink action="#{authorBean.displayAuthors}">
					<h:outputText value="PREV" style="color: #000099;font-family: Verdana, Arial, Helvetica, sans-serif;font-size: 10px;font-weight: bold;" />
					<f:param name="begin" value="#{start-10}" />
					<f:param name="finish" value="#{end-10}" />
					<f:param name="no" value="#{count}" />
					<f:param name="change" value="decr" />
				</h:commandLink>
				<%}
				if (!(count == totRows)) {%>
				<h:commandLink action="#{authorBean.displayAuthors}">
					<h:outputText value="NEXT" style="color: #000099;font-family: Verdana, Arial, Helvetica, sans-serif;font-size: 10px;font-weight: bold;" />
					<f:param name="begin" value="#{start+10}" />
					<f:param name="finish" value="#{end+10}" />
					<f:param name="no" value="#{count}" />
					<f:param name="change" value="incr" />
				</h:commandLink>
				<%}
			}%>
			</h:form>
		</f:view>
	</body>
</html>

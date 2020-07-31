<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<html>
<body>
<f:view>
	<h:form id="authorForm">
		<p><br />
		<h:outputText value="Enter ISBN code" /> <h:inputText
			value="#{authorSearchCreate.isbnCode}" maxlength="6" size='6' /> <br />

		<h:outputText value="Enter name of author" /> <h:inputText
			value="#{authorSearchCreate.author}" maxlength="6" size='6' /> <br />

		<h:commandButton id="addAuthorId"
			action="#{authorSearchCreate.addAuthor}" value="ADD" type="submit" />
		<h:commandButton id="findAuthorId"
			action="#{authorSearchCreate.findAuthor}" value="FIND" type="submit" />
		</p>
	</h:form>
</f:view>
</body>
</html>

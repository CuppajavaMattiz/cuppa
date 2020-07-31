
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>


<html>
<body>
<f:view>
	 	AUTHOR FOUND:<br>
	ISBN :<h:outputText value="#{authorSearchCreate.isbnCode}" /><br/>
	AUTHOR :<h:outputText value="#{authorSearchCreate.author}" />
	<br />
</f:view>
</body>
</html>

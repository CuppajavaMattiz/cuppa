<%@page contentType="text/html"%>
<%@ taglib uri="/WEB-INF/html_basic.tld" prefix="h"%>
<%@ taglib uri="/WEB-INF/jsf_core.tld" prefix="f"%>
<%@ taglib uri="/WEB-INF/JsfCustomTag.tld" prefix="acis"%>
<html>
<head>
<title>author.jsp</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
</head>
<body>
<f:view>
	<h:form>
		<h:panelGrid id="grid1" columns="2" border="0" width="100%">
			<h:outputText id="text1"
				style="color: #000099;font-family: Verdana, Arial, Helvetica, sans-serif;font-size: 10px;font-weight: bold;"
				value="Enter ISBN Code    :" />
			<h:inputText style="color: automatic; background: iceblue;"
				value="#{authorBean.isbnCode}" />
			<h:outputText id="text2"
				style="color: #000099;font-family: Verdana, Arial, Helvetica, sans-serif;font-size: 10px;font-weight: bold;"
				value="Enter Author Name:" />
			<h:inputText style="color: automatic; background: iceblue;"
				value="#{authorBean.author}" />
		</h:panelGrid>
		<h:panelGrid id="grid3" columns="2" border="0" width="100%">
			<h:commandButton value="Add" type="submit"
				action="#{authorBean.addAuthor}" />
		</h:panelGrid>
		<hr />
		<h:panelGrid id="grid5" columns="2" border="0" width="100%">
			<h:outputText id="text3"
				style="color: #000099;font-family: Verdana, Arial, Helvetica, sans-serif;font-size: 10px;font-weight: bold;"
				value="Paginate Author Details " />
		</h:panelGrid>
		<h:panelGrid id="grid6" columns="2" border="0" width="100%">
			<h:commandButton value="Paginate" type="submit"
				action="#{authorBean.displayAuthors}" />
		</h:panelGrid>
		<acis:JsfTextCustomTag maxlength="2" size="2"/>
	</h:form>
</f:view>
</body>
</html>

<%@page%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="http://acme-framework.org/"%>

<acme:list>
	<acme:list-column code="developer.training-session.list.label.code" path="code" width="25%"/>	
	<acme:list-column code="developer.training-session.list.label.initiateMoment" path="initiateMoment" width="25%"/>
	<acme:list-column code="developer.training-session.list.label.finalizationMoment" path="finalizationMoment" width="25%"/>	
	<acme:list-column code="developer.training-session.list.label.instructor" path="instructor" width="25%"/>	
	
</acme:list>

<acme:button test="${showCreate}" code="developer.training-session.list.button.create" action="/developer/training-session/create?masterId=${masterId}"/>

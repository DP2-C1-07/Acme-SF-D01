<%@page%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="http://acme-framework.org/"%>

<acme:list navigable="true">
	<acme:list-column code="manager.project.list.label.code" path="code" width="10%"/>
	<acme:list-column code="manager.project.list.label.title" path="title" width="10%"/>
	<acme:list-column code="manager.project.list.label.project-abstract" path="projectAbstract" width="10%"/>
	<acme:list-column code="manager.project.list.label.indication" path="indication" width="10%"/>
	<acme:list-column code="manager.project.list.label.cost" path="cost" width="10%"/>
	<acme:list-column code="manager.project.list.label.link" path="link" width="10%"/>
	<acme:list-column code="manager.project.list.label.manager" path="manager" width="10%"/>
</acme:list>
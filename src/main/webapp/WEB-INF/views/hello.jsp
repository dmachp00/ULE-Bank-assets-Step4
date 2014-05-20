<%@ include file="/WEB-INF/views/include.jsp"%>

<html>
<head>
<title><fmt:message key="title" /></title>
</head>
<body>
	<h1>
		<fmt:message key="heading" />
	</h1>
	<p>
		<fmt:message key="greeting" />
		<c:out value="${model.now}" />
	</p>
	<h3>TableOfAmortization</h3>
	<c:forEach items="${model.loanIterators}" var="prod">
		<c:out value="${prod.tableOfAmortization}" />
		<i>$<c:out value="${prod.totals}" /></i>
		<br>
		<br>
	</c:forEach>
	<br>
	<a href="<c:url value="totalsincrease.htm"/>">Increase Prices</a>
	<br>
</body>
</html>
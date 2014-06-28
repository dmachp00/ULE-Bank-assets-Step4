<%@ include file="/WEB-INF/views/include.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<title><fmt:message key="title" /></title>
</head>
<body>
	<header>
		<a class="backHome" href="<c:url value="startpage.htm"/>" title="Home"></a>
		<a class="optionsHeader assets" href="<c:url value="assets.htm"/>"
			title="Assets"></a> <a class="optionsHeader brokerage"
			href="<c:url value="brokerage.htm"/>" title="brokerage"></a> <a
			class="optionsHeader liabilities"
			href="<c:url value="liabilities.htm"/>" title="Liabilities"></a> <a
			class="optionsHeader optionsHeaderSelected payments"
			href="<c:url value="payments.htm"/>" title="Payments"></a>
	</header>

	<nav class="menu">
		<ul>
			<li><a href="<c:url value=""/>">Recalculo de interes</a></li>
		</ul>
	</nav>
	<h1>
		<fmt:message key="priceincrease.heading" />
	</h1>
	Modify a new recalculation of interest: 
	<br>
	<br>
	<form:form method="post" commandName="ModifyInterest">
		<table width="95%" bgcolor="f8f8ff" border="0" cellspacing="0"
			cellpadding="5">
		</table>
		<br>
		<input type="submit" value="Execute">
	</form:form>
	<a href="<c:url value="fees.htm"/>">Home</a>

	<a href="<c:url value="assets.htm"/>">Home</a>
</body>
</html>
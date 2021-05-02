<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="home" value="/">

<html>
<body>
<div align="center">
<table style="width:800px;">
<tr>
	<td style="height:100px;"><%@ include file="/common/top.jsp" %></td>
</tr>
<tr>
	<td style="height:400px;"><c:import url="${home }${pathName }"></c:import></td>
</tr>
<tr>
	<td style="height:50px;"><%@ include file="/common/footer.jspf" %></td>
</tr>
</table>
</div>
</c:set>
</body>
</html>
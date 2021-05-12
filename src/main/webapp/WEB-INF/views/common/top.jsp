<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	/*
	 * request를 통해 session을 얻어올 수 있으며 내부 인자가 
	 * true인 경우 session이 없으면 별도로 생성하고
	 * false인 경우 별도로 생성하지 않고 null을 반환함.
	 */
	HttpSession topSession = request.getSession(false);
	String sessionId = (String)topSession.getAttribute("id");
%>
<c:url var="topHome" value="/"/>
<style type="text/css">
<!--

a:link{color:black;font-family:sans-serif;text-decoration:none;}
a:visited{color:black;font-family:sans-serif;text-decoration:none;}
a:hover{color:#cc3300; font-weight:bold; }
a:active{color:#ff00cc; text-decoration:underline; }
-->
</style>

<table width=800>
	<tr><td align="center" colspan=5><h1>CARE Lab</h1></td></tr>
	<tr align="right">
		<td width=600></td>
		<td><a href="${topHome}index?formpath=home">홈</a></td>
		<% if(sessionId==null){		%>
		<td><a href="${topHome}index?formpath=login">로그인</a></td>
		<td><a href="${topHome}index?formpath=member">회원가입</a></td>
		<%}else{ %>
		<td><a href="${topHome}login/logout">로그아웃</a></td>
		<td><a href="${topHome }index?formpath=board">게시판</a></td>
		<%} %>
	</tr>
	<tr><td align="center" colspan=5><hr/></td></tr>
</table>


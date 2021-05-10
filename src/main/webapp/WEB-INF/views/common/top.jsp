<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% 
	HttpSession topSession = request.getSession(false);
	String sessionId = (String) topSession.getAttribute("id");
	/*
	
%>
<c:set var="tophome" value="/" />




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
		<td><a href="${home }index.jsp?formpath=home">홈</a></td>
		
		<td width=600></td>
		<td></td>
		<%/*  클래스화 해서 출력하는것을 권함 */
		if(sessionId==null) { %>
		<td><a href="${home }index.jsp?formpath=login">로그인</a></td>
		<td><a href="${home }index.jsp?formpath=member">회원가입</a></td> 
		<% } else { %>
		<td><a href="${home }index.jsp?formpath=boardForm">게시판</a></td>
		<td><a href="${home }index.jsp?formpath=logoutProc">로그아웃</a></td> 
		<% } %>
		
		<c:set var="id" scope="session" value="${id }" />
		
		<c:choose>
		<c:when test= "${id!=null }"><td><a href="${home }index.jsp?formpath=login">${id }님</a></td></c:when>
		<td><a href="${home }index.jsp?formpath=boardForm">게시판</a></td>
		<td><a href="${home }index.jsp?formpath=logoutProc">로그아웃</a></td>
		
		<c:otherwise>
		<td><a href="${home }index.jsp?formpath=login">로그인</a></td>
		<td><a href="${home }index.jsp?formpath=member">회원가입</a></td>
		</c:otherwise></c:choose>
	
		
	</tr>
	<tr><td align="center" colspan=5><hr/></td></tr>
</table>


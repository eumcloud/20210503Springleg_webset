<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url var="home" value="/"/>
<head><script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(()=>{
	
})

</script>

</head>
<center>
<table style="width: 650px; ">
	<tr>
		<td style="width: 300px; height:40px;" valign="middle"><h2>${title }</h2></td>
		<td style="width: 350px; height:40px;" align="right" valign="bottom">${writedate }</td>
	</tr>
	<tr>
		<td colspan=2><hr/></td>
	</tr>
	<tr>
		<td  style="width: 300px; height:40px;" valign="top">${id }</td>
		<td style="width: 350px; height:40px;" align="right" valign="top">첨부파일</td>
	</tr>
	<tr>
		<td colspan=2 style="width: 650px; height: 300px" valign="top">
		<pre>
${contents }
		</pre>
		</td>
	</tr>
	<tr>
		<td colspan=2><hr/></td>
	</tr>
	<tr>
		<td colspan=2 align="right">
			<button style="width: 60px; " onclick="${home}/Board/write">글쓰기</button>
			<button style="width: 60px; " onclick="${home}/Board/reply">답글</button>
			<button style="width: 60px; " onclick="${home}/Board/modify">수정</button>
			<button style="width: 60px; " onclick="${home}/Board/delete">삭제</button>
			<button style="width: 60px; " onclick="${home}/Board/listview">목록</button>
		</td>
	</tr>
</table>
</center>
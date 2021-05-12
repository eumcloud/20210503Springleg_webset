<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url var="home" value="/"/>
<head><script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(()=>{
	function pagefrm(id){
		let frm = ${'#'+id};
		frm.action="${home}/Board/"+frm;
		frm.submit;
	}
})

</script>

</head>
<center><c:set var="read" value="${read }"/>
<table style="width: 650px; ">
	<tr>
		<td style="width: 300px; height:40px;" valign="middle"><h2>${read.title }</h2></td>
		<td style="width: 350px; height:40px;" align="right" valign="bottom">${read.writedate }</td>
	</tr>
	<tr>
		<td colspan=2><hr/></td>
	</tr>
	<tr>
		<td  style="width: 300px; height:40px;" valign="top">${read.id }</td>
		<c:forEach var="attachMap" items="${attachLst }">
		<td style="width: 350px; height:40px;" align="right" valign="top">
		<a href="${home }resources/upload/${attachMap.SYSTEMFILE }">${attachMap.ORIGINFILE }</a>
		</td></c:forEach>
	</tr>
	<tr>
		<td colspan=2 style="width: 650px; height: 300px" valign="top">
		<pre>${read.contents }</pre>
		</td>
	</tr>
	<tr>
		<td colspan=2><hr/></td>
	</tr>
	<tr>
		<td colspan=2 align="right">
			<button style="width: 60px; " id="write" onclick="pagefrm(write);">글쓰기</button>
			<button style="width: 60px; " id="reply" onclick="pagefrm(reply);">답글</button>
			<button style="width: 60px; " id="modify" onclick="pagefrm(modify);">수정</button>
			<button style="width: 60px; " id="delete" onclick="pagefrm(delete);">삭제</button>
			<button style="width: 60px; " id="listview" onclick="pagefrm(listview);">목록</button>
		</td>
	</tr>
</table>
</center>
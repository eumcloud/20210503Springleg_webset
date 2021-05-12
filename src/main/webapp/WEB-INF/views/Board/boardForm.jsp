<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url var="home" value="/"/>
<head><script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(()=>{ /*  콜백 document*/
	
	$("div.title").css("cursor", "pointer").click(()=>{
		/*  클릭시 no값 가져오기*/
		alert($(this)).attr('id'));/* div.title로 값을 찾을 수 있지만 전체 글이 div.title이라 뭘 클릭해도 맨위에것이 나온다 따라서 this로 불러오기 */
		$(this).attr("param");
	}
});

</script></head>
<center>
<form action="${home }board/write" method="post">
<table style="width: 650px; ">
	<thead>
	<tr>
		<th style="width: 40px; height:20px;" align="center">선택</th>
		<th style="width: 330px; height:20px;" align="center">제 목</th>
		<th style="width: 80px; height:20px;" align="center">작성자</th>
		<th style="width: 120px; height:20px;" align="center">작성일</th>
		<th style="width: 80px; height:20px;" align="center">조회수</th>
	</tr>
	</thead>
	<tr>
		<td style="width: 40px; height:20px;" align="center"><hr/></td>
		<td style="width: 330px; height:20px;" align="center"><hr/></td>
		<td style="width: 80px; height:20px;" align="center"><hr/></td>
		<td style="width: 120px; height:20px;" align="center"><hr/></td>
		<td style="width: 80px; height:20px;" align="center"><hr/></td>
	</tr>
	<c:forEach var="board" items="${boardLst }">
	<tr>
		<td style="width: 40px; height:40px;" align="center"><input type="checkbox"/></td>
		<td style="width: 330px; height:40px;" id="${board.no }" param="test" class="title" align="center"><pre><a href="/Board/viewForm/${no }">${board.title }</a></pre></td>
		<td style="width: 80px; height:40px;" align="center">${ board.id}</td>
		<td style="width: 120px; height:40px;" align="center">${board.writedate }</td>
		<td style="width: 80px; height:40px;" align="center">${board.hit }</td>
	</tr></c:forEach>
	<tr><td colspan=5><hr/></td></tr>
	<tr>
		<td colspan=2><input type="checkbox"/>전체선택</td>
		<td colspan=3 align="right">
			<input type="button" value='삭제' style="width: 100px; "/>
			<button style="width: 100px; ">글쓰기</button>
		</td>
	</tr>
	<tr><td colspan=5><hr/></td></tr>
</table>
</form>
이전 1 2 3 4 다음
<table>
<tr>
<td>
	<select>
		<option>전체</option>
		<option>제목</option>
		<option>작성자</option>
	</select>
	<input type=text name='search'/>
	<input type=button name='searchBtn' value='검색' style="width: 80px; "/>
</td>
</tr>
</table>
</center>
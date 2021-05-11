<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="home" value="/"  />
<center><form action="${home }/Board/write">
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
	<c:forEach var="Lst" items="${BoardLst }">
	
	<tr>
		<td style="width: 40px; height:40px;" align="center"><input type="checkbox"/><c:set var="no" value="${Lst.no }" /></td>
		<td style="width: 330px; height:40px;" align="center"><c:set var="title" value="${Lst.title }" /></td>
		<td style="width: 80px; height:40px;" align="center"><c:set var="id" value="${Lst.id }" /></td>
		<td style="width: 120px; height:40px;" align="center"><c:set var="date" value="${Lst.date }" /></td>
		<td style="width: 80px; height:40px;" align="center">1</td>
	</tr></c:forEach>

	<tr><td colspan=5><hr/></td></tr>
	<tr>
		<td colspan=2><input type="checkbox"/>전체선택</td>
		<td colspan=3 align="right">
			<input type="button" value='삭제' style="width: 100px; "/>
			
			<button style="width:100px;">글쓰기 </button>
		</td>
	</tr>
	<tr><td colspan=5><hr/></td></tr>
</table>
<script type="text/javascript">
function getWrite(name){
	var name = document.getElementByName(write);
	name.action='${home}/Board/writeForm';
	name.submit;
}
</script>

${before}${pagenumber } ${next}
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
</table></form>
</center>
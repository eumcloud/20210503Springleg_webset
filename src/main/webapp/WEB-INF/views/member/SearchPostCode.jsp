<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<style type="text/css">
.list_over {overflow:auto;  background-color:skyblue; }
.list_out { background-color:#FFFFFF; }
</style>
<script type="text/javascript">
function setParentAddr(zipcode, address){
	
	opener.document.getElementById("zipcode").value=zipcode;
	opener.document.getElementById("addr1").value=address;
	window.close();
}
</script>
<body>
<form action="searchZipcode" method="post">
<h1>
동면<input type=text name='addr'/>
<input type=submit value="우편번호 검색"/>
</h1>
</form>

<br/>
<c:forEach var="zip" items="${zipcodeLst}">
<c:set var='zipcode' value="${zip.zipcode }"/>
<c:set var='address' value="${zip.sido }${zip.sigungu }${zip.doro }"/>
<div onmouseover="this.className='list_over'" onmouseout="this.className='list_out'"
onclick="setParentAddr('${zipcode}', '${address }');">
${zipcode}===${address }
<br/></div>
</c:forEach>
<!-- DTO -->
Class Mover{
private String mover;
private String mout;
private String 
}

public String mouseSet(Mover mover){
tag = "<style>.${mover}{overflow:auto;background-color:skyblue} .${mout}{background-color="#fff"}</style>"
tag+= "<script type="text/javascript">${function}</script>"
tag +="<div onmouseover='this.className=${mover}' onmouseout ='this.className=${mout}'
onclick='${function}'>"

return tag;
}
</div>

</body>
</html>
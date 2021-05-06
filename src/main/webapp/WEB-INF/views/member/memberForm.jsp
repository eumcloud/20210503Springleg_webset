<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="home2" value="/"/>
<c:url var="home" value="/"/>

<center>

<script type="text/javascript" src="http://code.jquery.com/jquery-2.1.4.min.js">
function SearchPostCode(cmd){
	window.name = "우편번호 검색";
	var option = "top=500, left=500, width=400, height=400";
	window.open = (cmd, "_blank", option);
}
</script>
<form action="memberProc" method="post">

<h3>${authNumOk }</h3>
<table>
	<tr><td colspan="4" align="center"><hr/>필수 사항<hr/></td></tr>
	<tr>
		<td align='right' height=40>아이디</td>
		<td>
			<input type=text name='id' placeholder='id 입력'  value="${member.id }" /> 
		</td>
		<td colspan="2"><button formaction="${home }membership/isExistID">중복 확인</button></td>
	</tr>
	<tr>
		<td align='right' height=40>패스워드</td>
		<td>
			<input type=text name='pw' placeholder='pw 입력'/> 
		</td>
		<td align='right'>패스워드 확인</td>
		<td>
			<input type=text name='pwOk' placeholder='pw 입력'/> 
		</td>
	</tr>
	<tr>
		<td align='right' height=40>E-Mail</td>
		<td>
			<input type=text name='email' placeholder='E-Mail 입력' value="${member.email }"/> 
		</td>
		<td colspan="2"><button formaction="${home}membership/sendAuth">인증번호 전송</button></td>
	</tr>
	<tr>
		<td align='right'>인증번호</td>
		<td>
			<input type=text name='CauthNum' placeholder='인증번호 입력'/> 
		</td>
		<td colspan="2"><button formaction="${home }membership/authConfirm">인증번호 확인</button></td>
	</tr>
	<tr><td colspan="4" align="center"><hr/>선택 사항<hr/></td></tr>
	<tr>
		<td align='right'>우편번호</td>
		<td>
			<input type=text name='zipcode' readonly="readonly"/> 
		</td>
		<td colspan="2"><input type="button" value="우편번호 검색" onclick="SerachPostCode(${home}login);"></td>
	</tr>
	<tr>
		<td align='right'>주소</td>
		<td colspan="3">
			<input type=text name='addr1' readonly="readonly" style="width: 475px; "/> 
		</td>
	</tr>
	<tr>
		<td align='right'>상세주소</td>
		<td colspan="3">
			<input type=text name='addr2' style="width: 475px; "/> 
		</td>
	</tr>
	<tr>
		<td align='right' width=120>성 별</td>
		<td colspan="3">
			<input type=radio name='gender' value='n' checked="checked"/>선택안함
			<input type=radio name='gender' value='m' />남자 
			<input type=radio name='gender' value='w' />여자 
		</td>
	</tr>
	
	<tr>
		<td align='center' height=40 colspan=4>
			<input type=submit value='로그인' style="width: 120px; "/>
			<input type=reset value='취소' style="width: 120px; "/>	 
		</td>
	</tr>
</table>
</form>
</center>
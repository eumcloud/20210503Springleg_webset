<%@ page contentType="text/html; charset=UTF-8"%>
<style>
h3{
color:skyblue;
}
</style>
<center>
<table>
<h3>${msg }</h3>
<form action="${home}login/loginProc" method="post">
	<tr>
		<td>아이디</td>
		<td><input type=text name='id' placeholder='ID 입력'/></td>
	</tr>
	<tr>
		<td>패스워드</td>
		<td><input type=password name='pw' placeholder='PW 입력'/></td>
	</tr>
	<tr>
		<td colspan=2 align='center'>
			<input type=submit value='로그인' style="width: 86px; "/>
			<input type=reset value='취소' style="width: 86px; "/> 
		</td>
	</tr>
</table>

</form>
</center>

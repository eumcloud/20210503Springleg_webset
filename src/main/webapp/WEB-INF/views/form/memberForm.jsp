<%@ page contentType="text/html; charset=UTF-8"%>

<center>
<table>
	<tr>
		<td align='right' height=40>아이디</td>
		<td>
			<input type=text name='id' placeholder='id 입력'/> 
		</td>
		<td colspan="2"><button >중복 확인</button></td>
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
			<input type=text name='email' placeholder='E-Mail 입력'/> 
		</td>
		<td colspan="2"><button >인증번호 전송</button></td>
	</tr>
	<tr>
		<td align='right'>인증번호</td>
		<td>
			<input type=text name='authNum' placeholder='인증번호 입력'/> 
		</td>
		<td colspan="2"><button >인증번호 확인</button></td>
	</tr>
	<tr>
		<td align='right'>우편번호</td>
		<td>
			<input type=text name='zipcode' readonly="readonly"/> 
		</td>
		<td colspan="2"><button >우편번호 검색</button></td>
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
			<input type=radio name='gender' value='m' checked="checked"/>남자
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
</center>
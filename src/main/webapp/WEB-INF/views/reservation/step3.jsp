<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** 예약자 정보 확인 **</title>
</head>
<body>

회원 DB에서 정보가져오기 
생년월일 일치하면 다음단계 넘어가도록 설정 
// Pmember에 맞게 value 수정

<table><form action="rpconf" method="post" id="rpcForm">
	<tr height="40"><td bgcolor="PaleGreen">이름</td>
		<td><input type="text" name="name" size="20" value="${Apple.name}" readonly></td>
	</tr>
	<tr height="40"><td bgcolor="PaleGreen">생년월일</td>
		<td><input type="text" name="birth" size="20" value="${Apple.birth}" placeholder="예) 19920919 (YYYYMMDD)"></td>
	</tr>
	<tr height="40"><td bgcolor="PaleGreen">연락처</td>
		<td><input type="text" name="tel" size="20" value="${Apple.tel}" readonly></td>
	</tr>
	<tr height="40"><td bgcolor="PaleGreen">이메일</td>
		<td><input type="text" name="email" size="20" value="${Apple.email}" readonly></td>
	</tr>
</form></table>


</body>
</html>
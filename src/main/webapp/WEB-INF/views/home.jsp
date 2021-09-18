<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>Home</title>
<link rel="stylesheet" type="text/css" href="resources/myLib/myStyle.css" >
<script src="resources/myLib/jquery-3.2.1.min.js"></script>
</head>
<body>
<h1>TeamProject Home</h1>
<c:if test="${loginID != null }">
  <b>${loginName}</b>님 환영합니다.
</c:if><br>
<c:if test="${message != null}">
  ${message}
</c:if><br>
<hr>
<c:if test="${loginID == null}">
	<a href="loginf">로그인</a>&nbsp;&nbsp;
	<a href="joinf">회원가입</a>&nbsp;&nbsp;<br>
	<a href="cloginf">사업자로그인</a>&nbsp;&nbsp;
	<a href="cjoinf">사업자회원가입</a>&nbsp;&nbsp;
</c:if>
<c:if test="${loginID != null}">
	<a href="pdetail">MyPage</a>&nbsp;&nbsp;
	<a href="logout">로그아웃</a><br><hr>
	<a href="plist">회원관리</a>&nbsp;
	<a href="pcplist">회원관리_서치</a>&nbsp;
</c:if>
<hr>
<a href="rmainf">예약하기</a><br>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** 예약일자/시간 선택 ** </title>
</head>
<body>

사업자 DB 행사기간 시작/끝 받아서 배열로 달력 시작/끝 설정
사업자 DB 이용시간 시작/끝 받아서 1시간 간격 배열처리 label 데이터 입력


<form action="rpdate" id="rpdatef" method="post">                        
    <div class="rpdate-form">
        <dl>
            <dt>예약일자</dt>
            <dd>
                <div class="reservation-date">
                    <input type="text" class="rp-date" id="rpdate" name="rpdate" style="width:176px;" placeholder="선택일자" readonly>
                </div>
                <script src="resources/myLib/jquery-3.2.1.min.js"></script>
                <link rel="stylesheet" type="text/css" href="resources/myLib/myStyle.css">
                <script>
                ; (function ($, win, doc, undefined) {
                    $(doc).ready(function () {
                        $(".reservation-date .rp-date").datepicker({
                            showOn: "button",
                            buttonImage: "/Images/contents/calendar.png",
                            buttonImageOnly: true,
                            dateFormat: "yyyy-mm-dd",
                            minDate: 0
                            });
                        $.datepicker.setDefaults({
                            prevText: '이전 달',
                            nextText: '다음 달',
                            monthNames: ['1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11', '12'], //월 이름
                            monthNamesShort: ['1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11', '12'], //
                            dayNames: ['일', '월', '화', '수', '목', '금', '토'],
                            dayNamesShort: ['일', '월', '화', '수', '목', '금', '토'],
                            dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
                            showMonthAfterYear: true,
                            yearSuffix: '.'
                        });
                    });
                })(jQuery, window, document);
                </script>
            </dd>
        </dl>
        <dl>
            <dt>선택시간</dt>
            <dd>
                <div class="reservation-time">
                <div class="rp-time">
                    <input type="radio" name="rptime" id="time1" value="1">
                    <label for="time1">10:00</label>
                </div>
                <div class="rp-time">
                    <input type="radio" name="rptime" id="time2" value="2">
                    <label for="time2">11:00</label>
                </div>
                <div class="rp-time">
                    <input type="radio" name="rptime" id="time3" value="3">
                    <label for="time3">12:00</label>
                </div>
                <div class="rp-time">
                    <input type="radio" name="rptime" id="time4" value="4">
                    <label for="time4">1:00</label>
                </div>
                </div>
            </dd>
        </dl>
    <div class="btn-wrap">
        <a href="" class="">다음단계</a>
    </div>
    </div>
</form>

</body>
</html>
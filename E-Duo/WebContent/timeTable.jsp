<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "mytag" tagdir = "/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shoppers &mdash; Colorlib e-Commerce Template</title>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Mukta:300,400,700"> 
<link rel="stylesheet" href="fonts/icomoon/style.css">

<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/magnific-popup.css">
<link rel="stylesheet" href="css/jquery-ui.css">
<link rel="stylesheet" href="css/owl.carousel.min.css">
<link rel="stylesheet" href="css/owl.theme.default.min.css">

<link rel="stylesheet" href="css/aos.css">

<link rel="stylesheet" href="css/style.css">
<style>
	#subjects {
		position: fixed;
		z-index: 99;
		bottom: 0;
		width: 100%;
		background-color: #fff;
		overflow: hidden;
	}
	th {
		width: 80px;
	}
	tr.dates {
		height: 40px;
		background-color: #cae1f2;
	}
	tr.content:hover {
		background-color: rgba(99, 99, 99, 0.3);
		cursor: pointer;
	}
	.date {
		text-align: center;
	}
	.time {
		box-sizing: border-box;
		height: 100px;
		border-bottom: 1px solid lightgrey;
		text-align: center;
		line-height: 100px;
	}
	.times .time:last-of-type {
		border-bottom: 0px;
	}
	.area {
		border-top: 1px solid lightgrey;
		height: 100px;
	}
	.area:first-child {
		border-top: 0px;
	}
	.col {
		position: absolute;
		z-index: 20;
		padding: 0;
	}
	.subject {
		position: absolute;
		overflow: hidden;
		box-sizing: border-box;
		width: 100%;
		border: 1px solid lightgrey;
		border-width: 1px 0;
		z-index: 10;
		background-color: yellow;
	}
	ul.status {
		list-style: none;
	}
	ul.status li.remove {
		background-image: url(images/remove.png);
	}
	ul.status li {
		float: left;
		width: 15px;
		height: 15px;
		background-repeat: no-repeat;
		background-position: center center;
		cursor: pointer;
	}
</style>
</head>
<body>
	<div class="site-wrap">
    <mytag:header />

    <div class="bg-light py-3">
      <div class="container">
        <div class="row">
          <div class="col-md-12 mb-0"><a href="index.html">Home</a> <span class="mx-2 mb-0">/</span> <strong class="text-black">About</strong></div>
        </div>
      </div>
    </div> 

    <div class="site-section border-bottom" data-aos="fade">
      <div class="container">
      <div class="row">
          <div class="col-md-12">
            <div class="site-section site-blocks-2">
                <div class="row" style = "margin: 0 auto;">
                  <c:choose>
                  	<c:when test = "${grade eq 1 and semester eq 1}">
	                  <div class="col-sm-6 col-md-6 col-lg-3-2 mb-4 mb-lg-0" id="g1s1" data-aos="fade" data-aos-delay="" style = "height: 40px; text-align: center; line-height: 40px; margin-right: 0.5%; background-color: #dee2e6;">
		                  <a href="timetablePage.timetable?grade=1&semester=1">
		                    <div>
		                      <span class="text-uppercase text-black">1학년 1학기</span>
		                      <!-- <h3><span class = "text-black">1학년 1학기</span></h3> -->
		                    </div>
		                  </a>
	                  </div>
                  	</c:when>
                  	<c:otherwise>
                  	  <div class="col-sm-6 col-md-6 col-lg-3-2 mb-4 mb-lg-0" id="g1s1" data-aos="fade" data-aos-delay="" style = "height: 40px; text-align: center; line-height: 40px; margin-right: 0.5%;">
		                  <a href="timetablePage.timetable?grade=1&semester=1">
		                    <div>
		                      <span class="text-uppercase text-black">1학년 1학기</span>
		                      <!-- <h3><span class = "text-black">1학년 1학기</span></h3> -->
		                    </div>
		                  </a>
	                  </div>
                  	</c:otherwise>
                  </c:choose>
                  <c:choose>
                  	<c:when test = "${grade eq 1 and semester eq 2}">
	                  <div class="col-sm-6 col-md-6 col-lg-3-2 mb-4 mb-lg-0" id="g1s2" data-aos="fade" data-aos-delay="" style = "height: 40px; text-align: center; line-height: 40px; margin-right: 0.5%; background-color: #dee2e6;">
		                  <a href="timetablePage.timetable?grade=1&semester=2">
		                    <div>
		                      <span class="text-uppercase text-black">1학년 2학기</span>
		                      <!-- <h3><span class = "text-black">1학년 1학기</span></h3> -->
		                    </div>
		                  </a>
	                  </div>
                  	</c:when>
                  	<c:otherwise>
                  	  <div class="col-sm-6 col-md-6 col-lg-3-2 mb-4 mb-lg-0" id="g1s2" data-aos="fade" data-aos-delay="" style = "height: 40px; text-align: center; line-height: 40px; margin-right: 0.5%;">
		                  <a href="timetablePage.timetable?grade=1&semester=2">
		                    <div>
		                      <span class="text-uppercase text-black">1학년 2학기</span>
		                      <!-- <h3><span class = "text-black">1학년 1학기</span></h3> -->
		                    </div>
		                  </a>
	                  </div>
                  	</c:otherwise>
                  </c:choose>
                  <c:choose>
                  	<c:when test = "${grade eq 2 and semester eq 1}">
	                  <div class="col-sm-6 col-md-6 col-lg-3-2 mb-4 mb-lg-0" id="g2s1" data-aos="fade" data-aos-delay="" style = "height: 40px; text-align: center; line-height: 40px; margin-right: 0.5%; background-color: #dee2e6;">
		                  <a href="timetablePage.timetable?grade=2&semester=1">
		                    <div>
		                      <span class="text-uppercase text-black">2학년 1학기</span>
		                      <!-- <h3><span class = "text-black">1학년 1학기</span></h3> -->
		                    </div>
		                  </a>
	                  </div>
                  	</c:when>
                  	<c:otherwise>
                  	  <div class="col-sm-6 col-md-6 col-lg-3-2 mb-4 mb-lg-0" id="g2s1" data-aos="fade" data-aos-delay="" style = "height: 40px; text-align: center; line-height: 40px; margin-right: 0.5%;">
		                  <a href="timetablePage.timetable?grade=2&semester=1">
		                    <div>
		                      <span class="text-uppercase text-black">2학년 1학기</span>
		                      <!-- <h3><span class = "text-black">1학년 1학기</span></h3> -->
		                    </div>
		                  </a>
	                  </div>
                  	</c:otherwise>
                  </c:choose>
                  <c:choose>
                  	<c:when test = "${grade eq 2 and semester eq 2}">
	                  <div class="col-sm-6 col-md-6 col-lg-3-2 mb-4 mb-lg-0" id="g2s2" data-aos="fade" data-aos-delay="" style = "height: 40px; text-align: center; line-height: 40px; margin-right: 0.5%; background-color: #dee2e6;">
		                  <a href="timetablePage.timetable?grade=2&semester=2">
		                    <div>
		                      <span class="text-uppercase text-black">2학년 2학기</span>
		                      <!-- <h3><span class = "text-black">1학년 1학기</span></h3> -->
		                    </div>
		                  </a>
	                  </div>
                  	</c:when>
                  	<c:otherwise>
                  	  <div class="col-sm-6 col-md-6 col-lg-3-2 mb-4 mb-lg-0" id="g2s2" data-aos="fade" data-aos-delay="" style = "height: 40px; text-align: center; line-height: 40px; margin-right: 0.5%;">
		                  <a href="timetablePage.timetable?grade=2&semester=2">
		                    <div>
		                      <span class="text-uppercase text-black">2학년 2학기</span>
		                      <!-- <h3><span class = "text-black">1학년 1학기</span></h3> -->
		                    </div>
		                  </a>
	                  </div>
                  	</c:otherwise>
                  </c:choose>
                  <c:choose>
                  	<c:when test = "${grade eq 3 and semester eq 1}">
	                  <div class="col-sm-6 col-md-6 col-lg-3-2 mb-4 mb-lg-0" id="g3s1" data-aos="fade" data-aos-delay="" style = "height: 40px; text-align: center; line-height: 40px; margin-right: 0.5%; background-color: #dee2e6;">
		                  <a href="timetablePage.timetable?grade=3&semester=1">
		                    <div>
		                      <span class="text-uppercase text-black">3학년 1학기</span>
		                      <!-- <h3><span class = "text-black">1학년 1학기</span></h3> -->
		                    </div>
		                  </a>
	                  </div>
                  	</c:when>
                  	<c:otherwise>
                  	  <div class="col-sm-6 col-md-6 col-lg-3-2 mb-4 mb-lg-0" id="g3s1" data-aos="fade" data-aos-delay="" style = "height: 40px; text-align: center; line-height: 40px; margin-right: 0.5%;">
		                  <a href="timetablePage.timetable?grade=3&semester=1">
		                    <div>
		                      <span class="text-uppercase text-black">3학년 1학기</span>
		                      <!-- <h3><span class = "text-black">1학년 1학기</span></h3> -->
		                    </div>
		                  </a>
	                  </div>
                  	</c:otherwise>
                  </c:choose>
                  <c:choose>
                  	<c:when test = "${grade eq 3 and semester eq 2}">
	                  <div class="col-sm-6 col-md-6 col-lg-3-2 mb-4 mb-lg-0" id="g3s2" data-aos="fade" data-aos-delay="" style = "height: 40px; text-align: center; line-height: 40px; margin-right: 0.5%; background-color: #dee2e6;">
		                  <a href="timetablePage.timetable?grade=3&semester=2">
		                    <div>
		                      <span class="text-uppercase text-black">3학년 2학기</span>
		                      <!-- <h3><span class = "text-black">1학년 1학기</span></h3> -->
		                    </div>
		                  </a>
	                  </div>
                  	</c:when>
                  	<c:otherwise>
                  	  <div class="col-sm-6 col-md-6 col-lg-3-2 mb-4 mb-lg-0" id="g3s2" data-aos="fade" data-aos-delay="" style = "height: 40px; text-align: center; line-height: 40px; margin-right: 0.5%;">
		                  <a href="timetablePage.timetable?grade=3&semester=2">
		                    <div>
		                      <span class="text-uppercase text-black">3학년 2학기</span>
		                      <!-- <h3><span class = "text-black">1학년 1학기</span></h3> -->
		                    </div>
		                  </a>
	                  </div>
                  	</c:otherwise>
                  </c:choose>
                  <c:choose>
                  	<c:when test = "${grade eq 4 and semester eq 1}">
	                  <div class="col-sm-6 col-md-6 col-lg-3-2 mb-4 mb-lg-0" id="g4s1" data-aos="fade" data-aos-delay="" style = "height: 40px; text-align: center; line-height: 40px; margin-right: 0.5%; background-color: #dee2e6;">
		                  <a href="timetablePage.timetable?grade=4&semester=1">
		                    <div>
		                      <span class="text-uppercase text-black">4학년 1학기</span>
		                      <!-- <h3><span class = "text-black">1학년 1학기</span></h3> -->
		                    </div>
		                  </a>
	                  </div>
                  	</c:when>
                  	<c:otherwise>
                  	  <div class="col-sm-6 col-md-6 col-lg-3-2 mb-4 mb-lg-0" id="g4s1" data-aos="fade" data-aos-delay="" style = "height: 40px; text-align: center; line-height: 40px; margin-right: 0.5%;">
		                  <a href="timetablePage.timetable?grade=4&semester=1">
		                    <div>
		                      <span class="text-uppercase text-black">4학년 1학기</span>
		                      <!-- <h3><span class = "text-black">1학년 1학기</span></h3> -->
		                    </div>
		                  </a>
	                  </div>
                  	</c:otherwise>
                  </c:choose>
                  <c:choose>
                  	<c:when test = "${grade eq 4 and semester eq 2}">
	                  <div class="col-sm-6 col-md-6 col-lg-3-2 mb-4 mb-lg-0" id="g4s2" data-aos="fade" data-aos-delay="" style = "height: 40px; text-align: center; line-height: 40px; margin-right: 0.5%; background-color: #dee2e6;">
		                  <a href="timetablePage.timetable?grade=4&semester=2">
		                    <div>
		                      <span class="text-uppercase text-black">4학년 2학기</span>
		                      <!-- <h3><span class = "text-black">1학년 1학기</span></h3> -->
		                    </div>
		                  </a>
	                  </div>
                  	</c:when>
                  	<c:otherwise>
                  	  <div class="col-sm-6 col-md-6 col-lg-3-2 mb-4 mb-lg-0" id="g4s2" data-aos="fade" data-aos-delay="" style = "height: 40px; text-align: center; line-height: 40px; margin-right: 0.5%;">
		                  <a href="timetablePage.timetable?grade=4&semester=2">
		                    <div>
		                      <span class="text-uppercase text-black">4학년 2학기</span>
		                      <!-- <h3><span class = "text-black">1학년 1학기</span></h3> -->
		                    </div>
		                  </a>
	                  </div>
                  	</c:otherwise>
                  </c:choose>
                </div>
            </div>
          </div>
        </div>
        <div class="row mb-5">
          <div class="col-md-12">
            <h3 style = "text-align:center;">시간표</h3>
            <div>
            	<table id="time_table" border = "1" width = "100%" style="border-color: lightgrey;">
            		<tbody>
            			<tr class="dates">
            				<th></th>
            				<td class="date">월</td>
            				<td class="date">화</td>
            				<td class="date">수</td>
            				<td class="date">목</td>
            				<td class="date">금</td>
            				<td class="date" style="display: none;">토</td>
            			</tr>
            		</tbody>
            	</table>
            </div>
            <div>
           		<table border = "1" width = "100%" height = "1500" style = "border-color:lightgrey;">
           			<tbody>
           				<tr>
           					<th>
           						<div class="times">
           							<div class="time">오전 9시</div>
           							<div class="time">오전 10시</div>
           							<div class="time">오전 11시</div>
           							<div class="time">오후 12시</div>
           							<div class="time">오후 1시</div>
           							<div class="time">오후 2시</div>
           							<div class="time">오후 3시</div>
           							<div class="time">오후 4시</div>
           							<div class="time">오후 5시</div>
           							<div class="time">오후 6시</div>
           							<div class="time">오후 7시</div>
           							<div class="time">오후 8시</div>
           							<div class="time">오후 9시</div>
           							<div class="time">오후 10시</div>
           							<div class="time">오후 11시</div>
           						</div>
           					</th>
           					<td id="MON">
           						<div class="col" style="width: 168px;"></div>
           						<div>
           							<div class="area"></div>
           							<div class="area"></div>
           							<div class="area"></div>
           							<div class="area"></div>
           							<div class="area"></div>
           							<div class="area"></div>
           							<div class="area"></div>
           							<div class="area"></div>
           							<div class="area"></div>
           							<div class="area"></div>
           							<div class="area"></div>
           							<div class="area"></div>
           							<div class="area"></div>
           							<div class="area"></div>
           							<div class="area"></div>
           						</div>
           					</td>
           					<td id="TUE">
           						<div class="col" style="width: 168px;"></div>
           						<div>
           							<div class="area"></div>
           							<div class="area"></div>
           							<div class="area"></div>
           							<div class="area"></div>
           							<div class="area"></div>
           							<div class="area"></div>
           							<div class="area"></div>
           							<div class="area"></div>
           							<div class="area"></div>
           							<div class="area"></div>
           							<div class="area"></div>
           							<div class="area"></div>
           							<div class="area"></div>
           							<div class="area"></div>
           							<div class="area"></div>
           						</div>
           					</td>
           					<td id="WED">
           						<div class="col" style="width: 168px;"></div>
           						<div>
           							<div class="area"></div>
           							<div class="area"></div>
           							<div class="area"></div>
           							<div class="area"></div>
           							<div class="area"></div>
           							<div class="area"></div>
           							<div class="area"></div>
           							<div class="area"></div>
           							<div class="area"></div>
           							<div class="area"></div>
           							<div class="area"></div>
           							<div class="area"></div>
           							<div class="area"></div>
           							<div class="area"></div>
           							<div class="area"></div>
           						</div>
           					</td>
           					<td id="THU">
           						<div class="col" style="width: 168px;"></div>
           						<div>
           							<div class="area"></div>
           							<div class="area"></div>
           							<div class="area"></div>
           							<div class="area"></div>
           							<div class="area"></div>
           							<div class="area"></div>
           							<div class="area"></div>
           							<div class="area"></div>
           							<div class="area"></div>
           							<div class="area"></div>
           							<div class="area"></div>
           							<div class="area"></div>
           							<div class="area"></div>
           							<div class="area"></div>
           							<div class="area"></div>
           						</div>
           					</td>
           					<td id="FRI">
           						<div class="col" style="width: 168px;"></div>
           						<div>
           							<div class="area"></div>
           							<div class="area"></div>
           							<div class="area"></div>
           							<div class="area"></div>
           							<div class="area"></div>
           							<div class="area"></div>
           							<div class="area"></div>
           							<div class="area"></div>
           							<div class="area"></div>
           							<div class="area"></div>
           							<div class="area"></div>
           							<div class="area"></div>
           							<div class="area"></div>
           							<div class="area"></div>
           							<div class="area"></div>
           						</div>
           					</td>
           					<td id="SAT" style="display: none;">
           						<div class="col" style="width: 168px;"></div>
           						<div>
           							<div class="area"></div>
           							<div class="area"></div>
           							<div class="area"></div>
           							<div class="area"></div>
           							<div class="area"></div>
           							<div class="area"></div>
           							<div class="area"></div>
           							<div class="area"></div>
           							<div class="area"></div>
           							<div class="area"></div>
           							<div class="area"></div>
           							<div class="area"></div>
           							<div class="area"></div>
           							<div class="area"></div>
           							<div class="area"></div>
           						</div>
           					</td>
           				</tr>
           			</tbody>
           		</table>
            </div>
            <br><br>
            <div style = "text-align:right; font-size: 1.5rem; font-weight:bold;">
              <span style = "margin-left:5%;">이수 학점 : </span><span>${total_credit_num}</span>
              <span></span>
            </div>
            <div style = "margin-top:3%;">
              <input type = "button" class="btn btn-primary btn-lg" style="float: right;" onclick = "location.href = 'showCreditManage.cre?grade=${grade}&semester=${semester}'" value = "학점 관리 페이지로 이동">
              <input type = "button" class="btn btn-primary btn-lg" style="float: right; margin-right: 2%;" onclick = "getSubject(); return false;" value = "수업 목록에서 검색">
            </div>
          </div>
        </div>
      </div>
    </div>
	<!-- <div class="col-md-12" id="searchBtnTab" style="position: fixed; bottom: 0; display: block; width: 100%;">
	    <div class="form-group row" style="margin-top: 20px;">
	    	<div class="col-md-9" style="margin: 0 auto; text-align: center;">
	    		<input type="button" id="open_searchTab" class="btn btn-secondary btn-sm dropdown-toggle" style="display: inline-block; z-index: 99;" value="과목 추가하기" onclick="openSearchTab()">
	    	</div>
	    </div>
   	</div> -->
    <div class="col-md-12 border" id="subjects" style="position: fixed; display: none; width: 100%; overflow: scroll;">
      <div class="form-group row" style="margin-top: 20px;">
        <div class="col-md-9">
        	<input type="text" class="form-control" id="srch_subject" name="subject" style = "display: inline-block; width: 70%; margin-left: 20%;" placeholder = "과목을 입력하세요.">
        	<input type="button" id="searchSub" class="btn btn-secondary btn-sm dropdown-toggle" style="display: inline-block; width: 8%;" value="검색">
        </div>
        <div class="col-md-3">
        	<input type="button" id="close_tab" class="btn btn-secondary btn-sm dropdown-toggle" style="margin-left: 20%;" value="닫기" onclick="close_tab()">
        </div>
      </div>
      <div class="form-group" style="height: 150px; margin-top: 20px;">
        <div class="col-md-10" style="margin: 0 auto;">
          <table style="width: 100%;" id="subject_table" border="1">
            <tr>
              <th>학수번호</th>
              <th>과목명</th>
              <th>이수</th>
              <th>학점</th>
              <th>교수</th>
              <th>시간</th>
              <th>강의실</th>
            </tr>
          </table>
        </div>
      </div>
    </div>
    
    <mytag:footer />
    <div>
	    <div id="searchBtnTab" style="position: fixed; bottom: 0; display: block; width: 100%;">
		    <div class="form-group row" style="margin-top: 20px;">
		    	<div style="margin: 0 auto; text-align: center;">
		    		<input type="button" id="open_searchTab" class="btn btn-secondary btn-sm dropdown-toggle" style="display: inline-block; z-index: 99;" value="과목 추가하기" onclick="openSearchTab()">
		    	</div>
		    </div>
	   	</div>
   	</div>
  </div>

  <script src="js/jquery-3.3.1.min.js"></script>
  <script src="js/jquery-ui.js"></script>
  <script src="js/popper.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <script src="js/owl.carousel.min.js"></script>
  <script src="js/jquery.magnific-popup.min.js"></script>
  <script src="js/aos.js"></script>

  <script src="js/main.js"></script>
  <script>
  	function openSearchTab() {
  		document.getElementById("searchBtnTab").style.display = 'none';
  		document.getElementById("subjects").style.display = 'block';
  	}
  </script>
  <script>
    function close_tab() {
      document.getElementById("subjects").style.display = 'none';
      document.getElementById("searchBtnTab").style.display = 'block';
	}
  </script>
  <script>
	$('#searchSub').click(function(){
		let subject = $('#srch_subject').val();
		$.ajax({
			url : "getSubjects.timetable",
			type : "GET",
			data : {subject: subject},
			dataType : 'JSON',
			success : function(result){
				let data = JSON.parse(JSON.stringify(result));
				console.log(data);
				$("table#subject_table").children().remove();
				$('<tr><th>학수번호</th><th>과목명</th><th>이수</th><th>학점</th><th>교수</th><th>시간</th><th>강의실</th></tr>').appendTo($("#subject_table"));
				$.each(data, function(k, d) {
					$('<tr class="content" onclick=location.href="insertSubject.timetable?aca=' + d.academic_number
							+ '&grade=' + <%= request.getAttribute("grade") %> + '&semester=' + <%= request.getAttribute("semester") %> + '"><td>' + d.academic_number + '</td><td>' + d.subject_name + '</td>'
							+ '<td>' + d.sub_sort + '</td><td>' + d.credit_num + '</td><td>' + d.professor + '</td>'
							+ '<td>' + d.first_date + ' ' + d.first_start + '~' + d.first_end + '<br>'
							+ d.second_date + ' ' + d.second_start + '~' + d.second_end + '<br>'
							+ d.third_date + ' ' + d.third_start + '~' + d.third_end + '</td>'
							+ '<td>' + d.classroom + '</td>' + '</tr>').appendTo($("#subject_table"));
					/* $('<li><a href="javascript:void(0);" onclick="findUniv(\'' + k + '\',\'' + v + '\');">' + v + '</a></li>').val(k).text(v).appendTo($("#univ_list")); */
					/* $('<li onclick="findUniv(\'' + k + '\',\'' + v + '\');">' + v + '</li>').val(k).text(v).appendTo($("#sub_list")); */
					console.log(d.sub_id);
				});
			},
			error : function(){
				alert("서버요청실패");
			}
		});
	});
  </script>
  <script>
  	console.log('grade: ' + <%= request.getAttribute("grade") %>);
  	console.log('semester: ' + <%= request.getAttribute("semester") %>);
  </script>
  <script language="javaScript">
  	let table_datas = JSON.parse(JSON.stringify('${table_datas}'));
  	let newDiv, newDiv2, newDiv3;
  	let newPTag, newPTag2, newPTag3;
  	let parents, parents2, parents3;
  	let newUlTag, newUlTag2, newUlTag3;
  	let newHTag, newHTag2, newHTag3;
  	<c:forEach items="${table_datas}" var="item">
 		<c:if test="${not empty item.subjectVO.first_date}">
  			newDiv = document.createElement("div");
  	  		newDiv.setAttribute("id", "first_" + "${item.my_sub_id}");
  	  		newDiv.setAttribute("class", "subject");
  	  		newDiv.style.height = "${item.first_height}" + "px";
  	  		newDiv.style.top = "${item.first_start}" + "px";
  	  		newUlTag = document.createElement('ul');
  	  		newUlTag.setAttribute("class", "status");
  	  		newUlTag.style.display = "none";
  	  		newUlTag.innerHTML = '<li title="삭제" class="remove" onclick="removeClass(${item.my_sub_id})"></li>';
  	  		newHTag = document.createElement('h3');
  	  		newHTag.innerHTML = "${item.subjectVO.subject_name}";
  			newPTag = document.createElement('p');
  			newPTag.innerHTML = "<em>" + "${item.subjectVO.professor}" + "</em><span>" + "${item.subjectVO.classroom}" + "</span>";
  			newDiv.append(newUlTag, newHTag, newPTag);
  			<c:choose>
	  			<c:when test="${item.subjectVO.first_date eq 'MON'}">
					parents = document.querySelector("td#MON>div.col");
					parents.appendChild(newDiv);
	  			</c:when>
	  			<c:when test="${item.subjectVO.first_date eq 'TUE'}">
					parents = document.querySelector("td#TUE>div.col");
					parents.appendChild(newDiv);
	  			</c:when>
	  			<c:when test="${item.subjectVO.first_date eq 'WED'}">
					parents = document.querySelector("td#WED>div.col");
					parents.appendChild(newDiv);
	  			</c:when>
	  			<c:when test="${item.subjectVO.first_date eq 'THU'}">
					parents = document.querySelector("td#THU>div.col");
					parents.appendChild(newDiv);
				</c:when>
				<c:when test="${item.subjectVO.first_date eq 'FRI'}">
					parents = document.querySelector("td#FRI>div.col");
					parents.appendChild(newDiv);
	  			</c:when>
  				<c:when test="${item.subjectVO.first_date eq 'SAT'}">
					parents = document.querySelector("td#SAT>div.col");
					parents.appendChild(newDiv);
	  			</c:when>
  			</c:choose>
 		</c:if>
 		<c:if test="${not empty item.subjectVO.second_date}">
  			newDiv2 = document.createElement("div");
  	  		newDiv2.setAttribute("id", "second_" + "${item.my_sub_id}");
  	  		newDiv2.setAttribute("class", "subject");
  	  		newDiv2.style.height = "${item.second_height}" + "px";
  	  		newDiv2.style.top = "${item.second_start}" + "px";
  	  		newUlTag2 = document.createElement('ul');
  	  		newUlTag2.setAttribute("class", "status");
  	  		newUlTag2.style.display = "none";
  	  		newUlTag2.innerHTML = '<li title="삭제" class="remove" onclick="removeClass(${item.my_sub_id})"></li>';
  	  		newHTag2 = document.createElement('h3');
  	  		newHTag2.innerHTML = "${item.subjectVO.subject_name}";
  			newPTag2 = document.createElement('p');
  			newPTag2.innerHTML = "<em>" + "${item.subjectVO.professor}" + "</em><span>" + "${item.subjectVO.classroom}" + "</span>";
  			newDiv2.append(newUlTag2, newHTag2, newPTag2);
  			<c:choose>
	  			<c:when test="${item.subjectVO.second_date eq 'MON'}">
					parents2 = document.querySelector("td#MON>div.col");
					parents2.appendChild(newDiv2);
	  			</c:when>
	  			<c:when test="${item.subjectVO.second_date eq 'TUE'}">
					parents2 = document.querySelector("td#TUE>div.col");
					parents2.appendChild(newDiv2);
	  			</c:when>
	  			<c:when test="${item.subjectVO.second_date eq 'WED'}">
					parents2 = document.querySelector("td#WED>div.col");
					parents2.appendChild(newDiv2);
	  			</c:when>
	  			<c:when test="${item.subjectVO.second_date eq 'THU'}">
					parents2 = document.querySelector("td#THU>div.col");
					parents2.appendChild(newDiv2);
				</c:when>
				<c:when test="${item.subjectVO.second_date eq 'FRI'}">
					parents2 = document.querySelector("td#FRI>div.col");
					parents2.appendChild(newDiv2);
	  			</c:when>
  				<c:when test="${item.subjectVO.second_date eq 'SAT'}">
					parents2 = document.querySelector("td#SAT>div.col");
					parents2.appendChild(newDiv2);
	  			</c:when>
  			</c:choose>
 		</c:if>
 		<c:if test="${not empty item.subjectVO.third_date}">
  			newDiv3 = document.createElement("div");
  	  		newDiv3.setAttribute("id", "third_" + "${item.my_sub_id}");
  	  		newDiv3.setAttribute("class", "subject");
  	  		newDiv3.style.height = "${item.third_height}" + "px";
  	  		newDiv3.style.top = "${item.third_start}" + "px";
  	  		newUlTag3 = document.createElement('ul');
  	  		newUlTag3.setAttribute("class", "status");
  	  		newUlTag3.style.display = "none";
  	  		newUlTag3.innerHTML = '<li title="삭제" class="remove" onclick="removeClass(${item.my_sub_id})"></li>';
  	  		newHTag3 = document.createElement('h3');
  	  		newHTag3.innerHTML = "${item.subjectVO.subject_name}";
  			newPTag3 = document.createElement('p');
  			newPTag3.innerHTML = "<em>" + "${item.subjectVO.professor}" + "</em><span>" + "${item.subjectVO.classroom}" + "</span>";
  			newDiv3.append(newUlTag3, newHTag3, newPTag3);
  			<c:choose>
	  			<c:when test="${item.subjectVO.third_date eq 'MON'}">
					parents3 = document.querySelector("td#MON>div.col");
					parents3.appendChild(newDiv3);
	  			</c:when>
	  			<c:when test="${item.subjectVO.third_date eq 'TUE'}">
					parents3 = document.querySelector("td#TUE>div.col");
					parents3.appendChild(newDiv3);
	  			</c:when>
	  			<c:when test="${item.subjectVO.third_date eq 'WED'}">
					parents3 = document.querySelector("td#WED>div.col");
					parents3.appendChild(newDiv3);
	  			</c:when>
	  			<c:when test="${item.subjectVO.third_date eq 'THU'}">
					parents3 = document.querySelector("td#THU>div.col");
					parents3.appendChild(newDiv3);
				</c:when>
				<c:when test="${item.subjectVO.third_date eq 'FRI'}">
					parents3 = document.querySelector("td#FRI>div.col");
					parents3.appendChild(newDiv3);
	  			</c:when>
  				<c:when test="${item.subjectVO.third_date eq 'SAT'}">
					parents3 = document.querySelector("td#SAT>div.col");
					parents3.appendChild(newDiv3);
	  			</c:when>
  			</c:choose>
  		</c:if>
	</c:forEach>

  </script>
  <script>
  	let subject = document.getElementsByClassName("subject");
  	let divTag;
  	let id;
  	for(let index = 0; index < subject.length; index += 1) {
  		subject[index].addEventListener('mouseover', function() {
  			id = subject[index].getAttribute('id');
  			$('#' + id).find('ul.status').css("display", "block");
  		});
  		subject[index].addEventListener('mouseout', function() {
  			id = subject[index].getAttribute('id');
  			$('#' + id).find('ul.status').css("display", "none");
  		});
  	}
  </script>
  <script>
  	function removeClass(id) {
  		$.ajax({
  			url : "removeSubject.timetable",
  			type : "post",
  			data : {sub_id : id},
  			dataType : 'json',
  			success : function(result) {
  				if(result == 0) {
  					alert("해당 과목이 지워지지 않았습니다.");
  				} else {
  					$('div').remove('#' + 'first_' + id);
  					$('div').remove('#' + 'second_' + id);
  					$('div').remove('#' + 'third_' + id);
  					/* $("#" + id).remove(); */
  				}
  			},
  			error : function() {
  				alert("서버요청실패");
  			}
  		});
  	}
  </script>
  <script>
  	// 창 크기 변화 감지
  	// 이용하여 width 변화 진
	  let size = document.getElementById("time_table");
	  window.onresize = function(event){
	    let innerWidth = window.innerWidth;
	    console.log(innerWidth);
	  }
  </script>
</body>
</html>
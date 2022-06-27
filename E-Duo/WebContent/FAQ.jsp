<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
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
</head>
<body>
	<div class="site-wrap">
    <mytag:header />

    <div class="bg-light py-3">
      <div class="container">
        <div class="row">
          <div class="col-md-12 mb-0"><a href="index.html">Home</a> <span class="mx-2 mb-0">/</span> <strong class="text-black">Contact</strong></div>
        </div>
      </div>
    </div>  

    <div class="site-section">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <h2 class="h3 mb-3 text-black">Get In Touch</h2>
          </div>
          <div class="col-md-3">
            <div class="border p-4 rounded mb-4">
              <h3 class="mb-3 h6 text-uppercase text-black d-block">Categories</h3>
              <ul class="list-unstyled mb-0">
              	<li class="mb-1"><a href="selectAllFAQ.faq" class="d-flex"><span class="text-black">FAQ</span></a></li>
                <li class="mb-1"><a href="question.jsp" class="d-flex"><span class="text-black">문의하기</span></a></li>
                <li class="mb-1"><a href="#" class="d-flex"><span class="text-black">서비스 이용약관</span></a></li>
                <li class="mb-1"><a href="#" class="d-flex"><span class="text-black">개인정보 처리방침</span></a></li>
                <li class="mb-1"><a href="#" class="d-flex"><span class="text-black">커뮤니티 이용규칙</span></a></li>
              </ul>
            </div>

          </div>
          <div class="col-md-9 ml-auto">
          	<c:choose>
          		<c:when test = "${auth eq 'a'}">
          			<div class="col-md-12 ml-auto">
		            	<h3 class="mb-3 h3 text-uppercase text-black d-block">FAQ</h3>
		            </div>
		            <div class="col-md-4 ml-auto">
		            	<input type = "button" class="btn btn-primary btn-lg btn-block" style = "background-color: white; border-color: white; font-weight: 400; width: 35%; height: 40px; text-align: center; color: black; letter-spacing: -1px;" value = "추가하기" onclick = "location.href = 'FAQInsert.jsp'">
		            </div>
          		</c:when>
          		<c:otherwise>
          			<div class="col-md-12 ml-auto">
		            	<h3 class="mb-3 h3 text-uppercase text-black d-block">FAQ</h3>
		            </div>
          		</c:otherwise>
          	</c:choose>
            <div class="col-md-12 ml-auto">
                <ul style = "list-style:none; padding:0;">
                	<c:forEach var = "data" items = "${faq_datas}">
                		<a href = "selectOneFAQ.faq?fid=${data.faq_id}" style = "color:#8c92a0;">
                			<li class = "faq_list1">
                  				<div class="border p-4 rounded mb-4" class = "faq_list">
                    				<div style = "margin-left: 7%;">
                      					<span style = "font-size: 1.5rem; font-weight: 500;">${data.title}</span>
                    				</div>
                      			</div>
                    		</li>
                		</a>
                	</c:forEach>
                </ul>
            </div>
          </div>
        </div>
      </div>
    </div>

    <mytag:footer />
  </div>

  <script src="js/jquery-3.3.1.min.js"></script>
  <script src="js/jquery-ui.js"></script>
  <script src="js/popper.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <script src="js/owl.carousel.min.js"></script>
  <script src="js/jquery.magnific-popup.min.js"></script>
  <script src="js/aos.js"></script>

  <script src="js/main.js"></script>
</body>
</html>
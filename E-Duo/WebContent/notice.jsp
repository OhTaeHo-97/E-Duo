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
                <div class="col-md-12 mb-0"><a href="index.js">Home</a> <span class="mx-2 mb-0">/</span> <strong class="text-black">Contact</strong></div>
            </div>
        </div>
    </div>  

    <div class="site-section">
        <div class="container">
            <div class="row">
            	<c:choose>
            		<c:when test = "${auto eq 'a'}">
            			<div class="col-md-9 ml-auto">
	                        <h3 class="mb-3 h3 text-uppercase text-black d-block">Notice</h3>
	                    </div>
	                   	<div class="col-md-3 ml-auto">
	                        <input type = "button" class="btn btn-primary btn-lg btn-block" style = "background-color: white; border-color: white; font-weight: 400; width: 35%; height: 40px; text-align: center; color: black; letter-spacing: -1px;" value = "추가하기" onclick = "location.href = 'noticeInsert.jsp'">
	                    </div>
            		</c:when>
            		<c:otherwise>
            			<div class="col-md-12 ml-auto">
	                        <h3 class="mb-3 h3 text-uppercase text-black d-block">Notice</h3>
	                    </div>
            		</c:otherwise>
            	</c:choose>
                    <div class="col-md-12 ml-auto">
                        <ul style = "list-style:none; padding:0;">
                        	<c:forEach var = "data" items = "${notice_datas}">
                        		<a href="noticeDetail.notice?nid=${data.not_id}" style = "color:#8c92a0;">
	                                <li class = "faq_list1">
	                                    <div class="border p-4 rounded mb-4 faq_list">
	                                        <div style = "margin-left: 7%;">
	                                            <span>${data.title}</span>
	                                        </div>
	                                    </div>
	                                </li>
	                            </a>
                        	</c:forEach>
<!--                             <a href="#" style = "color:#8c92a0;"> -->
<!--                                 <li class = "faq_list1"> -->
<!--                                     <div class="border p-4 rounded mb-4 faq_list"> -->
<!--                                         <div style = "margin-left: 7%;"> -->
<!--                                             <span>공지 제목</span> -->
<!--                                         </div> -->
<!--                                     </div> -->
<!--                                 </li> -->
<!--                             </a> -->
                        </ul>
                    </div>
<!--                 </div> -->
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
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
            <h2 class="h3 mb-3 text-black">내가 쓴 댓글</h2>
          </div>
          <div class="col-md-12 ml-auto">

			<ul style = "list-style:none;">
				<c:forEach var="data" items="${myreply_data}">
		            <div class="col-md-12 ml-auto">
		              <div class="border p-4 rounded mb-4" style = "margin: 0 !important;">
	               		<a href = "#" style = "color:black;">
	                        <li>
	                            <h5 class = "text-black" style="display: inline-block; width: 70%; white-space: nowrap; overflow: hidden; text-overflow: none; margin-bottom: 3px;'">${data.title}</h5>
	                            <span style="display: inline-block; width: 90%; white-space: nowrap; overflow: hidden; text-overflow: none; margin-top: -6px;'">${data.content}</span>
	                        </li>
	                    </a>
		              </div>
		            </div>
            	</c:forEach>
            </ul>
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
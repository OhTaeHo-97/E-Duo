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

    <div class="site-section">
      <div class="container">
        <!-- <div class="row"> -->
        <div>
          <div class="col-md-12">
            <h2 class="h2 mb-3 text-black">Notice</h2>
          </div>
          <!-- <div class="col-md-7" style = "width:100%;"> -->
          <!-- <div style = "position:relative; left:25%; width:50%;"> -->
        <div>

<!--             <form action="updateNotice.notice" method="POST"> -->
            <div class="p-3 p-lg-5 border">
            <div class="form-group row">
                <div class="col-md-9">
                    <h3 style = "color:black;">${notice_data.title}</h3>
                <!-- <label for="login_uid" class="text-black">ID <span class="text-danger">*</span></label>
                <input type="text" class="form-control" id="login_uid" name="uid" placeholder="아이디를 입력하세요."> -->
                    <span class = "time">${notice_data.regDate}</span>
                </div>
                <div class="col-md-3">
               		<c:if test = "${auth eq 'a'}">
               			<input type="button" class="btn btn-primary btn-lg" style = "background-color: white; border-color: white; width: 30%; height: 50%; text-align: center; color: black;" value="수정" onClick = "location.href = 'noticeUpdatePage.notice?nid=${notice_data.not_id}'">
                  		<input type="button" class="btn btn-primary btn-lg" style = "background-color: white; border-color: white; width: 30%; height: 50%; text-align: center; color: red;" value="삭제" onClick = "location.href = 'deleteNotice.notice?nid=${notice_data.not_id}'">
               		</c:if>
                </div>
            </div>
            <div class="form-group row">
                <div class="col-md-12">
                    <span class = "notice-content">${notice_data.content}</span>
                </div>
            </div>
            <div class="form-group row">
                <div class="col-md-3">
                <input type="button" class="btn btn-primary btn-lg btn-block" style="font-size: 1rem;" value="메인으로 돌아가기" onClick = "location.href = 'noticePage.notice'">
                </div>
            </div>
            <!-- <div class="form-group row">
                <div class="col-lg-12">
                <input type="submit" class="btn btn-primary btn-lg btn-block" value="Send Message">
                </div>
            </div> -->
            </div>
<!--             </form> -->
          </div>
          <!-- <div class="col-md-5 ml-auto">
            <div class="p-4 border mb-3">
              <span class="d-block text-primary h6 text-uppercase">New York</span>
              <p class="mb-0">203 Fake St. Mountain View, San Francisco, California, USA</p>
            </div>
            <div class="p-4 border mb-3">
              <span class="d-block text-primary h6 text-uppercase">London</span>
              <p class="mb-0">203 Fake St. Mountain View, San Francisco, California, USA</p>
            </div>
            <div class="p-4 border mb-3">
              <span class="d-block text-primary h6 text-uppercase">Canada</span>
              <p class="mb-0">203 Fake St. Mountain View, San Francisco, California, USA</p>
            </div>

          </div> -->
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
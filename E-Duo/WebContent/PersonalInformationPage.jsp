<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "mytag" tagdir = "/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<title>Shoppers &mdash; Colorlib e-Commerce Template</title>
<meta charset="utf-8">
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

    <div class="site-section" style = "margin:0 auto !important;">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <h2 class="h3 mb-3 text-black" style = "text-align:center;">개인 정보 페이지</h2>
          </div>
          <div class="col-md-6" style = "position:relative; left:25%; width:50%;">

            <form action="#" method="post">
              <div class="p-3 p-lg-5 border">
                <div class="form-group row">
                  <div class = "p-3" style = "width:100%;">
                    <h3 class = "text-black">내 정보</h3>
                    <div>
                      <img src = "images/blog_1.jpg" class = "profile" style = "float:left;">
                      <div style = "float:left; line-height: 4.8; margin-left: 4em;">
                        <h5 style="padding-top:14px;">${user_id}</h5>
                      </div>
                      <input type = "button" class="btn btn-primary btn-lg" style = "width:35%; text-align:center; margin-left:10%;" value = "로그아웃" onclick = "location.href='logout.mem'">
                    </div>
                    <div style="clear:both; margin-top:30%;">
                      <input type = "button" class="btn btn-primary btn-lg btn-block" value = "개인 정보 변경" onclick = "location.href = 'checkUser.jsp'">
                    </div>
                    <div style="clear:both; margin-top:10%;">
                      <input type = "button" class="btn btn-primary btn-lg btn-block" value = "내가 작성한 글" onclick = "location.href = 'myBulletin.mem'">
                    </div>
                    <div style="clear:both; margin-top:10%;">
                      <input type = "button" class="btn btn-primary btn-lg btn-block" value = "내가 작성한 댓글" onclick = "location.href = 'myReply.mem'">
                    </div>
                    <div style="clear:both; margin-top:10%;">
                      <input type = "button" class="btn btn-primary btn-lg btn-block" value = "내 시간표" onclick="location.href = 'timetablePage.timetable'">
                    </div>
                    <div style="clear:both; margin-top:10%;">
                      <input type = "button" class="btn btn-primary btn-lg btn-block" value = "내 학점관리">
                    </div>
                  </div>
                  <!-- <div class="col-md-6" style = "clear:both;">
                    <label for="c_fname" class="text-black">First Name <span class="text-danger">*</span></label>
                    <input type="text" class="form-control" id="c_fname" name="c_fname">
                  </div>
                  <div class="col-md-6">
                    <label for="c_lname" class="text-black">Last Name <span class="text-danger">*</span></label>
                    <input type="text" class="form-control" id="c_lname" name="c_lname">
                  </div> -->
                </div>
                <!-- <div class="form-group row">
                  <div class="col-md-12">
                    <label for="c_email" class="text-black">Email <span class="text-danger">*</span></label>
                    <input type="email" class="form-control" id="c_email" name="c_email" placeholder="">
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-md-12">
                    <label for="c_subject" class="text-black">Subject </label>
                    <input type="text" class="form-control" id="c_subject" name="c_subject">
                  </div>
                </div>

                <div class="form-group row">
                  <div class="col-md-12">
                    <label for="c_message" class="text-black">Message </label>
                    <textarea name="c_message" id="c_message" cols="30" rows="7" class="form-control"></textarea>
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-lg-12">
                    <input type="submit" class="btn btn-primary btn-lg btn-block" value="Send Message">
                  </div>
                </div> -->
              
              </div>
            </form>
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
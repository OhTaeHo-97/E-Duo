<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "mytag" tagdir = "/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<title>Shoppers &mdash; Colorlib e-Commerce Template</title>
<meta charset="UTF-8">]
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
        <div class="row">
          <div class="col-md-12">
            <h2 class="h3 mb-3 text-black">Get In Touch</h2>
          </div>
          <div class="col-md-3">
            <div class="border p-4 rounded mb-4">
              <h3 class="mb-3 h6 text-uppercase text-black d-block">Categories</h3>
              <ul class="list-unstyled mb-0">
                <li class="mb-1"><a href="#" class="d-flex"><span class="text-black">문의하기</span></a></li>
                <li class="mb-1"><a href="#" class="d-flex"><span class="text-black">서비스 이용약관</span></a></li>
                <li class="mb-1"><a href="#" class="d-flex"><span class="text-black">개인정보 처리방침</span></a></li>
                <li class="mb-1"><a href="#" class="d-flex"><span class="text-black">커뮤니티 이용규칙</span></a></li>
              </ul>
            </div>

          </div>
          <div class="col-md-9 ml-auto">

            <form action="insertEnquiry.enq" method="post">
              
              <div class="p-3 p-lg-5 border">
                <div class="form-group row">
                  <div class="col-md-3">
                    <label for="category_question" class="text-black">카테고리<span class="text-danger">*</span></label>
                    <select name="category" class="form-control" id="category_question" >
                      <option value="개인정보">개인정보</option>
                      <option value="게시판">게시판</option>
                      <option value="시간표">시간표</option>
                      <option value="학점관리">학점관리</option>
                      <option value="기타">기타</option>
                    </select>
                  </div>
                  <div class="col-md-9">
                    <label for="c_lname" class="text-black">제목<span class="text-danger">*</span></label>
                    <input type="text" class="form-control" id="title_question" name="title">
                  </div>
                </div>

                <div class="form-group row">
                  <div class="col-md-12">
                    <label for="content_question" class="text-black">문의사항 </label>
                    <textarea name="content" id="content_question" cols="30" rows="7" class="form-control"></textarea>
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-lg-12">
                    <input type="submit" class="btn btn-primary btn-lg btn-block" value="문의하기">
                  </div>
                </div>
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
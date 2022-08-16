<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
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

    <div class="site-section">
      <div class="container">

        <div class="row mb-5">
          <div class="col-md-9 order-2">
            <div class="row mb-5">
              <div class="col-sm-6 col-lg-6 mb-4" data-aos="fade-up">
                <div class="block-4 border">
                  <div style = "height: 45px; padding-left: 1rem; border-bottom: 1px solid #dee2e6; background-color: rgba(0, 247, 255, 0.3);">
                  	<a href = "bulletin_category.bul?category=free">
                  		<h3 class="mb-3 h6 text-uppercase text-black d-block" style="color: rgba(100, 100, 100, 0.6); line-height: 45px;">자유게시판</h3>
                  	</a>
                  </div>
                  <div>
                    <ul style = "list-style:none; padding-left:0; margin: 0;">
	                    <c:forEach var = "data" items="${free_datas}">
	                    	<a href = "bulletin_detail.bul?bul_id=${data.bul_id}" style = "color:black;">
	                        	<li style = "padding: 10px 10px 5px 20px; border-bottom: 1px solid #dee2e6;">
	                          		<h5 class = "text-black" style="font-size: 1rem;">${data.title}</h4>
	                         			<span style="font-size: 0.8rem;">${data.content}</span>
	                        	</li>
	                      	</a>
	                    </c:forEach>                    
                    </ul>
                  </div>
                </div>
              </div>
              <div class="col-sm-6 col-lg-6 mb-4" data-aos="fade-up">
                <div class="block-4 border">
                  <div style = "height: 45px; padding-left: 1rem; border-bottom: 1px solid #dee2e6; background-color: rgba(0, 247, 255, 0.3);">
                  	<a href = "bulletin_category.bul?category=info">
                  		<h3 class="mb-3 h6 text-uppercase text-black d-block" style="color: rgba(100, 100, 100, 0.6); line-height: 45px;">정보게시판</h3>
                  	</a>          
                  </div>
                  <div>
                    <ul style = "list-style:none; padding-left:0; margin: 0;">
	                    <c:forEach var = "data" items="${info_datas}">
	                    	<a href = "bulletin_detail.bul?bul_id=${data.bul_id}" style = "color:black;">
	                        	<li style = "padding: 10px 10px 5px 20px; border-bottom: 1px solid #dee2e6;">
	                          		<h5 class = "text-black" style="font-size: 1rem;">${data.title}</h4>
	                         			<span style="font-size: 0.8rem;">${data.content}</span>
	                        	</li>
	                      	</a>
	                    </c:forEach>                    
                    </ul>
                  </div>
                </div>
              </div>
              <div class="col-sm-6 col-lg-6 mb-4" data-aos="fade-up">
                <div class="block-4 border">
                  <div style = "height: 45px; padding-left: 1rem; border-bottom: 1px solid #dee2e6; background-color: rgba(0, 247, 255, 0.3);">
                  	<a href = "bulletin_category.bul?category=fresh">
                  		<h3 class="mb-3 h6 text-uppercase text-black d-block" style="color: rgba(100, 100, 100, 0.6); line-height: 45px;">새내기게시판</h3>
                  	</a>          
                  </div>
                  <div>
                    <ul style = "list-style:none; padding-left:0; margin: 0;">
	                    <c:forEach var = "data" items="${fresh_datas}">
	                    	<a href = "bulletin_detail.bul?bul_id=${data.bul_id}" style = "color:black;">
	                        	<li style = "padding: 10px 10px 5px 20px; border-bottom: 1px solid #dee2e6;">
	                          		<h5 class = "text-black" style="font-size: 1rem;">${data.title}</h4>
	                         			<span style="font-size: 0.8rem;">${data.content}</span>
	                        	</li>
	                      	</a>
	                    </c:forEach>                    
                    </ul>
                  </div>
                </div>
              </div>
              <div class="col-sm-6 col-lg-6 mb-4" data-aos="fade-up">
                <div class="block-4 border">
                  <div style = "height: 45px; padding-left: 1rem; border-bottom: 1px solid #dee2e6; background-color: rgba(0, 247, 255, 0.3);">
                  	<a href = "bulletin_category.bul?category=ad">
                  		<h3 class="mb-3 h6 text-uppercase text-black d-block" style="color: rgba(100, 100, 100, 0.6); line-height: 45px;">홍보게시판</h3>
                  	</a>          
                  </div>
                  <div>
                    <ul style = "list-style:none; padding-left:0; margin: 0;">
	                    <c:forEach var = "data" items="${ad_datas}">
	                    	<a href = "bulletin_detail.bul?bul_id=${data.bul_id}" style = "color:black;">
	                        	<li style = "padding: 10px 10px 5px 20px; border-bottom: 1px solid #dee2e6;">
	                          		<h5 class = "text-black" style="font-size: 1rem;">${data.title}</h4>
	                         			<span style="font-size: 0.8rem;">${data.content}</span>
	                        	</li>
	                      	</a>
	                    </c:forEach>                    
                    </ul>
                  </div>
                </div>
              </div>
              <div class="col-sm-6 col-lg-6 mb-4" data-aos="fade-up">
                <div class="block-4 border">
                  <div style = "height: 45px; padding-left: 1rem; border-bottom: 1px solid #dee2e6; background-color: rgba(0, 247, 255, 0.3);">
                  	<a href = "bulletin_category.bul?category=job">
                  		<h3 class="mb-3 h6 text-uppercase text-black d-block" style="color: rgba(100, 100, 100, 0.6); line-height: 45px;">취업 진로게시판</h3>
                  	</a>          
                  </div>
                  <div>
                    <ul style = "list-style:none; padding-left:0; margin: 0;">
	                    <c:forEach var = "data" items="${job_datas}">
	                    	<a href = "bulletin_detail.bul?bul_id=${data.bul_id}" style = "color:black;">
	                        	<li style = "padding: 10px 10px 5px 20px; border-bottom: 1px solid #dee2e6;">
	                          		<h5 class = "text-black" style="font-size: 1rem;">${data.title}</h4>
	                         			<span style="font-size: 0.8rem;">${data.content}</span>
	                        	</li>
	                      	</a>
	                    </c:forEach>                    
                    </ul>
                  </div>
                </div>
              </div>
              <div class="col-sm-6 col-lg-6 mb-4" data-aos="fade-up">
                <div class="block-4 border">
                  <div style = "height: 45px; padding-left: 1rem; border-bottom: 1px solid #dee2e6; background-color: rgba(0, 247, 255, 0.3);">
                  	<a href = "bulletin_category.bul?category=market">
                  		<h3 class="mb-3 h6 text-uppercase text-black d-block" style="color: rgba(100, 100, 100, 0.6); line-height: 45px;">장터게시판</h3>
                  	</a>          
                  </div>
                  <div>
                    <ul style = "list-style:none; padding-left:0; margin: 0;">
	                    <c:forEach var = "data" items="${market_datas}">
	                    	<a href = "bulletin_detail.bul?bul_id=${data.bul_id}" style = "color:black;">
	                        	<li style = "padding: 10px 10px 5px 20px; border-bottom: 1px solid #dee2e6;">
	                          		<h5 class = "text-black" style="font-size: 1rem;">${data.title}</h4>
	                         			<span style="font-size: 0.8rem;">${data.content}</span>
	                        	</li>
	                      	</a>
	                    </c:forEach>                    
                    </ul>
                  </div>
                </div>
              </div>
            </div>
          </div>

          <div class="col-md-3 order-1 mb-5 mb-md-0">
            <div class="border p-4 rounded mb-4">
              <h3 class="mb-3 h6 text-uppercase text-black d-block">내 정보</h3>
              <div style = "margin-top: 20px; text-align: center;">
                <img src = "images/human.png" style = "width: 120px; height: 120px; border-radius: 100%;">
              </div>
              <ul class="list-unstyled mb-0">
                <li class="mb-1 text-black" style = "text-align: center; margin-top: 20px;"><span style = "font-size: 1.2rem; font-weight: 500;">이름</span></li>
                <li class="mb-1" style = "text-align: center;"><span>${user_id}</span></li>
              </ul>
            </div>
            
            <div class="border p-4 rounded mb-4">
              <div class="mb-4">
                <h3 class="mb-3 h6 text-uppercase text-black d-block">시간표</h3>
                <div style = "margin-top: 20px; text-align: center;">
                  <a href = "#"><img src = "images/schedule.png" style = "width: 120px; height: 120px;"></a>
                </div>
              </div>
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
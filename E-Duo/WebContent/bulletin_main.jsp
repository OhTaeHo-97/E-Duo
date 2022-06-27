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
                  <div style = "padding: 20px 20px 10px 20px; border-bottom: 1px solid #dee2e6;">
                  	<a href = "selectCategoryFilterAll.bul?category=free">
                  		<h3 class="mb-3 h6 text-uppercase text-black d-block">자유게시판</h3>
                  	</a>          
                  </div>
                  <div>
                    <ul style = "list-style:none; padding-left:0; margin: 0;">
	                    <c:forEach var = "data" items="${free_datas}">
	                    	<a href = "bulletin_detail.bul?bul_id=${data.bul_id}" style = "color:black;">
	                        	<li style = "padding: 20px; border-bottom: 1px solid #dee2e6;">
	                          		<h5 class = "text-black">${data.title}</h4>
	                         			${data.content}
	                        	</li>
	                      	</a>
	                    </c:forEach>                    
                    </ul>
                  </div>
                </div>
              </div>
              <div class="col-sm-6 col-lg-6 mb-4" data-aos="fade-up">
                <div class="block-4 border">
                  <div style = "padding: 20px 20px 10px 20px; border-bottom: 1px solid #dee2e6;">
                  	<a href = "selectCategoryFilterAll.bul?category=info">
                  		<h3 class="mb-3 h6 text-uppercase text-black d-block">정보게시판</h3>
                  	</a>          
                  </div>
                  <div>
                    <ul style = "list-style:none; padding-left:0; margin: 0;">
	                    <c:forEach var = "data" items="${info_datas}">
	                    	<a href = "bulletin_detail.bul?bul_id=${data.bul_id}" style = "color:black;">
	                        	<li style = "padding: 20px; border-bottom: 1px solid #dee2e6;">
	                          		<h5 class = "text-black">${data.title}</h4>
	                         			${data.content}
	                        	</li>
	                      	</a>
	                    </c:forEach>                    
                    </ul>
                  </div>
                </div>
              </div>
              <div class="col-sm-6 col-lg-6 mb-4" data-aos="fade-up">
                <div class="block-4 border">
                  <div style = "padding: 20px 20px 10px 20px; border-bottom: 1px solid #dee2e6;">
                  	<a href = "selectCategoryFilterAll.bul?category=fresh">
                  		<h3 class="mb-3 h6 text-uppercase text-black d-block">새내기게시판</h3>
                  	</a>          
                  </div>
                  <div>
                    <ul style = "list-style:none; padding-left:0; margin: 0;">
	                    <c:forEach var = "data" items="${fresh_datas}">
	                    	<a href = "bulletin_detail.bul?bul_id=${data.bul_id}" style = "color:black;">
	                        	<li style = "padding: 20px; border-bottom: 1px solid #dee2e6;">
	                          		<h5 class = "text-black">${data.title}</h4>
	                         			${data.content}
	                        	</li>
	                      	</a>
	                    </c:forEach>                    
                    </ul>
                  </div>
                </div>
              </div>
              <div class="col-sm-6 col-lg-6 mb-4" data-aos="fade-up">
                <div class="block-4 border">
                  <div style = "padding: 20px 20px 10px 20px; border-bottom: 1px solid #dee2e6;">
                  	<a href = "selectCategoryFilterAll.bul?category=ad">
                  		<h3 class="mb-3 h6 text-uppercase text-black d-block">홍보게시판</h3>
                  	</a>          
                  </div>
                  <div>
                    <ul style = "list-style:none; padding-left:0; margin: 0;">
	                    <c:forEach var = "data" items="${ad_datas}">
	                    	<a href = "bulletin_detail.bul?bul_id=${data.bul_id}" style = "color:black;">
	                        	<li style = "padding: 20px; border-bottom: 1px solid #dee2e6;">
	                          		<h5 class = "text-black">${data.title}</h4>
	                         			${data.content}
	                        	</li>
	                      	</a>
	                    </c:forEach>                    
                    </ul>
                  </div>
                </div>
              </div>
              <div class="col-sm-6 col-lg-6 mb-4" data-aos="fade-up">
                <div class="block-4 border">
                  <div style = "padding: 20px 20px 10px 20px; border-bottom: 1px solid #dee2e6;">
                  	<a href = "selectCategoryFilterAll.bul?category=job">
                  		<h3 class="mb-3 h6 text-uppercase text-black d-block">취업 진로게시판</h3>
                  	</a>          
                  </div>
                  <div>
                    <ul style = "list-style:none; padding-left:0; margin: 0;">
	                    <c:forEach var = "data" items="${job_datas}">
	                    	<a href = "bulletin_detail.bul?bul_id=${data.bul_id}" style = "color:black;">
	                        	<li style = "padding: 20px; border-bottom: 1px solid #dee2e6;">
	                          		<h5 class = "text-black">${data.title}</h4>
	                         			${data.content}
	                        	</li>
	                      	</a>
	                    </c:forEach>                    
                    </ul>
                  </div>
                </div>
              </div>
              <div class="col-sm-6 col-lg-6 mb-4" data-aos="fade-up">
                <div class="block-4 border">
                  <div style = "padding: 20px 20px 10px 20px; border-bottom: 1px solid #dee2e6;">
                  	<a href = "selectCategoryFilterAll.bul?category=market">
                  		<h3 class="mb-3 h6 text-uppercase text-black d-block">장터게시판</h3>
                  	</a>          
                  </div>
                  <div>
                    <ul style = "list-style:none; padding-left:0; margin: 0;">
	                    <c:forEach var = "data" items="${market_datas}">
	                    	<a href = "bulletin_detail.bul?bul_id=${data.bul_id}" style = "color:black;">
	                        	<li style = "padding: 20px; border-bottom: 1px solid #dee2e6;">
	                          		<h5 class = "text-black">${data.title}</h4>
	                         			${data.content}
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

    <footer class="site-footer border-top">
        <div class="container">
            <div class="row">
                <div class="col-lg-9 mb-5 mb-lg-0">
                    <div class="row">
                        <div class="col-md-12">
                            <h3 class="footer-heading mb-4">Navigations</h3>
                        </div>
                        <div class="col-md-6 col-lg-4">
                            <ul class="list-unstyled">
                                <li><a href="#">Sell online</a></li>
                                <li><a href="#">Features</a></li>
                                <li><a href="#">Shopping cart</a></li>
                                <li><a href="#">Store builder</a></li>
                            </ul>
                        </div>
                        <div class="col-md-6 col-lg-4">
                            <ul class="list-unstyled">
                                <li><a href="#">Mobile commerce</a></li>
                                <li><a href="#">Dropshipping</a></li>
                                <li><a href="#">Website development</a></li>
                            </ul>
                        </div>
                        <div class="col-md-6 col-lg-4">
                            <ul class="list-unstyled">
                                <li><a href="#">Point of sale</a></li>
                                <li><a href="#">Hardware</a></li>
                                <li><a href="#">Software</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
                <!-- <div class="col-md-6 col-lg-3 mb-4 mb-lg-0">
                    <h3 class="footer-heading mb-4">Promo</h3>
                    <a href="#" class="block-6">
                        <img src="images/hero_1.jpg" alt="Image placeholder" class="img-fluid rounded mb-4">
                        <h3 class="font-weight-light  mb-0">Finding Your Perfect Shoes</h3>
                        <p>Promo from  nuary 15 &mdash; 25, 2019</p>
                    </a>
                </div> -->
                <div class="col-md-3 col-lg-3" style = "float:right;">
                    <div class="block-5 mb-5">
                        <h3 class="footer-heading mb-4">Contact Info</h3>
                        <ul class="list-unstyled">
                            <li class="address">203 Fake St. Mountain View, San Francisco, California, USA</li>
                            <li class="phone"><a href="tel://23923929210">+2 392 3929 210</a></li>
                            <li class="email">emailaddress@domain.com</li>
                        </ul>
                    </div>

                    <!-- <div class="block-7">
                        <form action="#" method="post">
                            <label for="email_subscribe" class="footer-heading">Subscribe</label>
                            <div class="form-group">
                                <input type="text" class="form-control py-4" id="email_subscribe" placeholder="Email">
                                <input type="submit" class="btn btn-sm btn-primary" value="Send">
                            </div>
                        </form>
                    </div> -->
                </div>
            </div>
            <div style = "clear:both;"></div>
            <div class="row pt-5 mt-5 text-center">
                <div class="col-md-12">
                    <p>
                        <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                        Copyright &copy;<script data-cfasync="false" src="/cdn-cgi/scripts/5c5dd728/cloudflare-static/email-decode.min.js"></script><script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="icon-heart" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank" class="text-primary">Colorlib</a>
                        <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                    </p>
                </div>
            </div>
        </div>
    </footer>
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
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "mytag" tagdir = "/WEB-INF/tags" %>
<!DOCTYPE html>
<html lang="en">
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
    
    <div class="bg-light py-3">
      <div class="container">
        <div class="row">
          <div class="col-md-12 mb-0">
          	<a href="index.html">게시판</a>
          	<span class="mx-2 mb-0">/</span>
          	<strong class="text-black">
          		<c:set var = "category" value = "${category}" scope="page"/>
          		<c:choose>
          			<c:when test="${category eq 'free'}">
          				자유게시판
          			</c:when>
          			<c:when test="${category eq 'fresh'}">
          				새내기게시판
          			</c:when>
          			<c:when test="${category eq 'ad'}">
          				홍보게시판
          			</c:when>
          			<c:when test="${category eq 'job'}">
          				취업·진로
          			</c:when>
          			<c:when test="${category eq 'market'}">
          				장터게시판
          			</c:when>
          			<c:when test="${category eq 'info'}">
          				정보게시판
          			</c:when>
          		</c:choose>         		
          	</strong>
         </div>
        </div>
      </div>
    </div>

    <div class="site-section">
      <div class="container">

        <div class="row mb-5">
          <div class="col-md-9 order-2">

            <div class="row">
              <div class="col-md-12 mb-5">
                <div class="float-md-left mb-4">
     	           	<h2 class="text-black h5">
     	           		<c:choose>
		          			<c:when test="${category eq 'free'}">
		          				자유게시판
		          			</c:when>
		          			<c:when test="${category eq 'fresh'}">
		          				새내기게시판
		          			</c:when>
		          			<c:when test="${category eq 'ad'}">
		          				홍보게시판
		          			</c:when>
		          			<c:when test="${category eq 'job'}">
		          				취업·진로
		          			</c:when>
		          			<c:when test="${category eq 'market'}">
		          				장터게시판
		          			</c:when>
		          			<c:when test="${category eq 'info'}">
		          				정보게시판
		          			</c:when>
          				</c:choose>
           	    	</h2>
                </div>
              </div>
            </div>
            <div class="row mb-5">
              <div class="col-sm-6 col-lg-12 mb-4" data-aos="fade-up" style="cursor:pointer">
                <div class="block-4 border" style = "padding: 5%;">
                  <form action="updateBulletin.bul" method="POST" name = "updateForm" id = "updateForm">
                  	<div class="form-group row">
	                  <div class="col-md-12">
	                    <input type="text" value="${bul_data.bulletin.title}" class="form-control" id="bulletin_title" name="title" placeholder = "제목">
	                  </div>
	                </div>
	                <div class="form-group row">
	                  <div class="col-md-12">
	                    <input type="text" value="${bul_data.bulletin.content}" class="form-control" id="bulletin_content" name="content" placeholder = "내용">
	                  </div>
	                </div>
	                <div class="form-group row" style="margin-top: 2%;">
	                  <div class="col-md-12">
	                    <label for="bulletin_nickname" class="text-black">익명성 <span class="text-danger">*</span></label>
	                    <input type="radio" class="text-black" id="bulletin_nickname_Y" name="nickname" value="닉네임" style="margin-left: 1%;" checked><span class="text-black">닉네임</span>
	                    <input type="radio" class="text-black" id="bulletin_nickname_N" name="nickname" value="익명" style="margin-left: 1%;"><span class="text-black">익명</span>
	                    <input type="hidden" name="category" value="${category}" />
	                    <input type="hidden" name="bul_id" value="${bul_data.bulletin.bul_id}" />
	                  </div>
                	</div>
                  	<div class="col-lg-3">
                    	<input type="submit" class="btn btn-primary btn-lg btn-block" value="작성">
                  	</div>
                  </form>
                </div>
              </div>                         
            </div>
          </div>

          <div class="col-md-3 order-1 mb-5 mb-md-0">
            <div class="border p-4 rounded mb-4">
              <h3 class="mb-3 h6 text-uppercase text-black d-block">Categories</h3>
              <ul class="list-unstyled mb-0">
                <li class="mb-1"><a href="selectCategoryFilterAll.bul?category=free" class="d-flex"><span>자유게시판</span> <span class="text-black ml-auto">(2,220)</span></a></li>
                <li class="mb-1"><a href="selectCategoryFilterAll.bul?category=info" class="d-flex"><span>정보게시판</span> <span class="text-black ml-auto">(2,550)</span></a></li>
                <li class="mb-1"><a href="selectCategoryFilterAll.bul?category=fresh" class="d-flex"><span>새내기게시판</span> <span class="text-black ml-auto">(2,124)</span></a></li>
                <li class="mb-1"><a href="selectCategoryFilterAll.bul?category=ad" class="d-flex"><span>홍보게시판</span> <span class="text-black ml-auto">(2,124)</span></a></li>
                <li class="mb-1"><a href="selectCategoryFilterAll.bul?category=job" class="d-flex"><span>취업·진로</span> <span class="text-black ml-auto">(2,124)</span></a></li>
                <li class="mb-1"><a href="selectCategoryFilterAll.bul?category=market" class="d-flex"><span>장터게시판</span> <span class="text-black ml-auto">(2,124)</span></a></li>
              </ul>
            </div>

            <div class="border p-4 rounded mb-4">
              <div class="mb-5">
                <h3 class="mb-3 h6 text-uppercase text-black d-block">검색</h3>
                <div>
                  <input type = "text" class="form-control pl-0 bg-white search">
                  <button class="btn btn-secondary btn-sm" style = "float: right; margin-top: 4%;">검색</button>
                </div>
              </div>
            </div>
          </div>
        </div>

        <!-- <div class="row">
          <div class="col-md-12">
            <div class="site-section site-blocks-2">
                <div class="row justify-content-center text-center mb-5">
                  <div class="col-md-7 site-section-heading pt-4">
                    <h2>Categories</h2>
                  </div>
                </div>
                <div class="row">
                  <div class="col-sm-6 col-md-6 col-lg-4 mb-4 mb-lg-0" data-aos="fade" data-aos-delay="">
                    <a class="block-2-item" href="#">
                      <figure class="image">
                        <img src="images/women.jpg" alt="" class="img-fluid">
                      </figure>
                      <div class="text">
                        <span class="text-uppercase">Collections</span>
                        <h3>Women</h3>
                      </div>
                    </a>
                  </div>
                  <div class="col-sm-6 col-md-6 col-lg-4 mb-5 mb-lg-0" data-aos="fade" data-aos-delay="100">
                    <a class="block-2-item" href="#">
                      <figure class="image">
                        <img src="images/children.jpg" alt="" class="img-fluid">
                      </figure>
                      <div class="text">
                        <span class="text-uppercase">Collections</span>
                        <h3>Children</h3>
                      </div>
                    </a>
                  </div>
                  <div class="col-sm-6 col-md-6 col-lg-4 mb-5 mb-lg-0" data-aos="fade" data-aos-delay="200">
                    <a class="block-2-item" href="#">
                      <figure class="image">
                        <img src="images/men.jpg" alt="" class="img-fluid">
                      </figure>
                      <div class="text">
                        <span class="text-uppercase">Collections</span>
                        <h3>Men</h3>
                      </div>
                    </a>
                  </div>
                </div>
              
            </div>
          </div>
        </div> -->
        
      </div>
    </div>

    <footer class="site-footer border-top">
      <div class="container">
        <div class="row">
          <div class="col-lg-6 mb-5 mb-lg-0">
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
          <div class="col-md-6 col-lg-3 mb-4 mb-lg-0">
            <h3 class="footer-heading mb-4">Promo</h3>
            <a href="#" class="block-6">
              <img src="images/hero_1.jpg" alt="Image placeholder" class="img-fluid rounded mb-4">
              <h3 class="font-weight-light  mb-0">Finding Your Perfect Shoes</h3>
              <p>Promo from  nuary 15 &mdash; 25, 2019</p>
            </a>
          </div>
          <div class="col-md-6 col-lg-3">
            <div class="block-5 mb-5">
              <h3 class="footer-heading mb-4">Contact Info</h3>
              <ul class="list-unstyled">
                <li class="address">203 Fake St. Mountain View, San Francisco, California, USA</li>
                <li class="phone"><a href="tel://23923929210">+2 392 3929 210</a></li>
                <li class="email">emailaddress@domain.com</li>
              </ul>
            </div>

            <div class="block-7">
              <form action="#" method="post">
                <label for="email_subscribe" class="footer-heading">Subscribe</label>
                <div class="form-group">
                  <input type="text" class="form-control py-4" id="email_subscribe" placeholder="Email">
                  <input type="submit" class="btn btn-sm btn-primary" value="Send">
                </div>
              </form>
            </div>
          </div>
        </div>
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
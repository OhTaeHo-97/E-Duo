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
    <mytag:header/>

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
                <div class="d-flex">
                  <div class="dropdown mr-1 ml-md-auto">
                    <input type = "button" class="btn btn-secondary btn-sm dropdown-toggle" 
                    value = "글 쓰기" onclick = "location.href = 'bulletin_write.bul?category=${category}'">
                    <!-- <button type="button" class="btn btn-secondary btn-sm dropdown-toggle" id="dropdownMenuOffset" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                      Latest
                    </button>
                    <div class="dropdown-menu" aria-labelledby="dropdownMenuOffset">
                      <a class="dropdown-item" href="#">Men</a>
                      <a class="dropdown-item" href="#">Women</a>
                      <a class="dropdown-item" href="#">Children</a>
                    </div> -->
                  </div>
                </div>
              </div>
            </div>
             <c:forEach var="data" items="${bul_datas}">           	
	            <div class="col-sm-6 col-lg-12 mb-4" data-aos="fade-up" style="cursor:pointer" 
	            onclick = "location.href = 'bulletin_detail.bul?bul_id=${data.bul_id}'";>
	                <div class="block-4 border" style = "padding: 5%;">
	                  <div style = "width: 70%; height: 2rem; overflow:hidden; white-space:nowrap; text-overflow: ellipsis;">
	                    <span style = "font-weight: bold; font-size:1.5rem;">${data.title}</span>
	                  </div>
	                  <div style = "width: 100%; height: 3rem; overflow:hidden; white-space:nowrap; text-overflow: ellipsis;">
	                    <span>${data.content}</span>
	                  </div>
	                </div>
	             </div>
             </c:forEach>
            <div class="row" data-aos="fade-up">
              <div class="col-md-12 text-center">
                <div class="site-block-27">
                  <ul>
                    <li><a href="#">&lt;</a></li>
                    <li class="active"><span>1</span></li>
                    <li><a href="#">2</a></li>
                    <li><a href="#">3</a></li>
                    <li><a href="#">4</a></li>
                    <li><a href="#">5</a></li>
                    <li><a href="#">&gt;</a></li>
                  </ul>
                </div>
              </div>
            </div>
          </div>

          <div class="col-md-3 order-1 mb-5 mb-md-0">
            <div class="border p-4 rounded mb-4">
              <h3 class="mb-3 h6 text-uppercase text-black d-block">Categories</h3>
              <ul class="list-unstyled mb-0">
                <li class="text-black ml-auto"><a href="selectCategoryFilterAll.bul?category=free" class="d-flex"><span>자유게시판</span> <span class="text-black ml-auto">(2,220)</span></a></li>
                <li class="text-black ml-auto"><a href="selectCategoryFilterAll.bul?category=info" class="d-flex"><span>정보게시판</span> <span class="text-black ml-auto">(2,550)</span></a></li>
                <li class="text-black ml-auto"><a href="selectCategoryFilterAll.bul?category=fresh" class="d-flex"><span>새내기게시판</span> <span class="text-black ml-auto">(2,124)</span></a></li>
                <li class="text-black ml-auto"><a href="selectCategoryFilterAll.bul?category=ad" class="d-flex"><span>홍보게시판</span> <span class="text-black ml-auto">(2,124)</span></a></li>
                <li class="text-black ml-auto"><a href="selectCategoryFilterAll.bul?category=job" class="d-flex"><span>취업·진로</span> <span class="text-black ml-auto">(2,124)</span></a></li>
                <li class="text-black ml-auto"><a href="selectCategoryFilterAll.bul?category=market" class="d-flex"><span>장터게시판</span> <span class="text-black ml-auto">(2,124)</span></a></li>
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
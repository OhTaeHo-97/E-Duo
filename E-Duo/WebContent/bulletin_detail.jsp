<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
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
    <header class="site-navbar" role="banner">
      <div class="site-navbar-top">
        <div class="container">
          <div class="row align-items-center">

            <div class="col-6 col-md-4 order-2 order-md-1 site-search-icon text-left">
            </div>

            <div class="col-12 mb-3 mb-md-0 col-md-4 order-1 order-md-2 text-center">
              <div class="site-logo">
                <a href="index.html" class="js-logo-clone">Shoppers</a>
              </div>
            </div>

            <div class="col-6 col-md-4 order-3 order-md-3 text-right">
              <div class="site-top-icons">
                <ul>
                  <li><a href="PersonalInformationPage.jsp"><span class="icon icon-person"></span></a></li>
                  <li class="d-inline-block d-md-none ml-md-0"><a href="PersonalInformatioinPage.jsp" class="site-menu-toggle js-menu-toggle"><span class="icon-menu"></span></a></li>
                  <c:choose>
	                  <c:when test = "${user_id == null}">
	                  	<li><a href = "login.jsp">로그인</a></li>
	                  </c:when>
	                  <c:otherwise>
	                  	<li><a href = "logout.mem">로그아웃</a></li>
	                  </c:otherwise>
                  </c:choose>
                </ul>
              </div> 
            </div>

          </div>
        </div>
      </div> 
      <nav class="site-navigation text-right text-md-center" role="navigation">
        <div class="container">
          <ul class="site-menu js-clone-nav d-none d-md-block">
            <li class="active"><a href="CreditManagement.html">학점 관리</a></li>
            <li><a href="timeTable.html">시간표</a></li>
            <li class = "has-children">
            	<a href="bulletin_main.bul">게시판</a>
            	<ul class="dropdown">
	                <li><a href="selectCategoryFilterAll.bul?category=free">자유게시판</a></li>
	                <li><a href="selectCategoryFilterAll.bul?category=info">정보게시판</a></li>
	                <li><a href="selectCategoryFilterAll.bul?category=fresh">새내기게시판</a></li>
	                <li><a href="selectCategoryFilterAll.bul?category=ad">홍보게시판</a></li>
	                <li><a href="selectCategoryFilterAll.bul?category=job">취업·진로</a></li>
	                <li><a href="selectCategoryFilterAll.bul?category=market">장터게시판</a></li>
              	</ul>
            </li>
            <li><a href="noticePage.notice">공지사항</a></li>
            <li class = "has-children">
            	<a href="FAQ.jsp">문의하기</a>
            	<ul class="dropdown">
	                <li><a href="FAQ.jsp">FAQ</a></li>
	                <li><a href="question.html">문의하기</a></li>
	                <li><a href="#">이용약관</a></li>
	                <li><a href="#">개인정보 처리방침</a></li>
	                <li><a href="#">커뮤니티 이용규칙</a></li>
              	</ul>
            </li>
            <!-- <li><a href="contact.html">Contact</a></li> -->
          </ul>
        </div>
      </nav>
    </header>

    <div class="bg-light py-3">
      <div class="container">
        <div class="row">
          <div class="col-md-12 mb-0"><a href="index.html">게시판</a> <span class="mx-2 mb-0">/</span>
          	<strong class="text-black">
          		<c:set var = "category" value = "${bul_data.bulletin.category}" scope="page"/>
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
              <div class="col-sm-6 col-lg-12 mb-4" data-aos="fade-up";>
                <div class="p-3 p-lg-5 border" style = "padding: 5%;">
                	<div class="form-group row">
                		<div class="col-md-7">
	                		${bul_data.bulletin.nickname}
	                		${bul_data.bulletin.regDate}
	                	</div>
	                	<div class="col-md-5">
	                		<c:if test = "${user_id eq bul_data.bulletin.stu_id}">
	               				<input type="button" class="btn btn-primary btn-lg" style = "background-color: white; border-color: white; width: 30%; height: 2.3rem; text-align: center; color: black;" value="수정" onClick = "location.href = 'bulletin_updatePage.bul?category=${category}&bul_id=${bul_data.bulletin.bul_id}'">
	                  			<input type="button" class="btn btn-primary btn-lg" style = "background-color: white; border-color: white; width: 30%; height: 2.3rem; text-align: center; color: red;" value="삭제" onClick = "location.href = 'deleteBulletin.bul?bul_id=${bul_data.bulletin.bul_id}&category=${category}'">
	               			</c:if>
	               		</div>
                	</div>                               	
                	<div style = "width: 70%; height: 2rem; overflow:hidden; white-space:nowrap; text-overflow: ellipsis;">
                    	<span style = "font-weight: bold; font-size:1.5rem;">
                    		${bul_data.bulletin.title}
                    	</span>
                  	</div>
                  	<div style = "width: 100%; height: 3rem; overflow:hidden; white-space:nowrap; text-overflow: ellipsis;">
                    	<span>
                    		${bul_data.bulletin.content}
                    	</span>
                  	</div>                                
                </div>
              </div>              
            </div>
            <div class="row mb-5">
              <div class="col-sm-6 col-lg-12 mb-4" data-aos="fade-up";>
                <div class="block-4 border" style = "padding: 5%;">
                	<c:forEach var="rep_datas" items="${bul_data.rdatas}">           
	                		<div class = "col-md-12">
		                		${rep_datas.nickname}
		                		${rep_datas.regDate}
		                		<c:if test = "${user_id eq rep_datas.stu_id}">
		               				<input type="button" class="btn btn-primary btn-lg" style = "background-color: white; border-color: white; width: 10%; height: 2.3rem; text-align: center; color: black;" value="수정" onClick = "location.href = 'BulletinUpdatePage.bul?bul_id=${bul_data.bulletin.bul_id}&category=${category}'">
		                  			<input type="button" class="btn btn-primary btn-lg" style = "background-color: white; border-color: white; width: 10%; height: 2.3rem; text-align: center; color: red;" value="삭제" onClick = "location.href = 'deleteReply.bul?bul_id=${bul_data.bulletin.bul_id}&category=${category}&rep_id=${rep_datas.rep_id}'">
		               			</c:if>
		                	</div>                               	
	                	<div style = "width: 50%; overflow:hidden; white-space:nowrap; text-overflow: ellipsis;">
	                    	<span style = "font-weight: bold; font-size:1.5rem;">	                    		
	                    	</span>
	                  	</div>
	                  	<div style = "width: 50%; height: 2.5rem; overflow:hidden; white-space:nowrap; text-overflow: ellipsis;">
	                    	<span>
	                    		${rep_datas.content}
	                    	</span>
	                  	</div>
                  	</c:forEach>                                
                </div>
                <form action="insertReply.bul?bul_id=${bul_data.bulletin.bul_id}" method="POST" name = "insertRepltForm" id = "insertReplyForm">
                  	<div class="form-group row">
	                  <div class="col-md-6">
	                    <input type="text" class="form-control" id="bulletin_title" name="content" placeholder = "내용">
	                  </div>
	                  <div class="col-md-3" style="margin-top: 1%;">
	                    <label for="bulletin_nickname" class="text-black">익명성 <span class="text-danger">*</span></label>
	                    <input type="radio" class="text-black" id="reply_nickname_Y" name="nickname" value="닉네임" style="margin-left: 1%;" checked><span class="text-black">닉네임</span>
	                    <input type="radio" class="text-black" id="reply_nickname_N" name="nickname" value="익명" style="margin-left: 1%;"><span class="text-black">익명</span>
	                    <input type="hidden" name="category" value="${category}" />
	                  </div>
	                  <div class="col-md-3">
                    	<input type="submit" class="btn btn-primary btn-lg btn-block" value="댓글 작성">
                  	  </div>
	                </div>            	            
                </form>                
                <input type = "button" class="btn btn-secondary btn-sm dropdown-toggle" 
                    value = "목록으로" onclick = "location.href = 'selectCategoryFilterAll.bul?category=${category}'">
              </div>              
            </div>
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
                <li class="mb-1"><a href="#" class="d-flex"><span>자유게시판</span> <span class="text-black ml-auto">(2,220)</span></a></li>
                <li class="mb-1"><a href="#" class="d-flex"><span>정보게시판</span> <span class="text-black ml-auto">(2,550)</span></a></li>
                <li class="mb-1"><a href="#" class="d-flex"><span>새내기게시판</span> <span class="text-black ml-auto">(2,124)</span></a></li>
                <li class="mb-1"><a href="#" class="d-flex"><span>홍보게시판</span> <span class="text-black ml-auto">(2,124)</span></a></li>
                <li class="mb-1"><a href="#" class="d-flex"><span>취업·진로</span> <span class="text-black ml-auto">(2,124)</span></a></li>
                <li class="mb-1"><a href="#" class="d-flex"><span>장터게시판</span> <span class="text-black ml-auto">(2,124)</span></a></li>
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
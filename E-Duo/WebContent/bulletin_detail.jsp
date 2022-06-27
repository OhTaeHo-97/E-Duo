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
                <form action="insertReply.bul" method="POST" name = "insertRepltForm" id = "insertReplyForm">
                  	<input type = "hidden" name = "bul_id" value = "${bul_data.bulletin.bul_id}">
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
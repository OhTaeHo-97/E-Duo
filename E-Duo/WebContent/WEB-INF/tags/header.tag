<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<header class="site-navbar" role="banner">
      <div class="site-navbar-top">
        <div class="container">
          <div class="row align-items-center">

            <div class="col-6 col-md-4 order-2 order-md-1 site-search-icon text-left">
            </div>

            <div class="col-12 mb-3 mb-md-0 col-md-4 order-1 order-md-2 text-center">
                <a href="main.do" class="js-logo-clone">
                	<img src="images/logo.png" alt="로고" style="width: 10rem; heigh: 4rem;">
                </a>
            </div>

            <div class="col-6 col-md-4 order-3 order-md-3 text-right">
              <div class="site-top-icons">
                <ul>
                  <li><a href="PersonalInformationPage.jsp"><span class="icon icon-person"></span></a></li>
                  <li class="d-inline-block d-md-none ml-md-0"><a href="PersonalInformatoinPage.jsp" class="site-menu-toggle js-menu-toggle"><span class="icon-menu"></span></a></li>
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
      <nav class="site-navigation text-right text-md-center" role="navigation" style="background-color: rgba(0, 247, 255, 0.3);">
        <div class="container">
          <ul class="site-menu js-clone-nav d-none d-md-block">
          	<c:if test="${auth eq 's'}">
          		<li id = "cre_manage"><a href="showCreditManage.cre">학점 관리</a></li>
            	<li id = "timetable"><a href="timetablePage.timetable">시간표</a></li>
          	</c:if>
            <li id="bulletin" class = "has-children">
            	<a href="bulletin_main.bul">게시판</a>
            	<ul class="dropdown">
	                <li id="free"><a href="selectCategoryFilterAll.bul?category=free">자유게시판</a></li>
	                <li id="info"><a href="selectCategoryFilterAll.bul?category=info">정보게시판</a></li>
	                <li id="fresh"><a href="selectCategoryFilterAll.bul?category=fresh">새내기게시판</a></li>
	                <li id="ad"><a href="selectCategoryFilterAll.bul?category=ad">홍보게시판</a></li>
	                <li id="job"><a href="selectCategoryFilterAll.bul?category=job">취업·진로</a></li>
	                <li id="market"><a href="selectCategoryFilterAll.bul?category=market">장터게시판</a></li>
              	</ul>
            </li>
            <li id="notice"><a href="noticePage.notice">공지사항</a></li>
            <li id="enquiry" class = "has-children">
            	<a href="selectAllFAQ.faq">문의하기</a>
            	<ul class="dropdown">
	                <li id="FAQ"><a href="selectAllFAQ.faq">FAQ</a></li>
	                <li id="enq"><a href="question.jsp">문의하기</a></li>
	                <li id="terms"><a href="#">이용약관</a></li>
	                <li id="private"><a href="#">개인정보 처리방침</a></li>
	                <li id="community_rule"><a href="#">커뮤니티 이용규칙</a></li>
              	</ul>
            </li>
            <!-- <li><a href="contact.html">Contact</a></li> -->
          </ul>
        </div>
      </nav>
    </header>
    
<script>
	let ids = ['cre_manage', 'timetable', 'bulletin', 'free', 'info', 'fresh', 'ad', 'job', 'market', 'notice', 'enquiry', 'FAQ', 'enq', 'terms', 'private', 'community_rule'];
	
</script>
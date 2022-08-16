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
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.5.0/Chart.min.js"></script>
</head>
<body>
	<div class="site-wrap">
	<mytag:header/>

    <div class="site-section">
      <div class="container">

        <div class="row mb-5">
          <div class="col-md-9 order-2">
            <div class="row mb-5">

              <div class="col-sm-12 col-lg-12 mb-4" data-aos="fade-up">
                <div class="block-4 border" style = "padding: 20px;">
                  <h3 class="mb-3 h6 text-uppercase text-black d-block">추이 그래프</h3>
                  <div class = "text-center">
                    <figure class="block-4-image">
                    	<canvas id="line-chart" width="300px" height="250px"></canvas>
                    	<canvas id="bar-chart-horizontal" width="300px" height="250px"></canvas>
                      <!-- <a href="creditma"><img src="images/cloth_1.jpg" alt="Image placeholder" class="img-fluid"></a> -->
                    </figure>
                  </div>
                </div>
              </div>
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
                <a href="PersonalInformationPage.jsp"><img src = "images/human.png" style = "width: 120px; height: 120px; border-radius: 100%;"></a>
              </div>
              <ul class="list-unstyled mb-0">
                <li class="mb-1 text-black" style = "text-align: center; margin-top: 20px;"><span style = "font-size: 1.2rem; font-weight: 500;">${stu_info.name}</span></li>
                <li class="mb-1" style = "text-align: center;"><span>${user_id}</span></li>
              </ul>
            </div>

            <div class="border p-4 rounded mb-4">
              <div class="mb-4">
                <h3 class="mb-3 h6 text-uppercase text-black d-block">시간표</h3>
                <div style = "margin-top: 20px; text-align: center;">
                  <a href = "timetablePage.timetable"><img src = "images/schedule.png" style = "width: 120px; height: 120px;"></a>
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
<!-- <script>
    new Chart(document.getElementById("line-chart"), {
  type: 'line',
  data: {
    labels: [1500,1600,1700,1750,1800,1850,1900,1950,1999,2050],
    datasets: [{ 
        data: [86,114,106,106,107,111,133,221,783,2478],
        label: "Africa",
        borderColor: "#3e95cd",
        fill: false
      }, { 
        data: [282,350,411,502,635,809,947,1402,3700,5267],
        label: "Asia",
        borderColor: "#8e5ea2",
        fill: false
      }, { 
        data: [168,170,178,190,203,276,408,547,675,734],
        label: "Europe",
        borderColor: "#3cba9f",
        fill: false
      }, { 
        data: [40,20,10,16,24,38,74,167,508,784],
        label: "Latin America",
        borderColor: "#e8c3b9",
        fill: false
      }, { 
        data: [6,3,2,2,7,26,82,172,312,433],
        label: "North America",
        borderColor: "#c45850",
        fill: false
      }
    ]
  },
  options: {
    title: {
      display: true,
      text: 'World population per region (in millions)'
    }
  }
});
</script> -->
<script>
    new Chart(document.getElementById("line-chart"), {
  type: 'line',
  data: {
    labels: ['1학년 1학기','1학년 2학기','2학년 1학기','2학년 2학기','3학년 1학기','3학년 2학기','4학년 1학기','4학년 2학기'],
    datasets: [{ 
        data: [50,60,20,10,30,40,50,60],
        label: "학점",
        borderColor: "#3e95cd",
        fill: false
      }
    ]
  },
  options: {
    title: {
      display: true,
      text: '학기별 추이 그래프',
      font: {
    	  size: 30
      }
    }
  }
});
</script>
<script>
  new Chart(document.getElementById("bar-chart-horizontal"), {
    type: 'horizontalBar',
    data: {
      labels: ["A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D+", "D0", "D-", "F"],
      datasets: [
        {
          label: "Population (millions)",
          backgroundColor: ["#3e95cd", "#8e5ea2","#3cba9f","#e8c3b9","#c45850", "#c45850", "#c45850", "#c45850", "#c45850", "#c45850", "#c45850", "#c45850", "#c45850"],
          data: [2478,5267,734,784,433,433,433,433,433,433,433,433,433]
        }
      ]
    },
    options: {
      tooltips: {
        mode: 'index',
        axis: 'y'
      }
    }
});
</script>
</html>
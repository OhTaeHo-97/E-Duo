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
   <mytag:header/>

    <div class="site-section">
      <div class="container">

        <div class="row mb-5">
          <div class="col-md-9 order-2">
            <div class="row mb-5">

              <div class="col-sm-6 col-lg-12 mb-4" data-aos="fade-up">
                <div class="block-4 border" style = "padding: 20px;">
                  <h3 class="mb-3 h6 text-uppercase text-black d-block">추이 그래프</h3>
                  <div class = "text-center">
                    <figure class="block-4-image">
                          <canvas id="line-chart" width="60px" height="50px"></canvas>
                    </figure>
                  </div>
                </div>
              </div>
              <div class="col-sm-6 col-lg-6 mb-4" data-aos="fade-up">
                <div class="block-4 border">
                  <div style = "padding: 20px 20px 10px 20px; border-bottom: 1px solid #dee2e6;">
                     <a href = "bulletin_category.bul?category=free">
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
                     <a href = "bulletin_category.bul?category=info">
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
                     <a href = "bulletin_category.bul?category=fresh">
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
                     <a href = "bulletin_category.bul?category=ad">
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
                     <a href = "bulletin_category.bul?category=job">
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
                     <a href = "bulletin_category.bul?category=market">
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
</html>

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
    plugins: {
      title: {
        display: true,
        text: '학기별 추이 그래프',
        font: {
          size: 30
        }
      }
    }
  }
});
</script>

<script>
  new Chart(document.getElementById("bar-chart-horizontal"), {
  type: 'bar',
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
    indexAxis: 'y',
    legend: { display: false }
  }
});
</script>
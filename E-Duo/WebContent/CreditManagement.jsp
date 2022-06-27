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

    <div class="site-section" style = "padding-top: 0;">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <div class="site-section site-blocks-2">
                <div class="row justify-content-center text-center mb-5">
                  <div class="col-md-7 pt-4">
                    <h2>학점 관리</h2>
                  </div>
                </div>
                <div class="row" style = "margin: 0 auto;">
                  <div class="col-sm-6 col-md-6 col-lg-3-2 mb-4 mb-lg-0" data-aos="fade" data-aos-delay="" style = "height: 40px; text-align: center; line-height: 40px; margin-right: 0.5%; background-color: #dee2e6;">
                    <a href="#">
                      <div>
                        <span class="text-uppercase text-black">1학년 1학기</span>
                        <!-- <h3><span class = "text-black">1학년 1학기</span></h3> -->
                      </div>
                    </a>
                  </div>
                  <div class="col-sm-6 col-md-6 col-lg-3-2 mb-4 mb-lg-0" data-aos="fade" data-aos-delay="" style = "height: 40px; text-align: center; line-height: 40px; margin-right: 0.5%;">
                    <a href="#">
                      <div>
                        <span class="text-uppercase text-black">1학년 2학기</span>
                        <!-- <h3><span class = "text-black">1학년 1학기</span></h3> -->
                      </div>
                    </a>
                  </div>
                  <div class="col-sm-6 col-md-6 col-lg-3-2 mb-4 mb-lg-0" data-aos="fade" data-aos-delay="" style = "height: 40px; text-align: center; line-height: 40px; margin-right: 0.5%;">
                    <a href="#">
                      <div>
                        <span class="text-uppercase text-black">2학년 1학기</span>
                        <!-- <h3><span class = "text-black">1학년 1학기</span></h3> -->
                      </div>
                    </a>
                  </div>
                  <div class="col-sm-6 col-md-6 col-lg-3-2 mb-4 mb-lg-0" data-aos="fade" data-aos-delay="" style = "height: 40px; text-align: center; line-height: 40px; margin-right: 0.5%;">
                    <a href="#">
                      <div>
                        <span class="text-uppercase text-black">2학년 2학기</span>
                        <!-- <h3><span class = "text-black">1학년 1학기</span></h3> -->
                      </div>
                    </a>
                  </div>
                  <div class="col-sm-6 col-md-6 col-lg-3-2 mb-4 mb-lg-0" data-aos="fade" data-aos-delay="" style = "height: 40px; text-align: center; line-height: 40px; margin-right: 0.5%;">
                    <a href="#">
                      <div>
                        <span class="text-uppercase text-black">3학년 1학기</span>
                        <!-- <h3><span class = "text-black">1학년 1학기</span></h3> -->
                      </div>
                    </a>
                  </div>
                  <div class="col-sm-6 col-md-6 col-lg-3-2 mb-4 mb-lg-0" data-aos="fade" data-aos-delay="" style = "height: 40px; text-align: center; line-height: 40px; margin-right: 0.5%;">
                    <a href="#">
                      <div>
                        <span class="text-uppercase text-black">3학년 2학기</span>
                        <!-- <h3><span class = "text-black">1학년 1학기</span></h3> -->
                      </div>
                    </a>
                  </div>
                  <div class="col-sm-6 col-md-6 col-lg-3-2 mb-4 mb-lg-0" data-aos="fade" data-aos-delay="" style = "height: 40px; text-align: center; line-height: 40px; margin-right: 0.5%;">
                    <a href="#">
                      <div>
                        <span class="text-uppercase text-black">4학년 1학기</span>
                        <!-- <h3><span class = "text-black">1학년 1학기</span></h3> -->
                      </div>
                    </a>
                  </div>
                  <div class="col-sm-6 col-md-6 col-lg-3-2 mb-4 mb-lg-0" data-aos="fade" data-aos-delay="" style = "height: 40px; text-align: center; line-height: 40px;">
                    <a href="#">
                      <div>
                        <span class="text-uppercase text-black">4학년 2학기</span>
                        <!-- <h3><span class = "text-black">1학년 1학기</span></h3> -->
                      </div>
                    </a>
                  </div>
                </div>
            </div>
          </div>
        </div>
        <div class="row mb-5">
          <div class="col-md-9 order-2">
            <div class="row mb-5">

              <div class="col-sm-6 col-lg-4 mb-4" data-aos="fade-up">
                <div class="block-4 border" style = "padding: 20px;">
                  <h3 class="mb-3 h6 text-uppercase text-black d-block" style = "display: inline-block !important;">목표 학점 : </h3>
                    <span style = "margin-left: 4%;">${stu_data.obj_credit}</span>
                </div>
              </div>
              <div class="col-sm-6 col-lg-4 mb-4" data-aos="fade-up">
                <div class="block-4 border" style = "padding: 20px;">
                  <h3 class="mb-3 h6 text-uppercase text-black d-block" style = "display: inline-block !important;">이수 학점/남은 학점 : </h3>
                    <span style = "margin-left: 4%;">${all_credit}/${stu_data.graduate_credit}</span>
                </div>
              </div>
              <div class="col-sm-6 col-lg-4 mb-4" data-aos="fade-up">
                <div class="block-4 border" style = "padding: 20px;">
                  <h3 class="mb-3 h6 text-uppercase text-black d-block" style = "display: inline-block !important;">잔여 학기 필요한 평균학점: </h3>
                    <span style = "margin-left: 4%;">3</span>
                </div>
              </div>
              <div class="col-sm-6 col-lg-12 mb-4" data-aos="fade-up">
                <div class="block-4 border" style = "padding: 20px;">
                  <h3 class="mb-3 h6 text-uppercase text-black d-block">추이 그래프</h3>
                  <div class = "text-center">
                    <figure class="block-4-image">
                      <a href="shop-single.html"><img src="images/cloth_1.jpg" alt="Image placeholder" class="img-fluid"></a>
                    </figure>
                  </div>
                </div>
              </div>
              <div class="col-sm-6 col-lg-12 mb-4" data-aos="fade-up">
                <div class="block-4 border" style = "padding: 20px;">
                  <h3 class="mb-3 h6 text-uppercase text-black d-block">
                    수강 과목 및 학점
                  </h3>
                  <div style = "display:inline-block;">
                    <select style = "border: none;">
                      <option value = "">4.5 만점</option>
                      <option value = "">4.5 만점(A- 포함)</option>
                      <option value = "">4.3 만점</option>
                    </select>
                    <span class = "text-black" style = "margin-left: 30px; font-size: 1.1rem;">총 평점 : ${this_semester_credit_average}</span>
                  </div>
                  <div style = "width:80%; margin: 20px auto; clear: both; margin-top: 30px;">
                    <table border = "1" style = "width:100%; border-color: #ced4da;">
                      <tr>
                        <th>과목 이름</th>
                        <th>전공 여부</th>
                        <th>성적</th>
                        <th>학점</th>
                      </tr>
                      <tr>
                        <td><input type="text" name="" id="" value = "웹개발" style = "border:none; width: 100%;"></td>
                        <td>
                          <select name="" id="" style = "border: none; width: 100%;">
                            <option value="">전공 필수</option>
                            <option value="">전공 선택</option>
                            <option value="">교양 필수</option>
                            <option value="">교양 필수</option>
                          </select>
                        </td>
                        <td>
                          <select name="" id="" style = "border: none; width: 100%;">
                            <option value="">A+</option>
                            <option value="">A0</option>
                            <option value="">A-</option>
                            <option value="">B+</option>
                            <option value="">B0</option>
                            <option value="">B-</option>
                            <option value="">C+</option>
                            <option value="">C0</option>
                            <option value="">C-</option>
                            <option value="">D+</option>
                            <option value="">D0</option>
                            <option value="">D-</option>
                            <option value="">F</option>
                          </select>
                        </td>
                        <td><input type="text" name="" id="" value = "2" style = "border: none; width: 100%;"></td>
                      </tr>
                    </table>
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
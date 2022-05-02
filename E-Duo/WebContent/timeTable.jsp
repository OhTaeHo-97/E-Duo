<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shoppers &mdash; Colorlib e-Commerce Template</title>
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
<style>
	#subjects {
		position: fixed;
		z-index: 99;
		bottom: 0;
		width: 100%;
		background-color: #fff;
		overflow: hidden;
	}
	tr.content:hover {
		background-color: rgba(99, 99, 99, 0.3);
		cursor: pointer;
	}
</style>
</head>
<body>
	<div class="site-wrap">
    <header class="site-navbar" role="banner">
      <div class="site-navbar-top">
        <div class="container">
          <div class="row align-items-center">

            <div class="col-6 col-md-4 order-2 order-md-1 site-search-icon text-left">
              <form action="" class="site-block-top-search">
                <span class="icon icon-search2"></span>
                <input type="text" class="form-control border-0" placeholder="Search">
              </form>
            </div>

            <div class="col-12 mb-3 mb-md-0 col-md-4 order-1 order-md-2 text-center">
              <div class="site-logo">
                <a href="index.html" class="js-logo-clone">Shoppers</a>
              </div>
            </div>

            <div class="col-6 col-md-4 order-3 order-md-3 text-right">
              <div class="site-top-icons">
                <ul>
                  <li><a href="#"><span class="icon icon-person"></span></a></li>
                  <li><a href="#"><span class="icon icon-heart-o"></span></a></li>
                  <li>
                    <a href="cart.html" class="site-cart">
                      <span class="icon icon-shopping_cart"></span>
                      <span class="count">2</span>
                    </a>
                  </li> 
                  <li class="d-inline-block d-md-none ml-md-0"><a href="#" class="site-menu-toggle js-menu-toggle"><span class="icon-menu"></span></a></li>
                </ul>
              </div> 
            </div>

          </div>
        </div>
      </div> 
      <nav class="site-navigation text-right text-md-center" role="navigation">
        <div class="container">
          <ul class="site-menu js-clone-nav d-none d-md-block">
            <li class="has-children">
              <a href="index.html">Home</a>
              <ul class="dropdown">
                <li><a href="#">Menu One</a></li>
                <li><a href="#">Menu Two</a></li>
                <li><a href="#">Menu Three</a></li>
                <li class="has-children">
                  <a href="#">Sub Menu</a>
                  <ul class="dropdown">
                    <li><a href="#">Menu One</a></li>
                    <li><a href="#">Menu Two</a></li>
                    <li><a href="#">Menu Three</a></li>
                  </ul>
                </li>
              </ul>
            </li>
            <li class="has-children active">
              <a href="about.html">About</a>
              <ul class="dropdown">
                <li><a href="#">Menu One</a></li>
                <li><a href="#">Menu Two</a></li>
                <li><a href="#">Menu Three</a></li>
              </ul>
            </li>
            <li><a href="shop.html">Shop</a></li>
            <li><a href="#">Catalogue</a></li>
            <li><a href="#">New Arrivals</a></li>
            <li><a href="contact.html">Contact</a></li>
          </ul>
        </div>
      </nav>
    </header>

    <div class="bg-light py-3">
      <div class="container">
        <div class="row">
          <div class="col-md-12 mb-0"><a href="index.html">Home</a> <span class="mx-2 mb-0">/</span> <strong class="text-black">About</strong></div>
        </div>
      </div>
    </div>  

    <div class="site-section border-bottom" data-aos="fade">
      <div class="container">
      <div class="row">
          <div class="col-md-12">
            <div class="site-section site-blocks-2">
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
          <div class="col-md-12">
            <h3 style = "text-align:center;">시간표</h3>
            <table border = "1" width = "100%" height = "2000" style = "border-color:lightgrey;">
              <thead>
                <tr height = "50" style = "text-align:center; background-color:#cae1f2;">
                  <th width = "10%"></th>
                  <th width = "18%">월</th>
                  <th width = "18%">화</th>
                  <th width = "18%">수</th>
                  <th width = "18%">목</th>
                  <th width = "18%">금</th>
                </tr>
              </thead>
              <tbody>
                <tr height = "130" style = "text-align:center;">
                  <td style = "background-color:#cae1f2;">오전 9시</td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                </tr>
                <tr style = "text-align:center;">
                  <td style = "background-color:#cae1f2;">오전 10시</td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                </tr>
                <tr style = "text-align:center;">
                  <td style = "background-color:#cae1f2;">오전 11시</td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                </tr>
                <tr style = "text-align:center;">
                  <td style = "background-color:#cae1f2;">오후 12시</td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                </tr>
                <tr style = "text-align:center;">
                  <td style = "background-color:#cae1f2;">오후 1시</td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                </tr>
                <tr style = "text-align:center;">
                  <td style = "background-color:#cae1f2;">오후 2시</td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                </tr>
                <tr style = "text-align:center;">
                  <td style = "background-color:#cae1f2;">오후 3시</td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                </tr>
                <tr style = "text-align:center;">
                  <td style = "background-color:#cae1f2;">오후 4시</td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                </tr>
                <tr style = "text-align:center;">
                  <td style = "background-color:#cae1f2;">오후 5시</td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                </tr>
                <tr style = "text-align:center;">
                  <td style = "background-color:#cae1f2;">오후 6시</td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                </tr>
                <tr style = "text-align:center;">
                  <td style = "background-color:#cae1f2;">오후 7시</td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                </tr>
                <tr style = "text-align:center;">
                  <td style = "background-color:#cae1f2;">오후 8시</td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                </tr>
                <tr style = "text-align:center;">
                  <td style = "background-color:#cae1f2;">오후 9시</td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                </tr>
                <tr style = "text-align:center;">
                  <td style = "background-color:#cae1f2;">오후 10시</td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                </tr>
                <tr style = "text-align:center;">
                  <td style = "background-color:#cae1f2;">오후 11시</td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                </tr>
              </tbody>
            </table>
            <br><br>
            <div style = "text-align:right; font-size: 1.5rem; font-weight:bold;">
              <span>현재 학점 : </span><span>${avg_credit}</span>
              <span style = "margin-left:5%;">이수 학점 : </span><span>${total_credit_num}</span>
            </div>
            <div style = "margin-top:3%;">
              <input type = "button" class="btn btn-primary btn-lg" style="float: right;" onclick = "location.href = 'showCreditManage.cre'" value = "학점 관리 페이지로 이동">
              <input type = "button" class="btn btn-primary btn-lg" style="float: right; margin-right: 2%;" onclick = "getSubject(); return false;" value = "수업 목록에서 검색">
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="col-md-12 border" id="subjects" style="position: fixed; display: block; width: 100%; overflow: scroll;">
      <div class="form-group row" style="margin-top: 20px;">
        <div class="col-md-9">
        	<input type="text" class="form-control" id="srch_subject" name="subject" style = "display: inline-block; width: 70%; margin-left: 20%;" placeholder = "과목을 입력하세요.">
        	<input type="button" id="searchSub" class="btn btn-secondary btn-sm dropdown-toggle" style="display: inline-block; width: 8%;" value="검색">
        </div>
        <div class="col-md-3">
        	<input type="button" id="close_tab" class="btn btn-secondary btn-sm dropdown-toggle" style="margin-left: 20%;" value="닫기" onclick="close_tab()">
        </div>
      </div>
      <div class="form-group" style="height: 150px; margin-top: 20px;">
        <div class="col-md-10" style="margin: 0 auto;">
          <table style="width: 100%;" id="subject_table" border="1">
            <tr>
              <th>학수번호</th>
              <th>과목명</th>
              <th>이수</th>
              <th>학점</th>
              <th>교수</th>
              <th>시간</th>
              <th>강의실</th>
            </tr>
          </table>
        </div>
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
  <script>
    function close_tab() {
      document.getElementById("subjects").style.display = 'none';
	}
  </script>
  <script>
	$('#searchSub').click(function(){
		let subject = $('#srch_subject').val();
		$.ajax({
			url : "getSubjects.timetable",
			type : "GET",
			data : {subject: subject},
			dataType : 'JSON',
			success : function(result){
				let data = JSON.parse(JSON.stringify(result));
				console.log(data);
				$("table#subject_table").children().remove();
				$('<tr><th>학수번호</th><th>과목명</th><th>이수</th><th>학점</th><th>교수</th><th>시간</th><th>강의실</th></tr>').appendTo($("#subject_table"));
				$.each(data, function(k, d) {
					$('<tr class="content" onclick=location.href="insertSubject.timetable?aca=' + d.academic_number
							+ '&grade=' + <%= request.getAttribute("grade") %> + '&semester=' + <%= request.getAttribute("semester") %> + '"><td>' + d.academic_number + '</td><td>' + d.subject_name + '</td>'
							+ '<td>' + d.sub_sort + '</td><td>' + d.credit_num + '</td><td>' + d.professor + '</td>'
							+ '<td>' + d.first_date + ' ' + d.first_start + '~' + d.first_end + '<br>'
							+ d.second_date + ' ' + d.second_start + '~' + d.second_end + '<br>'
							+ d.third_date + ' ' + d.third_start + '~' + d.third_end + '</td>'
							+ '<td>' + d.classroom + '</td>' + '</tr>').appendTo($("#subject_table"));
					/* $('<li><a href="javascript:void(0);" onclick="findUniv(\'' + k + '\',\'' + v + '\');">' + v + '</a></li>').val(k).text(v).appendTo($("#univ_list")); */
					/* $('<li onclick="findUniv(\'' + k + '\',\'' + v + '\');">' + v + '</li>').val(k).text(v).appendTo($("#sub_list")); */
					console.log(d.sub_id);
				});
			},
			error : function(){
				alert("서버요청실패");
			}
		});
	});
  </script>
</body>
</html>
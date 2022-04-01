<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<script src = "js/jquery-3.6.0.min.js"></script>
<script src = "js/register.js"></script>
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
            <li class="has-children">
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
            <li class="active"><a href="contact.html">Contact</a></li>
          </ul>
        </div>
      </nav>
    </header>

    <div class="bg-light py-3">
      <div class="container">
        <div class="row">
          <div class="col-md-12 mb-0"><a href="index.html">Home</a> <span class="mx-2 mb-0">/</span> <strong class="text-black">Contact</strong></div>
        </div>
      </div>
    </div>  

    <div class="site-section">
      <div class="container">
        <div>
          <div class="col-md-12">
            <h2 class="h3 mb-3 text-black">회원가입</h2>
          </div>
          <div class="w-100">

            <form action="register.mem" method="POST" name = "registerForm" id = "registerForm" onsubmit = "return register_check()">
              
              <div class="p-3 p-lg-5 border">
                <div class="form-group row">
                  <div class="col-md-6">
                    <label for="register_stu_id" class="text-black">아이디 <span class="text-danger">*</span></label>
                    <input type="text" class="form-control" id="register_stu_id" name="stu_id" placeholder = "아이디를 입력하세요.">
                  </div>
                  <div class="col-md-6" style = "display: absolute; top: 40px;">
                  	&nbsp;&nbsp;&nbsp;<font id = "checkId"></font>
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-md-12">
                    <label for="register_password" class="text-black">비밀번호 <span class="text-danger">*</span></label>
                    <input type="text" class="form-control" id="register_password" name="password" placeholder = "비밀번호를 입력하세요.">
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-md-12">
                    <label for="register_password_check" class="text-black">비밀번호 확인 <span class="text-danger">*</span></label>
                    <input type="text" class="form-control" id="register_password_check" name="password_check" placeholder = "비밀번호 확인">
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-md-6">
                    <label for="register_nickname" class="text-black">닉네임 <span class="text-danger">*</span></label>
                    <input type="text" class="form-control" id="register_nickname" name="nickname" placeholder = "닉네임을 입력하세요.">
                  </div>
                  <div class="col-md-6" style = "display: absolute; top: 40px;">
                  	&nbsp;&nbsp;&nbsp;<font id = "checkNickname"></font>
                  </div>
                </div>
                <div class="form-group row" style="margin-top: 2%;">
                  <div class="col-md-12">
                    <label for="gender" class="text-black">성별 <span class="text-danger">*</span></label>
                    <input type="radio" class="text-black" id="register_gender_m" name="gender" value="M" style="margin-left: 1%;" checked><span class="text-black">남</span>
                    <input type="radio" class="text-black" id="register_gender_f" name="gender" value="F" style="margin-left: 1%;"><span class="text-black">여</span>
                  </div>
                </div>
                <div class="form-group row" style="margin-top: 2%;">
                  <div class="col-md-12">
                    <label for="register_birth" class="text-black">생년월일 <span class="text-danger">*</span></label>
                    <input type="date" class="form-control" id="register_birth" name="birth">
                  </div>
                </div>
                <div class="form-group row" style="margin-top: 3%;">
                  <div class="col-md-12">
                    <label for="register_cellphone" class="text-black">전화번호 <span class="text-danger">*</span></label>
                    <input type="text" class="form-control" id="register_cellphone" name="cellphone" placeholder = "-를 제외한 전화번호를 입력해주세요.">
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-md-12">
                    <label for="register_email" class="text-black">이메일 <span class="text-danger">*</span></label>
                    <input type="text" class="form-control" id="register_email" name="email" placeholder = "이메일을 입력하세요.">
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-md-12">
                  	<label for="sample6_detailAddress" class="text-black">주소 <span class="text-danger">*</span></label><br>
                  	<div class = "col-md-3" style = "float: left; padding: 0;">
                  		<input type="text" class = "form-control" id="sample6_postcode" name = "postcode" placeholder="우편번호" readonly>
                  	</div>
                  	<div class = "col-md-3" style = "float: left; margin-left: 3%; padding: 0; line-height: 1.8;">
                  		<input type="button" class="btn btn-secondary btn-sm dropdown-toggle" onclick="sample6_execDaumPostcode()" value="우편번호 찾기">
                  	</div>
                  	<br><br>
					<div class = "col-md-9" style = "float: left; padding: 0;">
						<input type="text" class = "form-control" id="sample6_address" name = "address" placeholder="주소" readonly>
					</div>
					<div class = "col-md-3" style = "float: left; padding: 0; padding-left: 1%;">
						<input type="text" class = "form-control" id="sample6_extraAddress" name = "reference" placeholder="참고항목" readonly>
					</div>
					<br><br>
					<input type="text" class = "form-control" id="sample6_detailAddress" name = "detail_address" placeholder="상세주소">
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-md-6">
                    <label for="register_university" class="text-black">대학교 <span class="text-danger">*</span></label>
                    <input type="text" class="form-control" id="register_university" name="university" placeholder = "대학교">
                  </div>
                  <div class="col-md-6">
                   	<button class="btn btn-secondary btn-sm" onclick="getUniversity()" style="display: absolute; top: 35px;">대학교 검색</button>
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-md-12">
                    <label for="register_graduate_credit" class="text-black">졸업학점 </label>
                    <input type="text" class="form-control" id="register_graduate_credit" name="graduate_credit" placeholder = "졸업학점">
                  </div>
                </div>
                <div class="form-group row" style="margin-top: 3%;">
                  <div class="col-md-6">
                    <label for="register_grade" class="text-black">학년 <span class="text-danger">*</span></label>
                    <select class = "form-control pl-0 bg-white" name = "grade" id="register_grade">
                      <option value = "1" selected>1학년</option>
                      <option value = "2">2학년</option>
                      <option value = "3">3학년</option>
                      <option value = "4">4학년</option>
                    </select>
                  </div>
                  <div class="col-md-6">
                    <label for="register_semester" class="text-black">학기 <span class="text-danger">*</span></label>
                    <select class = "form-control pl-0 bg-white" name = "semester" id="register_semester">
<!--                     style="width:40%; margin-left: 2%;" -->
                      <option value = "1" selected>1학기</option>
                      <option value = "2">2학기</option>
                    </select>
                  </div>
                </div>
                <div class="form-group row" style="margin-top: 4%;">
                  <div class="col-lg-6">
                    <input type="submit" class="btn btn-primary btn-lg btn-block" value="회원가입">
                  </div>
                  <div class="col-lg-6">
                    <input type="button" class="btn btn-primary btn-lg btn-block" value="뒤로 가기" onclick = "location.href = 'index.jsp'">
                  </div>
                </div>
              </div>
            </form>
          </div>
          
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
  
  <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script>
	    function sample6_execDaumPostcode() {
	        new daum.Postcode({
	            oncomplete: function(data) {
	                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
	
	                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
	                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
	                var addr = ''; // 주소 변수
	                var extraAddr = ''; // 참고항목 변수
	
	                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
	                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
	                    addr = data.roadAddress;
	                } else { // 사용자가 지번 주소를 선택했을 경우(J)
	                    addr = data.jibunAddress;
	                }
	
	                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
	                if(data.userSelectedType === 'R'){
	                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
	                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
	                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
	                        extraAddr += data.bname;
	                    }
	                    // 건물명이 있고, 공동주택일 경우 추가한다.
	                    if(data.buildingName !== '' && data.apartment === 'Y'){
	                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
	                    }
	                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
	                    if(extraAddr !== ''){
	                        extraAddr = ' (' + extraAddr + ')';
	                    }
	                    // 조합된 참고항목을 해당 필드에 넣는다.
	                    document.getElementById("sample6_extraAddress").value = extraAddr;
	                
	                } else {
	                    document.getElementById("sample6_extraAddress").value = '';
	                }
	
	                // 우편번호와 주소 정보를 해당 필드에 넣는다.
	                document.getElementById('sample6_postcode').value = data.zonecode;
	                document.getElementById("sample6_address").value = addr;
	                // 커서를 상세주소 필드로 이동한다.
	                document.getElementById("sample6_detailAddress").focus();
	            }
	        }).open();
	    }
	</script>
	<script>
		$('#register_stu_id').focusout(function(){
			let memberId = $('#register_stu_id').val(); // input_id에 입력되는 값
			
			$.ajax({
				url : "idRedundancyCheck.mem",
				type : "post",
				data : {memberId: memberId},
				dataType : 'json',
				success : function(result){
					if(result == 0){
						$("#checkId").html('사용할 수 없는 아이디입니다.');
						$("#checkId").attr('color','red');
					} else{
						$("#checkId").html('사용할 수 있는 아이디입니다.');
						$("#checkId").attr('color','green');
					} 
				},
				error : function(){
					alert("서버요청실패");
				}
			})
		})
	 </script>
	 <script>
		$('#register_nickname').focusout(function(){
			let memberNickname = $('#register_nickname').val();
			
			$.ajax({
				url : "nicknameRedundancyCheck.mem",
				type : "post",
				data : {memberNickname: memberNickname},
				dataType : 'json',
				success : function(result){
					if(result == 0){
						$("#checkNickname").html('사용할 수 없는 닉네임입니다.');
						$("#checkNickname").attr('color','red');
					} else{
						$("#checkNickname").html('사용할 수 있는 닉네임입니다.');
						$("#checkNickname").attr('color','green');
					} 
				},
				error : function(){
					alert("서버요청실패");
				}
			})
		})
	 </script>
</body>
<script>
	function getUniversity() {
		window.open("getUniversity.jsp", "getUniversity", width=400, height=300, toolbar="no");
	}
</script>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "mytag" tagdir = "/WEB-INF/tags" %>
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
    <script src="js/editInfo.js"></script>
</head>
<body>
	<div class="site-wrap">
    <mytag:header />

    <div class="site-section">
      <div class="container">
        <div>
          <div class="col-md-12">
            <h2 class="h3 mb-3 text-black">개인 정보 변경 페이지</h2>
          </div>
          <div class="w-100">

            <form action="editMyInfo.mem" method="post" name="editInfoForm" id="editInfoForm" onsubmit="return editInfo_check()">
              
              <div class="p-3 p-lg-5 border">
                <div class="form-group row">
                  <div class="col-md-12">
                    <label for="edit_uid" class="text-black">아이디 </label>
                    <input type="text" id = "edit_uid" class="form-control" value = "${user_id}" readonly>
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-md-12">
                    <label for="edit_new_upw" class="text-black">새로운 비밀번호 </label>
                    <input type="password" class="form-control" id="edit_new_upw" name="new_upw" placeholder="새로운 비밀번호를 입력해주세요.">
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-md-12">
                    <label for="edit_confirm_upw" class="text-black">새로운 비밀번호 확인 </label>
                    <input type="password" class="form-control" id="edit_confirm_upw" name="confirm_upw" placeholder="새로운 비밀번호를 다시 한 번 입력해주세요.">
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-md-12">
                    <label for="edit_uname" class="text-black">이름 </label>
                    <input type="text" class="form-control" id="edit_uname" name="uname" value="${stu_info.name}">
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-md-6">
                    <label for="register_nickname" class="text-black">닉네임 <span class="text-danger">*</span></label>
                    <input type="text" class="form-control" id="edit_nickname" name="nickname" placeholder = "닉네임을 입력하세요." value="${stu_info.nickname}">
                    <input type="hidden" id="prev_nickname" value="${stu_info.nickname}">
                  </div>
                  <div class="col-md-6" style = "display: absolute; top: 40px;">
                  	&nbsp;&nbsp;&nbsp;<font id = "checkNickname"></font>
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-md-12">
                    <label for="edit_phone" class="text-black">전화번호 </label>
                    <input type="text" class="form-control" id="edit_phone" name="phone" value="${stu_info.cellphone}">
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-md-12">
                    <label for="edit_email" class="text-black">이메일 </label>
                    <input type="text" class="form-control" id="edit_email" name="email" value="${stu_info.email}">
                  </div>
                </div>
                <div class="form-group row">
                	<div class="col-md-12">
	                  	<label for="sample6_detailAddress" class="text-black">주소 </label><br>
	                  	<div class = "col-md-3" style = "float: left; padding: 0;">
	                  		<input type="text" class = "form-control" id="sample6_postcode" name = "postcode" value = "${stu_info.postcode}" placeholder="우편번호" readonly>
	                  	</div>
	                  	<div class = "col-md-3" style = "float: left; margin-left: 3%; padding: 0; line-height: 1.8;">
	                  		<input type="button" class="btn btn-secondary btn-sm dropdown-toggle" onclick="sample6_execDaumPostcode()" value="우편번호 찾기">
	                  	</div>
	                  	<br><br>
						<div class = "col-md-9" style = "float: left; padding: 0;">
							<input type="text" class = "form-control" id="sample6_address" name = "address" value = "${stu_info.address}" placeholder="주소" readonly>
						</div>
						<div class = "col-md-3" style = "float: left; padding: 0; padding-left: 1%;">
							<input type="text" class = "form-control" id="sample6_extraAddress" name = "reference" value = "${stu_info.refernece}" placeholder="참고항목" readonly>
						</div>
						<br><br>
						<input type="text" class = "form-control" id="sample6_detailAddress" name = "detail_address" value = "${stu_info.detail_address}" placeholder="상세주소">
					</div>
                </div>
                <%-- <div class="form-group row">
                  <div class="col-md-12">
                    <label for="edit_univ" class="text-black">대학교 </label>
                    <input type="text" class="form-control" id="edit_univ" name="univ" value="${univ}">
                  </div>
                </div> --%>
                <div class="form-group row">
                  <div class="col-md-6">
                    <label for="register_university" class="text-black">대학교 <span class="text-danger">*</span></label>
                    <input type="text" class="form-control" id="register_university" placeholder = "대학교" value="${univ.uni_name}" readonly>
                    <input type="hidden" name="university" id="univ_id" value="${univ.uni_id}">
                  </div>
                  <div class="col-md-6">
                   	<button class="btn btn-secondary btn-sm" id="univ_btn" onclick="getUniversity(); return false;" style="display: absolute; top: 35px;">대학교 검색</button>
                  </div>
                </div>
                <div class="form-group row">
                	<div class="col-md-12">
	                    <label for="register_graduate_credit" class="text-black">졸업학점 </label>
	                    <input type="text" class="form-control" id="register_graduate_credit" name="graduate_credit" value = "${stu_info.graduate_credit}" placeholder = "졸업학점">
                  	</div>
                </div>
                <div class="form-group row" style = "margin-top: 4%;">
                  <div class="col-md-6">
                    <label for="edit_grade" class="text-black">학년 </label>
                    <select id = "edit_grade" name = "grade" style = "width:40%; margin-left: 2%;">
                    	<c:forEach var = "cnt" begin = "1" end = "4" step = "1">
                    		<c:choose>
                    			<c:when test = "${cnt eq stu_info.grade}">
                    				<option value = "${cnt}" selected>${cnt}학년</option>
                    			</c:when>
                    			<c:otherwise>
                    				<option value = "${cnt}">${cnt}학년</option>
                    			</c:otherwise>
                    		</c:choose>
                    	</c:forEach>
<!--                       <option value = "1">1학년</option> -->
<!--                       <option value = "2">2학년</option> -->
<!--                       <option value = "3">3학년</option> -->
<!--                       <option value = "4">4학년</option> -->
                    </select>
                  </div>
                  <div class="col-md-6">
                    <label for="edit_term" class="text-black">학기 </label>
                    <select id = "edit_term" name = "term" style = "width:40%; margin-left: 2%;">
                      <c:forEach var = "cnt" begin = "1" end = "2" step = "1">
                    		<c:choose>
                    			<c:when test = "${cnt eq stu_info.semester}">
                    				<option value = "${cnt}" selected>${cnt}학기</option>
                    			</c:when>
                    			<c:otherwise>
                    				<option value = "${cnt}">${cnt}학기</option>
                    			</c:otherwise>
                    		</c:choose>
                    	</c:forEach>
<!--                       <option value = "1">1학기</option> -->
<!--                       <option value = "2">2학기</option> -->
                    </select>
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-md-12">
                    <label for="edit_univ" class="text-black">목표 학점 </label>
                    <input type="text" class="form-control-style" id="obj_credit" name="obj_credit" value="${stu_info.obj_credit}" style = "margin:4% 0 0 5%; width:30% !important;">
                  </div>
                </div>

                <div class="form-group row" style = "margin-top: 10%; clear:both;">
                  <div class="col-lg-6">
                    <input type="submit" class="btn btn-primary btn-lg btn-block" value="변경">
                  </div>
                  <div class="col-lg-6">
                    <input type="button" class="btn btn-primary btn-lg btn-block" value="개인 정보 페이지로 돌아가기" onclick="location.href='PersonalInformationPage.jsp'">
                  </div>
                </div>
              </div>
            </form>
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
		$('#edit_nickname').focusout(function(){
			let memberNickname = $('#edit_nickname').val();
			let prev_nickname = $('#prev_nickname').val();
			if(memberNickname !== prev_nickname) {
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
			} else {
				$("#checkNickname").html('사용할 수 있는 닉네임입니다.');
				$("#checkNickname").attr('color','green');
			}
		})
	 </script>
</body>
<script>
	function getUniversity() {
		window.name = "EditInfoPage";
		windowObj = window.open("getUniversity.jsp", "getUniversity", width=300, height=200, toolbar="no");
	}
</script>
</html>
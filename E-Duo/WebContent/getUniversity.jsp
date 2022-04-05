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
<style>
	#univ_list {
		list-style: none;
		width: 100%;
		margin: 0px;
		padding: 0px;
	}
	#univ_list li {
		width: 100%;
		height: 50px;
		margin: 0px;
		padding: 5px;
	}
	#univ_list li:hover {
		cursor: pointer;
		box-shadow: 2px 2px 2px 1px rgba(0, 0, 0, 0.2);
	}
	
</style>
</head>
<body>
	<div class="site-wrap">

    <div class="site-section">
      <div class="container">
        <div>
          <div class="col-md-12">
            <h2 class="h3 mb-3 text-black">대학교 찾기</h2>
          </div>
          <div class="w-100">
             <div class="p-3 p-lg-5 border" style="height: 100%;">
               <div class="form-group row">
                 <div class="col-md-9">
                   <input type="text" class="form-control" id="srch_university" name="university" placeholder = "대학교를 입력하세요.">
                 </div>
                 <div class="col-md-3">
                   <input type="button" id="searchUniv" class="btn btn-secondary btn-sm dropdown-toggle" value="검색">
                 </div>
               </div>
               <div class="form-group row">
                 <div class="col-md-12">
                   <ul name="univ_list" id="univ_list">
                   	
                   </ul>
                 </div>
               </div>
             </div>
          </div>
          
        </div>
      </div>
    </div>
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
		$('#searchUniv').click(function(){
			let university = $('#srch_university').val(); // input_id에 입력되는 값
			
			$.ajax({
				url : "getUniversities.mem",
				type : "POST",
				data : {university: university},
				dataType : 'JSON',
				success : function(result){
					let data = JSON.parse(JSON.stringify(result));
					console.log(data);
					$.each(data, function(k, v) {
						/* $('<li><a href="javascript:void(0);" onclick="findUniv(\'' + k + '\',\'' + v + '\');">' + v + '</a></li>').val(k).text(v).appendTo($("#univ_list")); */
						$('<li onclick="findUniv(\'' + k + '\',\'' + v + '\');">' + v + '</li>').val(k).text(v).appendTo($("#univ_list"));
					});
				},
				error : function(){
					alert("서버요청실패");
				}
			})
		})
		
		function findUniv(k, v) {
			console.log(opener.document.getElementById("register_university"));
			opener.document.getElementById("register_university").value = v;
			opener.document.getElementById("univ_id").value = k;
			window.close();
		}
	</script>
</body>
</html>
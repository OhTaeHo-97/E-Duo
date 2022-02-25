/**
 * 
 */

const login_check = function() {
	const sid = document.loginForm.sid;
	if(sid.value == '') {
		alert("아이디를 입력해주세요.");
		sid.focus();
		return false;
	}
	if(sid.value.length < 6) {
		alert("아이디는 6글자 이상입니다.");
		sid.focus();
		return false;
	}
	// 6글자 이상
	
	const spw = document.loginForm.spw;
	if(spw.value == '') {
		alert("비밀번호를 입력해주세요.");
		spw.focus();
		return false;
	}
	if(spw.value.length < 8 || spw.value.length > 20) {
		alert("비밀번호는 8글자 이상, 20글자 이하입니다.");
		spw.focus();
		return false;
	}
	// 8글자 이상, 20글자 이하
	// 영어, 숫자, 특수기호만 허용
	const pw_check = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,20}$/;
	if(!(pw_check.test(spw.value))) {
		alert("비밀번호는 영문, 숫자, 특수문자 조합으로 이루어져 있습니다.");
		spw.focus();
		return false;
	}
	
	return true;
}
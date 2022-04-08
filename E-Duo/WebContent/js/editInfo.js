/**
 * 
 */

const editInfo_check = function() {
	const password = document.editInfoForm.new_upw;
	const password_check = document.editInfoForm.confirm_upw;
	// 8글자 이상, 20글자 이하
	// 영어, 숫자, 특수기호만 허용
	const pw_check = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,20}$/;
	if(password.value != '') {
		if(password_check.value == '') {
			alert("비밀번호 확인을 입력해주세요.");
			password_check.focus();
			return false;
		}
		if(!(pw_check.test(password.value))) {
			alert("비밀번호는 영문, 숫자, 특수문자 조합으로 이루어져 있습니다.");
			password.focus();
			return false;
		}
		if(password.value != password_check.value) {
			alert("비밀번호와 비밀번호 확인에 입력한 비밀번호가 다릅니다.");
			password.focus();
			return false;
		}
	} else if(password.value == '' && password_check.value != '') {
		alert("비밀번호를 입력해주세요.");
		password.focus();
		return false;
	}
	
	const name = document.editInfoForm.uname;
	if(name.value == '') {
		alert("이름을 입력해주세요.");
		name.focus();
		return false;
	}
	
	const nickname = document.editInfoForm.nickname;
	const check_nickname = document.getElementById("checkNickname");
	if(nickname.value == '') {
		alert("닉네임을 입력해주세요.");
		nickname.focus();
		return false;
	}
	if(nickname.value.length < 4) {
		alert("닉네임은 4자리 이상 입력해주세요.");
		nickname.focus();
		return false;
	}
	if(check_nickname.innerText == '사용할 수 없는 닉네임입니다.') {
		alert("닉네임을 확인해주세요.");
		nickname.focus();
		return false;
	}
	
	const cellphone = document.editInfoForm.phone;
	const cellphone_check = /^[0-9]*$/;
	if(cellphone.value == '') {
		alert("전화번호를 입력해주세요.");
		cellphone.focus();
		return false;
	}
	if(cellphone.value.indexOf('-') != -1) {
		alert("-를 제외한 전화번호를 입력해주세요.");
		cellphone.focus();
		return false;
	}
	if(cellphone.value.length < 9 || cellphone.value.length > 11) {
		alert("전화번호를 다시 입력해주세요.(집전화번호는 지역번호를 붙여서 입력해주세요.)");
		cellphone.focus();
		return false;
	}
	if(!(cellphone_check.test(cellphone.value))) {
		alert("전화번호를 다시 입력해주세요.");
		cellphone.focus();
		return false;
	}
	
	const email = document.editInfoForm.email;
	if(email.value == '') {
		alert("이메일을 입력해주세요.");
		email.focus();
		return false;
	} else {
		const email_check = /^[A-Za-z0-9\.\-]+@[A-Za-z0-9\.\-]+\.[A-Za-z0-9\.\-]+$/;
		if(!email_check.test(email.value)) {
			alert("이메일 형식을 확인해주세요.");
			email.focus();
			return false;
		}
	}
	
	const postcode = document.editInfoForm.postcode;
	if(postcode.value == '') {
		alert("우편번호 및 주소를 입력해주세요.");
		postcode.focus();
		return false;
	}
	
	const detail_address = document.editInfoForm.detail_address;
	if(detail_address.value == '') {
		alert("상세주소를 입력해주세요.");
		detail_address.focus();
		return false;
	}
	if(detail_address.value.length > 210) {
		alert("상세주소는 70자 이하입니다.");
		detail_address.focus();
		return false;
	}
	
	const university = document.editInfoForm.university;
	const univ_btn = document.getElementById("univ_btn");
	if(university.value == '') {
		alert("대학교를 입력해주세요.");
		univ_btn.focus();
		return false;
	}
	
	return true;
}
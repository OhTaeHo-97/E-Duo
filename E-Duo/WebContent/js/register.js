/**
 * 
 */

const register_check = function() {
	const stu_id = document.registerForm.stu_id;
	const check_id = document.getElementById("checkId");
	if(stu_id.value == '') {
		alert("아이디를 입력해주세요.");
		stu_id.focus();
		return false;
	}
	if(stu_id.value.length < 6) {
		alert("아이디는 6글자 이상입니다.");
		stu_id.focus();
		return false;
	}
	if(check_id.innerText != '사용할 수 있는 아이디입니다.') {
		alert("해당 아이디를 사용할 수 없습니다. 아이디를 다시 입력해주세요.");
		stu_id.focus();
		return false;
	}
	
	const password = document.registerForm.password;
	const password_check = document.registerForm.password_check;
	if(password.value == '') {
		alert("비밀번호를 입력해주세요.");
		password.focus();
		return false;
	}
	if(password.value.length < 8 || password.value.length > 20) {
		alert("비밀번호는 8글자 이상, 20글자 이하입니다.");
		password.focus();
		return false;
	}
	// 8글자 이상, 20글자 이하
	// 영어, 숫자, 특수기호만 허용
	const pw_check = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,20}$/;
	if(!(pw_check.test(password.value))) {
		alert("비밀번호는 영문, 숫자, 특수문자 조합으로 이루어져 있습니다.");
		password.focus();
		return false;
	}
	if(password_check.value == '') {
		alert("비밀번호 확인을 입력해주세요.");
		password_check.focus();
		return false;
	}
	if(password_check.value != password.value) {
		alert("비밀번호와 비밀번호 확인에 입력한 비밀번호가 다릅니다.");
		password.focus();
		return false;
	}
	
	const name = document.registerForm.name;
	if(name == '') {
		alert("이름을 입력해주세요.");
		name.focus();
		return false;
	}
	
	const birth = document.getElementById("register_birth");
	const birth_date = new Date(birth.value);
	let year = birth_date.getFullYear();
	let month = birth_date.getMonth() + 1;
	let day = birth_date.getDate();
	if(isNaN(year) || isNaN(month) || isNaN(day)) {
		alert("생년월일을 작성해주세요.");
		birth.focus();
		return false;
	}
	
	const cellphone = document.registerForm.cellphone;
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
	
	const email = document.registerForm.email;
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
	
	const postcode = document.registerForm.postcode;
	if(postcode.value == '') {
		alert("우편번호 및 주소를 입력해주세요.");
		postcode.focus();
		return false;
	}
	
	const detail_address = document.registerForm.detail_address;
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
	
	const university = document.registerForm.university;
	if(university == '') {
		alert("대학교를 입력해주세요.");
		university.focus();
		return false;
	}
	
	return true;
}
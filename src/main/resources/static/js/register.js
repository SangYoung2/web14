const registerCheck = {id: false, pw: false, pw_re: false, name: false, tel:false, email: false};
const registerBtns = document.getElementById("register_btns");
const inputTag = [...document.querySelectorAll("#register_box input")];
const info_span = [...document.querySelectorAll("#info_box span")];

const registerId = document.getElementById("register_id")
const registerPw = document.getElementById("register_pw")
const registerRePw = document.getElementById("register_re_pw")
const registerName = document.getElementById("register_name")
const registerTel = document.getElementById("register_tel")
const registerEmail = document.getElementById("register_email")

const registerSelectTel = document.getElementById("register_select_tel")
const registerSelectEmail = document.getElementById("register_select_email")


for (let i = 0; i < inputTag.length; i++) {
    inputTag[i].onblur = () => {
        info_span[i].removeAttribute("hidden");
    }
}

function id_check(id) {
    const idRegex = RegExp(/(?=(.*[0-9].*))(?=(.*[a-zA-Z].*)){6,10}/g);

    registerCheck.id = false;
    info_span[0].style.color = 'red';

    if(RegExp(/[ ]/g).test(id.value)){
        info_span[0].textContent = "ID에는 띄어쓰기가 포함 될 수 없습니다.";
    }
    // 입력하지 않았을 경우
    else if(id.length === 0){
        info_span[0].textContent = "필수 입력 사항입니다.";
    }
    // 영문과 숫자가 포함되어 있지 않을 경우
    else if(!idRegex.test(id)){
        info_span[0].textContent = 'ID는 영문 + 숫자 조합의 6~10자여야합니다';
    }
    // 확인
    else{
        info_span[0].textContent = '정상적인 ID입니다.';
        info_span[0].style.color = 'blue';
        registerCheck.id = true;
    }
}

function pw_check(pw){
    const pwRegex = RegExp(/(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d$@$!%*#?&]{8,15}/g);

    info_span[1].style.color = 'red';
    registerCheck.pw = false;

    if(RegExp(/[ ]/g).test(pw)){
        info_span[1].textContent = "비밀번호에는 띄어쓰기가 포함 될 수 없습니다.";
    }
    // 입력하지 않았을 경우
    else if(pw.length === 0){
        info_span[1].textContent = "필수 입력 사항입니다.";
    }
    // 영문과 숫자가 포함되어 있지 않을 경우
    else if(!pwRegex.test(pw)){
        info_span[1].textContent = '비밀번호는 띄어쓰기 없는 8~15자의 영문 대/소문자,숫자 또는 특수문자 조합으로 입력하셔야 합니다.';
    }
    // 통과
    else{
        info_span[1].textContent = '정상적인 비밀번호입니다.';
        info_span[1].style.color = 'blue';
        registerCheck.pw = true;
    }
}

function pw_re_check(pw){
    info_span[2].style.color = 'red';
    registerCheck.pw_re = true;

    if(pw === registerPw.value){
        info_span[2].textContent = '비밀번호가 일치합니다.';
        info_span[2].style.color = 'blue';
    }
    else {
        info_span[2].textContent = '비밀번호가 일치 하지 않습니다.';
        registerCheck.pw_re = false;
    }
}

function name_check(name){
    const nameReg = RegExp(/[!@#$%^&*_+\d]/g);

    info_span[3].style.color = 'red';
    registerCheck.name = false;

    if(nameReg.test(name)){
        info_span[3].textContent = '이름에 대한 정보가 정상적이지 않습니다.';
    }
    else if (name.length === 0) {
        info_span[3].textContent = "필수 입력 사항입니다.";
    }
    else {
        info_span[3].textContent = '이름이 정상적으로 입력 되었습니다.';
        info_span[3].style.color = 'blue';
        registerCheck.name = true;
    }
}

function tel_check(tel){
    const telReg = RegExp(/\d/g);

    info_span[4].style.color = 'red';
    registerCheck.tel = false;

    if(!telReg.test(tel)){
        info_span[4].textContent = '전화번호가 정상적이지 않습니다.';
    }
    else if(tel.length === 0){
        info_span[4].textContent = '필수 입력 사항입니다.';
    }
    else if(tel.length < 7 || tel.length > 8){
        info_span[4].textContent = '전화번호가 정상적이지 않습니다.';
    }
    else{
        info_span[4].textContent = '전화번호가 정상적으로 입력 되었습니다.';
        info_span[4].style.color = 'blue';
        registerCheck.tel = true;
    }
}

function email_check(email){
    const emailReg = RegExp(/^[a-zA-Z0-9+-\_.]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/);
    const emailReg2 = RegExp(/[a-zA-Z0-9]/);

    info_span[5].style.color = 'red';
    registerCheck.email = false;

    if(registerSelectEmail.value === ''){
        if(!emailReg.test(email)){
            info_span[5].textContent = 'email형식이 정상적이지 않습니다.';
        }
        else if(email.length === 0){
            info_span[5].textContent = '필수 입력사항입니다.';
        }
        else {
            info_span[5].textContent = 'email이 정상적으로 입력되었습니다.';
            info_span[5].style.color = 'blue';
            registerCheck.email = true;
        }

    }
    else {
        if(!emailReg2){
            info_span[5].textContent = 'email형식이 정상적이지 않습니다.';
        }
        else if(email.length === 0){
            info_span[5].textContent = '필수 입력사항입니다.';
        }
        else {
            info_span[5].textContent = 'email이 정상적으로 입력되었습니다.';
            info_span[5].style.color = 'blue';
            registerCheck.email = true;
        }
    }
}

function check_handle(e) {
    const targetValue = e.target.value;
    switch (e.target) {
        case registerId:
            id_check(targetValue);
            break;
        case registerPw:
            pw_check(targetValue);
            break;
        case registerRePw:
            pw_re_check(targetValue)
            break;
        case registerName:
            name_check(targetValue)
            break;
        case registerTel:
            tel_check(targetValue)
            break;
        case registerEmail:
            email_check(targetValue)
            break;
    }
}

inputTag.forEach(inputTag => {
    inputTag.addEventListener('change', e => {
        check_handle(e);
    })
})

function check_all_true(){
    for (const Key in registerCheck) {
        if(!registerCheck[Key]){
            return false;
        }
    }
    return true;
}

function confirm(){
    check_all_true();
    if(!check_all_true()){
        alert('입력하신 정보에 잘못된 정보가 있습니다. 정확한 정보를 입력 해주세요');
        return;
    }
    combine_values();
    const registerForm = document.forms.namedItem("register_form");
    registerForm.action = '/users/register';
    registerForm.method = 'post';
    registerForm.submit();
}

//전화번호, 이메일의 value값을 합치는 작업
function combine_values(){
    const inputTelHidden = document.getElementById('register_hidden_tel');
    const inputEmailHidden = document.getElementById('register_hidden_email');

    const telSelectValue = registerSelectTel.value;
    const emailSelectValue = registerSelectEmail.value;

    inputTelHidden.value =  telSelectValue + registerTel.value;


    if(emailSelectValue === "") {
        inputEmailHidden.value = registerEmail.value;
    }
    else {
        inputEmailHidden.value = registerEmail.value + emailSelectValue;
    }
}
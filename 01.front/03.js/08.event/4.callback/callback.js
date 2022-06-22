// 콜백 함수 - 기본
// name : parameter(매개변수), argument(인자값), 매개변수 다 같은 말
function greeting(name){ //함수 정의, 선언부에 작성하는 것이 parameter
    // name = 'yoo'
    console.log(`hello  ${name}`);     // 템플릿 리터럴 방식
    // 그 다음코드
}
// 함수 호출부
greeting('yoo'); //인자값(arguments)

function processUserInput(name, callbackFn){ //callbackFn = 콜백 함수
    // callbackFn - greeting() 
    callbackFn(name);
}
processUserInput('Yoo',greeting)
// // 그 다음 코드

const buttonHandler = function(){
    console.log('버튼 이벤트 처리용 핸들러 함수');
}
const buttonHandler2 = () => console.log('버튼 이벤트 처리용 핸들러 함수');
console.log(buttonHandler2);//변수에 들어있는 값이 함수일 경우, 변수명 뒤에 ()를 추가하여 호출 가능
buttonHandler(); 

//예제
// 쿠팡에서 물건이 도착하면 옆집 아주머니에게 전달
function waitCoupang(pkg, callback){
    console.log(`쿠팡에서 ${pkg}가 도착했다.`);
    callback();
}
function bringItToNeighnbor(){
    // 아주머니가 아직 퇴근을 안 하셔서 기다리는 중....
    console.log('옆집 아주머니에게 전달 완료!')
}
waitCoupang('사과',bringItToNeighnbor);

    document.querySelector('button').addEventListener('click',() =>{
        console.log('button clicked'); // 버튼보다 렌더링 되어서 실행 안됨 js파일 가져오는 부분에 defer 넣기
});


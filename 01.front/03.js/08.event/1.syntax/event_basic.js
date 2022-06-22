// 2. EventHandler property 방식 - HTML 과 JS를 분리

//프로그래밍 언어
// 코드지만, 한편으론 문장(가독성)
const evPropButton = document.getElementById('btn-ev-prop');
// const evPropButton = document.querySelector("#btn-ev-prop");
console.log(evPropButton); //[object HTMLButtonElement] 출력 


//JS에서 함수는 일급객체이기 때문에 객체는 값이고, 값은 프로퍼티에 할당할 수 있음
evPropButton.onclick = function(){// 익명함수 생성 및 할당
    console.log('called by event property');
}
// console.log(evPropButton+ "------");

//하나의 이벤트 밖에 등록 불가 (화살표 함수 활용)
//'새롭게 등록된 이벤트 핸들러' 출력되는 이벤트 핸들러 함수 작성 및 할당해보기
evPropButton.onclick = () => 
    console.log('새롭게 등록된 이벤트 핸들러'); //single line 한줄은 중괄호 필요없






//  3. addEventListener - 
//     EventHandler property(여기서는 onclick이라는 property)에 영향을 미치지 않음 

// on 접두사 생략
const addEvLsnrButton = document.getElementById('btn-add-ev-lsnr');
// btn-add-ev-lsnr
console.log(addEvLsnrButton);

// 함수 선언문 방식으로 이벤트 핸들러 작성
function buttonHandler(){
    console.log('double clicked!');
}


//addEventListener() 메서드의 인자값으로 함수를 넘김
// 그떄 인자값으로 넘겨진 함수를 Callback fucntion(함수)
// -> 어떤 함수의 인자값으로 함수를 넘겼을 때 넘겨진 함수를 콜백함수
addEvLsnrButton.addEventListener('dblclick',buttonHandler);


//화살표 함수로 buttonHandler2라는 이름의 함수 작성
//mouseover 출력되도록

//마우스를 버튼 위로 이동시켰을 때 발생하는 이벤트

buttonHandler2 = () => console.log("MouseOver!");
addEvLsnrButton.addEventListener('mouseover',buttonHandler2);

// click 이벤트 화살표 함수를 콜백함수 파라미터 자리에 직접 작성
// by addEventListener with arrow function 출력되도록

addEvLsnrButton.addEventListener('click',() =>{
    console.log('by addEventListener with arrow function');
});

// 이벤트 핸들러 제거
// 1. EventHandler attribute 방식 :onclick attribute 코드 제거

//2. 해당 property에 null 값 할당
// evPropButton.onclick = null; // 여기 안 지우면 2번 실행 안 됨

// 3. addEventListener method 방식 : 별도의 이벤트 제거 함수 호출
// addEvLsnrButton.removeEventListener('dblclick',buttonHandler);
// addEvLsnrButton.removeEventListener('mouseover',buttonHandler2);

// click 이벤트 제거
// -> 익명함수(화살표함수)라서 제거 안 됨 . 익명함수(화살표 함수)는 제가 불가




//js와 java는 camelCase사용

const book = {id : 1, author : '헤밍웨이',title : '노인과바다'};
 //책이라는 object 생성
//property로는 id, author, title
//id는 1
//author는 헤밍웨이
//title은 노인과 바다
console.log(book);
// book.id --> 1 출력
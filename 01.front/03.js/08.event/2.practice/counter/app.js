//web API인 DOM 활용
const countValue = document.getElementById('value');
// console.log(countValue); //count의 값을 담는 변수

// countValue.textContent =50 ; //값을 새로 할당
// console.log(countValue.textContent);

let countButtons = document.getElementsByClassName('btn');
// console.log(countButtons); HTMLCollection, 유사배열 / 배열처럼 동작하지만 배열은 아님
// console.log(Array.isArray(countButtons));  //HTMLCollection 유사배열 배열처럼 동작하지만 배열은 아님

// // 배열타입으로 변환(casting)
countButtons = Array.from(countButtons);

// 코드 실행 순서
//  countButtons -> Array.from -< console.log
// console.log(Array.isArray(countButtons));
// const isTrue = console.log(Array.isArray(countButtons));
// console.log(isTrue); //is it True? "true"

// console.log(countButtons);

// 이렇게 함수 호출할 수 있지만 중복최소화
// const [decreaseButton, resetButton, increaseButton] = countButtons;
// decreaseButton.addEventListener('click',()=>{});
// resetButton.addEventListener('click',()=>{});
// increaseButton.addEventListener('click',()=>{});

console.log(typeof countButtons[0]);

// function myFunc() {};
// countButtons.forEach(myFunc); //인자값을 넣은게 함수냐 아니냐만 판단

// 화살표 함수를 forEachh() (함수라는 말 생략가능) 의 인자값으로 전달함
// 그 떄 전달된 화살표 함수를 콜백 함수 (callback function)라고 함
//element는 누구의 인자값? ==> 전달된 콜백함수(화살표 함수)의 인자값이다.

//중복 최소화를 위해 forEach사용
// count값, count값에 따른 폰트 색 변경 값 저장용 변수
let count = 0;
let countValueColor = '';

// forEach(): Array 객체(클래스)가 제공하는 메서드 , 함수를 인자값으로 넘길 수 있음
// https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/forEach

// forEach()의 인자값으로 화살표 함수를 전달했고, 화살표 함수의 인자값으로 button 변수를 전달했음
countButtons.forEach((button) => {// Array.prototype.forEach //forEach 뭔지알기
    // console.log(button); //button 객체
    // https://developer.mozilla.org/en-US/docs/Web/API/EventTarget/addEventListener
    
    
    // addEventListener에 등록된 콜백함수(화살표 함수 형태)를 이벤트 핸들러라고 함
    //이벤트 핸들러란? 사용자가 click 이벤트를 발생시켰을 떄 그 처리를 담당할 담당자(이벤트 핸들러)
    //각 button에 click event 추가
    button.addEventListener('click',(event) =>{
    
        // console.log(event); //화살표 함수의 첫 번째 인자값으로 이벤트와 관련된 다양한 정보를 가지고 있는 객체 e라고 써도 상관없음
        const curTarget = event.currentTarget; //이벤트 핸들러에 바인딩된 DOM 객체
        //console.log(evenet.currantTarget); // 버튼 누르면 해당 버튼에 대한 정보 알려줌
        
        // htmle element에 작성한 class의 이름을 가져오기 위한 프로퍼티
        const styles = curTarget.classList[1]; //html에서 버튼에 클래스 이름 두 개 중 뒤에 클래스 이름 사용

        // Uncaught TypeError: Cannot read properties of undefined (reading 'classList')
        // of : '~의' properties of undefined : undefined의 properties -> undefined.classList[1];

        // object.property
        // book.id, book.title -> 여기서 객체는 book, property는 id, title
        // undefined.id
        
        // if(styles === 'decrease') {
        //     --count;
        // }
        // else{
        //     ++count;
        // }   

        // Ternay operator
        // count = (styles === 'decrease') ? --count : ++count;
        // console.log(count);

        count = styles !== 'reset'? (count = styles === 'decrease' ? --count : ++count) : 0;
        // console.log(count); // 숫자나옴
        
        // count의 값이 0이면 grey, 양수면 grean, 음수면 red
        countValueColor = count !== 0 ? (countValueColor = count > 0 ? 'green': 'red') : 'grey';
        // console.log(countValueColor); //색 나옴

        // 변경할 값(count값, count값의 색)을 실제 화면에 적용하는 부분
        countValue.textContent = count;
        countValue.style.color = countValueColor;
        // addEventLustener() 끝
    });
    // forEach()끝
});


// 배열에 객체가 들어갈 수 있음
// const myArr = [1,2,3,4,'ff',{id = 1, title : '노인과 바다'}];
// console.log(myArr);
fruits = ['apple','banana','kiwi'];
fruits.forEach((fruit)=>{
    console.log(fruit);
});

// https://hianna.tistory.com/483 -- innerText vs innerHTML vs TextContent 차이점
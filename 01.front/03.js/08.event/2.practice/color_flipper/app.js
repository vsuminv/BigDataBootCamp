const btn = document.getElementById('btn'); //이 부분도 api라고 할 수 있음
console.log(btn);

const color = document.querySelector('.color');
console.dir(color);

// 버튼 한 번 클릭했을 때 'button clicked!'
// addEventListener 활용, 화살표 함수를 콜백함수로 직접 작성
btn.addEventListener ('click', () => {
    console.log('button clicked!!');
   

    //랜덤 뽑는 법
    // const randomNumber = Math.floor(Math.random() * (255 -0 + 1)) + 0;

    //0~255로 추출
   //  const randomRGBArray = getRandomNumber(0,255);
    // cgetRandomNumber(); //--> 이렇게 쓰면 값이 없기 때문에 안 나옴(NaN임)
   //  console.log(randomRGBArray); //랜덤 값 출력

    // 이렇게 해도 되지만 간결하지 않음 
    // const r = randomRGBArray[0];
    // const g = randomRGBArray[1];
    // const b = randomRGBArray[2];



    // 템플릿 리터럴(backtick ``)
    //실제 값 바인딩, 매핑
   //  const [r,g,b] = randomRGBArray; // 위에 배열 지정 안하고 한 번에 쓰는 법
    // 가독성 높이기 위해 코드 간소화
    const [r,g,b] = getRandomNumber(0,255); //destructuring //const [r,g,b] = randomRGBArray;랑 똑같음
    console.log([r,g,b]);
    // const [r,g,b] = randomRGBArray; 이거 말고 const [r,g,b] = getRandomNumber(0,255) 출력하면 화면창과 콘솔창에 랜덤값이 다름
    // https://developer.mozilla.org/ko/docs/Web/JavaScript/Reference/Operators/Destructuring_assignment
    
    // color.textContent = `rgba(${r},${g},${b})`;
    // color.style.color = `rgba(${r},${g},${b})`;
   
    // 코드 간소화 문자를 변수에 저장
    const rgbColor = `rgba(${r},${g},${b})`;
    color.textContent=rgbColor;  //text 값만 변경
    color.style.color=rgbColor; //text의 색만 변경

    //배경색 바꾸기
    document.body.style.backgroundColor=rgbColor;
    // document.querySelector('body').style.backgroundColor = rgbColor;

    // color.textContent = 'rgba('+`${r},${g},${b}`+')'; 위에랑 같은 출력
    // color.textContent = 'rgba('+ r +','+g + ',' + b + ')'; 같은 의미
    // color.textContent = "("+ randomRGBArray + ")";
    console.log(typeof `${r},${g},${b}`); /**타입체크 */

    // console.dir(color);

    

});

//rgb 랜덤값 추출 함수
function getRandomNumber(min, max){
     //  rgb 랜덤값 추출
     let randomRGBArray = [];
     // console.log(typeof randomRGBArray);
     console.log(Array.isArray(randomRGBArray)); //배열인지 확인하는 거 Array.isArray()
     
     //rgb 랜덤값 추출
     for (let i = 0; i < 3; i++){
        //  const randomNumber = Math.floor(Math.random() * (max - min + 1)) + min; 
        const randomNumber = Math.floor(Math.random() * (max-min  + 1)) + min; 
        randomRGBArray.push(randomNumber);
     }
        return randomRGBArray;
}

// const randomNumber = Math.floor(Math.random() * (max - min + 1)) + min; 
// const randomNumber = Math.floor(Math.random() * (max - min + 1)) + min; 
// const randomNumber = (Math.random() * max + 1) + 1;


// 변수 사용이 이유 값을 보관하고 재사용 하기 위함

/**
 * 1 ~ 3 포함의 랜덤값을 얻고 싶다고 할 때,
 * max -min이면 1,3일경우 2인데,
 * Math.random()의 값은 항상 1보다 작은(0 ~0.999)
 * 2 * 0.999는 1.8XX로 1이상의 값이 나올 수 없음
 * 따라서 +1을 하면 3이 되어 3 * 0.999 = 2.7xxx
 * 아직도 랜덤값이 3이 나올 순 없음
 * 
 * +min을 한 번 더 해야함
 * 정수값으로 변환된 값에 얻고자 하는 랜덤값 중의 최대값(여기서는 3)을 얻어야함
 * 
 * 3 ~ 5 포함의 랜덤값을 얻고 싶을 경우 (최소값이 1이 아닐 때)
 * max - min= 2
 */

 
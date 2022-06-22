// 변수 네이밍 컨벤션, 도메인과 관련된 용어를 정의
// source : 번역할 텍스트와 관련된 명칭
// target : 번역된 결과와 관련된 명칭
const [sourceTextArea, targetTextArea] = document.getElementsByTagName('textarea');
// console.log(sourceTextArea, targetTextArea);

//selecbox에서 값이 변경되었을 때 발생하는 이벤트
const [sourceSelect, targetSelect] = document.getElementsByTagName('select');
// console.log(sourceSelect, targetSelect);

// 번역할 언어의 기본 타입(en)
// 언어를 안 바꿨을 때 기본 번역 언어
let targetLanguage = 'en';

// 어떤 언어로 번역할 지 선택하는 target selectbox의 option(선택지)의 값이 바뀔 때마다 이벤트가 발생.
targetSelect.addEventListener('change', () => {
    // console.dir(targetSelect);
    const selectedIndex = targetSelect.selectedIndex;
    targetLanguage = targetSelect.options[selectedIndex].value;
    // console.log(targetLanguage) // select에서 언어 바꿀 시 값 출력
    console.log(targetSelect.options[1]);
});

let debouncer; // debouncer 변수 선언
sourceTextArea.addEventListener('input', (event) => {
    
    // ㅇ(타이머 카운트 시작..0..1)ㅏㄴ(타이머 카운트 초기화, 다시시작 0..1..2) 녕(타이머 카운트 다시 초기화)
    if(debouncer) { // debouncer에 TimerID값이 있으면(카운팅 하고 있다는 의미)
        clearTimeout(debouncer);// 현재 타이머 카운트 초기화
    }
    
     // 동작 시작 : 2초 뒤 객체를 만들고 요청을 시작
    debouncer = setTimeout(() => {
        const text = event.target.value;
        console.log(text);

         // targetTextArea.textContent=souceTextArea.value 왼쪽에 입력하면 오른쪽에 그대로  출력
    

        if(text) { // text 변수에 값이 있을 경우 true, ''(공백)일 경우 false
            // 비동기 요청을 도와주는 Web API 객체 생성
            const xhr = new XMLHttpRequest();

            // node 서버의 특정 url 주소
            const url = '/detectLangs';

            xhr.onreadystatechange = () => {
                if(xhr.readyState === 4 && xhr.status === 200) {
                    // console.log(typeof xhr.responseText, xhr.responseText);
                    console.log(JSON.parse(xhr.responseText)); 
                    const responseData = JSON.parse(xhr.responseText);
                    console.log(responseData.message)

                    // result라는 변수에 result프로퍼티를 담으려고 함
                    const result = responseData['message']['result'];

                    // 번역된 텍스트를 결과 화면에 입력
                    targetTextArea.value = result['translatedText'];
                }
            };

            // 요청 준비
            xhr.open('POST', url);

            // Node 서버에 보낼 객체 형태의 JSON 데이터
            const requestData = { // typeof : object
                text,  // 프로퍼티랑 변수랑 이름 똑같으면 하나만 적으면 됨 text:text 일때
                targetLanguage,
            };

            // 타입이 json인 걸 알려줘야함. send하기 전에 작성
            xhr.setRequestHeader('Content-type', 'application/json');

            // JSON의 타입은 ? string
            const objectToJSON = JSON.stringify(requestData);

            // 요청 전송
            xhr.send(objectToJSON);
        }
    }, 2000); // 2초 후에 콜백함수 호출.
    
});



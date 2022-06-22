// const book = {
//     id : 1,
//     name : "노인과 바다",
//     checkStook : function(){
//         console.log('재고 없어!')
//     }
// }
// console.log(book.checkStook)
// console.log(book.checkStook()); //반환하는 게 없기떄문에 undefined

// const checkBookStock = () => console.log('재고 없다고!')

// console.log(checkBookStock()); //반환하는 게 없기떄문에 undefined

// checkStock 프로퍼티

// checkBookStock()

/**
 * 1. checkStock프로퍼티가 메서드이고, checkBookStock()은 함수이다.
*/

// XMLHttpRequest 객체의 프로퍼티와 메서트
const xhr = new XMLHttpRequest();
// const button = document.getElementById('btn');
// const txt = document.getElementById('text');
// console.log(text);
// 요청을 보낼 준비
xhr.open('GET','https://jsonplaceholder.typicode.com/users');  // CRUC(create, Read, Update, Delete)
// "GET" : 서버의 데이터를 조회하고 싶을 떄
// console.log(xhr.readyState); //1출력
console.log(`OPENED,${xhr.readyState}`);//OPENED, 1 출력



// // readyState 프로퍼티의 값이 변경될 떄마다 arrow fn 호출
xhr.onreadystatechange = () => {
    if(xhr.readyState == 2){
        console.log(`HEADERS_RECEIVED  ${xhr.readyState}`);
    }

    // 데이터 응답(로딩) 완료와 같은 == onload
    if(xhr.readyState == 4 && xhr.status == 200){
        console.log(`DONE, ${xhr.readyState}`); 
        console.log(`respose data ${xhr.responseText}`); //서버로부터 데이터가 날아옴

        //객체인지 확인
        const responseData = xhr.responseText;

        console.log(responseData.id); //console창에 있는 객체 프로퍼티에 접근. undefined
        console.log(typeof responseData); //string
        console.log(responseData[10]); //데이터 인덱싱 ""출력됨
        //객체로 출력
        const parseData = JSON.parse(responseData);
        console.log(parseData) //배열로 출력
    }
};


// xhr.onreadystatechange = () => {
//     // if(xhr.readyState == 2)
//     //     console.log(`HEADERS_RECEIVED  ${xhr.readyState}`);
//     // }

//     // 데이터 응답(로딩) 완료와 같은 == onload
//     button.addEventListener('click',()=>{

//         if(xhr.readyState == 4 && xhr.status == 200){
//             console.log(`DONE, ${xhr.readyState}`); 
//             htmltxt = txt.textContent =  xhr.responseText;
//             htxt = JSON.parse(htmltxt);
           
            
//         }
//     });
// }



// 브라우저가 데이터를 받는 동안 주기적으로 발생
xhr.onprogress = () =>console.log(`LOADING, ${xhr.readyState}`);

// 데이터 응답(로딩)이 완료된 경우
xhr.onload = () => console.log(`DONE, ${xhr.readyState}`); 

xhr.send();




// 1. readyState: HTTP 요청의 현재 상태를 가지고 있는 정수값.

// 0(UNSENT) - 초기화 전. open() 호출하기 전
// 1(OPENED) - 열림. open()를 호출했고, send()는 호출하지 않은 상태
// 2(HEADERS_RESCEIVED) - 보냄, send()를 호출했지만 서버로부터 응답은 받지 못한 상태
// 3(LOADING) - 데이터 수신 중. 응답 데이터의 일부를 받고 있는 상태
// (DONE) - 완료. 응답 데이터를 모두 받은 상태.

// 2. status :HTTP 요청에 대한 응답의 성공 여부를 나타낸 상태
// 200(응답 성공), 404(요청 실패, 잘못된 경로)

// 3. statusText : HTTP 요청에 대한 응답 메세지를 나타내는 문자열
// ex) status가 200일 경우, "OK"

// 4. responseType : 응답한 데이터의 타입
// ex) document, json,text,blob

// 5. response : HTTP 요청에 대한 응답 몸체(body)

// 이벤트 핸들러와 관련된 프로퍼티
// onreadystatechange : readyState 프로퍼티의 값이 변경된 경우

// 메서드
// 1. open() : HTTP 요청의 초기화(준비단계)
// 2. send() : HTTP 요청 실제 전송

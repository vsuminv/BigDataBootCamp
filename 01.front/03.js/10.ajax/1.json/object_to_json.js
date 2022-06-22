/**
 * JSON : 클라이언트와 서버 간 HTTP 통신을 위한 텍스트(string) 데이터 포멧 방식
 * JavaScript에 종속되지 않은 독립적인 포멧
 * 대부분의 프로그래밍 언어에서 사용가능
 */

// JSON 작성 방식 : JavaScript의 객체 작성 방식과 유사

// Javascript Object
const book = {
    title : '노인과바다',
    author : '헤밍웨이',
    isSold : false, //팔렸는지 물어보는 거
    genre : ["소설","비극"],
};

// JSON, key(property) 값을 ""로 작성. ''는 작성불가
// js문법이 아니라 오류남
// {
//     "title" : "노인과바다,
//     "author" : "헤밍웨이",
//     "isSold" : false, //팔렸는지 물어보는 거
//     "genere" : ["소설","비극"],
// }

const jsonData = JSON.stringify(book);
console.log(typeof jsonData);
console.log(jsonData); //프로퍼티 값들도 문자열로 바뀌어 있음. 
console.log(book);

console.log(jsonData.title); //문자열 타입이기 떄문에 프로퍼티 참조 불가. 서버에 보낼 포멧팅으로 되어 있어 인덱싱 불가능
console.log(book.title); //객체이기 떄문에 프로퍼티값 참조 가능

// /**
//  * JSON.stringify()는 Client 측에서 서버로 데이터(일반적으로 객체)를 전송하기 위해 객체를 문자열화해야함
//  * 문자열화를 직렬화(Serialiazation)이라고 함
//  * 배열도 직렬화 가능
//  */

// 배열 직렬화
const books = [
    { id : 1, title : "하농", author:'하농', isSold:false },
    { id : 3, title : "체르니", author:'체르니', isSold:false },
    { id : 1, title : "부르크뮐러", author:'부르크뮐러', isSold:false },
];

// 배열을 JSON 포맷의 문자열로 변환
const jsonBooks = JSON.stringify(books);
console.log(typeof jsonBooks, jsonBooks);



// // 회원에 대한 id값을 담고 있는 배열
// const idArr = ['youj','koo','foo'];
// const pwAddr = ['qted','agsdg','sgsdg'];
// // 하나씩 할 수 없어 객체를 가져와서 쓰는 것임
const book = {
    title : '노인과바다',
    author : '헤밍웨이',
    isSold : false, 
    genre : ["소설","비극"],
};

// 서버에서 응답한 데이터라고 가정
const responseData = JSON.stringify(book);
console.log(responseData);

//parsing
// JSON 포맷의 문자열을 객체로 변환 
const responseParsing = JSON.parse(responseData);
console.log(responseParsing.title);
console.log(responseParsing.author);
console.log(responseParsing.isSold);
console.log(responseParsing.genre);




const books = [
    { id : 1, title : "하농", author:'하농', isSold:false },
    { id : 3, title : "체르니", author:'체르니', isSold:false },
    { id : 1, title : "부르크뮐러", author:'부르크뮐러', isSold:false },
];


// 서버로 응답한 데이터라고 가정
const reseponseData2 = JSON.stringify(books);
console.log(reseponseData2);

// JSON 포멧의 문자열을 배열로 변환(역직렬화, deserialization)
const parsedData = JSON.parse(reseponseData2);
// pasedData : 파싱처리가 완료된 데이터

console.log(typeof parsedData,parsedData);
console.log(parsedData[0]);


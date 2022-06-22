
// require: express, requset, dotenv 설치한 모듈을 server에서 쓰기위해 import함
const express = require('express'); //express 패키지 import

const app = express();// express 객체 생성 

// API key를 별도로 관리 dot(.)env 활용, .env라는 파일에 key를 보관하고 dotevt가 .env파일을 활용해서 process.env 객체에 포함시켜줌
const dotenv = require('dotenv');
dotenv.config(); //설정하기 위한 내용



const clientId = process.env.CLIENT_ID
const clientSecret = process.env.CLIENT_SECRET

const request = require('request'); // request 패키지 import

// express의 static 미들웨어 활용. => use라는 메소드
// express에게 static(정적인 파일) 관련 자원은 public 폴더 내에 있음을 명시.
app.use(express.static('public'));

// express의 json 미들웨어 활용.
//server에서 파싱을 해줘야함 안 그럼 unifined나옴
// //express에게 json 파싱을 위임. 자동으로 파싱해줌
app.use(express.json());

// localhost:3000/ -> 요청을 받으면 해당 함수 호출
app.get('/', (request, response) => {
    // console.log(__dirname);
    response.sendFile(__dirname, 'index.html');
});

// 브라우저로부터 감지할 언어의 텍스트를 받아서, Naver 서버로 전송(요청) 및 결과 응답
app.post('/detectLangs', (req, res) => {

   // 127.0.0.1:3000/detectLangs로 요청했을 때
    // console.log('요청 성공');

     //script에서 requsetData에 text, targetLanguege를 가져옴
     // 브라우저에서 보낸 값이 들어있음
    console.log(typeof req.body, req.body); //타입은 object //undifined가 나온다면 script.js에 xhr.setRequestHeader('Content-type','application/json'); 작성해야함
    const {text:query, targetLanguage} = req.body; //객체 리터럴
   //console.log(query, targetLanguage);
   
    // 사용할 값들을 받아서 네이버 서버에 요청    
   const url = 'https://openapi.naver.com/v1/papago/detectLangs';

    // 실제 주소와 네이버가 받고 싶은  데이터를 규칙으로 작성해서 보내줌
   const options = {
       url, // 언어감지 네이버 서버의 주소
       form: { query }, // query : query임 form이라는 프로퍼티에 우리가 보낼 데이터를 객체의 형태로 전송
       headers: {//객체 형태로 넣기
           "X-Naver-Client-Id": clientId,
           "X-Naver-Client-Secret": clientSecret,
       },
   };

// 실제 요청 보내는 곳 request. 아래 request는 package.json에서 설치했던 request임
// request.post('요청에 필요한 데이터 동봉', '요청에 따른 응답 정보를 확인하는 콜백함수');
// options에 요청에 필요한 데이터들을 보관
// () => {}: 요청에 따른 응답 정보 확인
// 아래 매개변수 body는 response의 body임
// 언어감지 요청 부분
    request.post(options, (error, response, body) => {
        if(!error && response.statusCode === 200) {
            const parsedBody = JSON.parse(body);
            // {langCode: 'en'}

            // papago 번역 url로 재요청(redirect), querystring활용
            res.redirect(`translate?lang=${parsedBody['langCode']}&targetLanguage=${targetLanguage}&query=${query}`);
            // localhost:3000/translate?lang=en&targetLanguage=ko&query=hi
        } else {
            console.log(`error = ${response.statusCode}`); //error = 에러코드(response.statusCode)  변수로 사용 => console.log(`error = ${response.statusCode}`);
        }
    });
});

// papago 번역 요청 부분.
app.get('/translate', (req, res) => {
    console.log('translate', req.query); //처음에 비어있는 상태 {} 이렇게 나옴

    // Papago 번역 url 작성
    const url = 'https://openapi.naver.com/v1/papago/n2mt';

    // 서버에 보낼 데이터 동봉
    const options = {
        url, // 요청 URL
        form: { // 요청 파라미터
            source: req.query['lang'],
            target: req.query['targetLanguage'],
            text: req.query['query'],
        },
        headers: { // Client ID와 Secret 값
           "X-Naver-Client-Id": clientId,
           "X-Naver-Client-Secret": clientSecret,
        }
    };

    
    // 요청 전송 및 응답 결과 확인
    request.post(options, (error, response, body) => {
        if(!error && response.statusCode === 200) {

             //script.js에 있는 xhr.responseText가 받는다
            // body 자체가 json인데 문자열을 또 문자열화했음
            // res.json(body); //res.json() : stringify()가 적용된 메서드

            // 위에 코드를 안 쓰고 아래 코드 사용
            res.setHeader('Content-Type', 'application/json'); //브라우저로 넘길 때 보내는 데이터는 json이라는 것을 알려줌
            res.send(body);
            
        } else {
            console.log(`error = ${response.statusCode}`);
        }
    });
});

app.listen(3000, () => {
    console.log('http://127.0.0.1:3000/ app listening on port 3000!');
});

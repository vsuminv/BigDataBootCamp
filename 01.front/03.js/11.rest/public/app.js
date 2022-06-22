const getButton = document.getElementById('get-btn');
const postButton = document.getElementById('post-btn');

// console.log(getButton);

// const pEl = document.getElementsByTagName('p');
// console.log(pEl);

// pEl[0].addEventListener('click',() => console.log('bottun click'));

const [id, realName] = document.getElementsByTagName('p');
console.log(id);
console.log(realName);




// const a =new XMLHttpRequest();
// const b =new XMLHttpRequest();
// console.log(a == b); //false

// XMLHttpRequest 객체(인스턴스) 생성

// 요청을 보낼 준비

// 데이터 로딩(응답)이 완료되었을 때
// 로딩이 다 되었다. onreadystatechange 대신 써도됨



getButton.addEventListener('click',() =>{
    const xhr = new XMLHttpRequest();
    xhr.open('GET','/users');
    
    
    
    xhr.onload = () => {
        if(xhr.status === 200){
            const responseData = JSON.parse(xhr.response);
            console.log(responseData);
            
            id.textContent = responseData[1].id; //xrphttp2 내가 안 나온 부분 참고 프로퍼티 접근
            realName.textContent = responseData[1].name;

            // const firstData = responseData[0];
            // id.textContent = firstData.id;
            // realName.textContent = firstData.name;
            
        }   
    };
    xhr.send();
});

// 등록
// postButton.addEventListener('이벤트 타입','이벤트 핸들러 콜백함수')

postButton.addEventListener('click',() =>{
    // XMLHttpRequest 객체 생성
    const xhr = new XMLHttpRequest();
    
    // HTTP 요청 준비
    xhr.open('Post','/users');
    
    xhr.setRequestHeader('Content-type','application/json');

    // HTTP요청 상태 확인
    xhr.onload = () =>{
        if(xhr.status === 200 || xhr.status === 201){
            console.log(xhr.response);
        }
    };

    // Javascript Object
    const newUser = {
        id : 11,
        name : 'Lee',
        username : 'leesumin',
        company: {
            id : 'c1',
            name : 'playdata'
        }
    }; 
    
    const toJson = JSON.stringify(newUser);
    
    // HTTP 요청 전송
    xhr.send(toJson);
});



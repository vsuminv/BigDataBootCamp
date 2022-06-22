/**
 * promise가 fullfilled(응답 성공) 상태면 promise의 처리 결과(응답된 데이터)를 가지고 무언가 처리를 진행하고,
 * promise가 rejected 상태가 되면 처리 결과(에러)를 가지고 에러처리를 해야함
 * 
 * 이러한 처리를 위해 사용하는 메서드
 * promise 객체가 보유하고 있는 메서드
 * then(), catch(), finally
 * 
 * 이러한 '후속 처리 메서드'들은 다시 promise를 반환함
 */

// fulfilled

// then()은 2개의 콜백 함수를 인자로 전달 받음
// 첫 번째 인수(콜백함수) : promise가 fullfied상태(즉, resolve()가 호출된 상태)가 되면 호출됨
// 두 번재 인수(콟백함수) : promise가 rejected상태(rejected()가 호출된 상태)가 되면 호출됨
new Promise(resolve => resolve ('서버로부터 응답된 데이터'))
.then(result => console.log(result), error => console.log(error));
// 응답에 성공하면 then()


// rejected
// _ 앞에는 아무것도 없다는 의미
new Promise((_,reject) => reject('응답 실패'))
.catch(error => console.log(error));
// 응답에 실패하면 catch()



const getRequestWithPromise = (url) =>{
    // promise 객체 반환
    return new Promise((resolve, reject) =>{
        const xhr = new XMLHttpRequest();
        xhr.open('GET',url);

        xhr.onload = () =>{
            if (xhr.status === 200){
                // 응답이 성공했을 떄
                resolve(JSON.parse(xhr.response));
            }else{
                // 에러처리
                reject(xhr.status);
            }
        }
        xhr.send();
    });
};

getRequestWithPromise('https://jsonplaceholder.typicode.com/posts/1')
.then(result => console.log(result)) //then()는 promise 객체를 반환
.catch(error => log(error))//catch()는 promise 객체를 반환
.finally(() => console.log('요청 종료'));
// finallly()는 무조건 실행
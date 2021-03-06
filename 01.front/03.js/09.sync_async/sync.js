// 기능을 수행할 때 로딩되면서 페이지가 바뀌는 경우는  동기
//1.  함수가 호출된 순서대로 순차적으로 실행 - 동기(Synchronous)
const firstFunc = () => console.log('첫 번쨰 함수 호출됨'); //함수 표현식, 한줄은 블록 생략가능

const someLongTasks = () => {
    console.log('--------------');
    console.log('특정 작업(task) 처리중.. 시간이 오래 소요됨.');
    console.log('--------------');
};

const secondFunc = () =>{
    console.log('두 번째 함수 호출됨');
}

firstFunc();
someLongTasks();
secondFunc();
// 현재 시간을 숫자로(ms)로 반환하는 메서드
// console.log(Data.now*())

// 일정한 작업 시간이 경과한 이후에 함수가 호출(실행)되도록 시간을 지연시켜주는 sleep()작성

 
 
// console.log(Date.now());

function sleep(callbackFunc, delay){
    console.log('다른 작업을 처리하느라 시간 지연중..');
    const delayedTime = Date.now() + delay;

    while(Date.now() < delayedTime);
    
    callbackFunc();
}
function firstWork(){
    console.log('첫 번째 작업 수행');
}

function SecondWork(){
    console.log('첫 번째 작업 수행');
}

// 첫 번쨰 작업(firstWork())이  3(3*1000)초동안 블로킹 시키고 싶음

sleep(firstWork, 3 *1000); //fristWork 수행
// SecondWork(); //first,secondWork 둘 다 수행

/***
 * 현재 실행 중인 작업(task)이 종료할 때가지 다음에 실행될 작업이 대기하는 방식을 동기(Synchronous)처리라고함
 * 
 * 동기 처리 방식은 작업을 순서대로 하나씩 처리(순차적으로)하기 때문에
 * 장점 : 실행 순서가 보장됨.
 * 단점 : 앞선 작업이 종료할 때까지 이후의 작업들이 블로킹(blocking)이 되는 단점
 */
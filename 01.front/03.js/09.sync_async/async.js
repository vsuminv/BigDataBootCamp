// 비동기 방식 (Asynchronous)\

/**
 * 현재 실행 중인 작업(task)이 아직 끝나지 않은 상태라고도 하고 다음 작업을 곧 바로 실행하는 방식**/

 function firstWork(){
    console.log('첫 번째 작업 수행');
}

function SecondWork(){
    console.log('두 번째 작업 수행');
}

// 비동기 처리를 수행하주는 몇 가지 함수를 활용
// 타이머 함수(Timer), setTimeout()의 특징 중 하나는 블로킹(작업 중단)을 하지않고 비동기적을 처리

setTimeout(firstWork, 3 * 1000); //지정한 3 * 1000이후에 콜백함수 firstWork() 호출
SecondWork();

/**
 * 비동기 처리 방식은 현재 실행 중인 작업 (task)이 종료되지 않은 상태라고 해도.
 * 다음 작업(task)를 곧바로 수행하기 떄문에 블로킹이 발생하지 않음.(장점)
 * 단점 : 작업(task)의 실행 순서가 보장되지 않음
 * 
 * 비동기 처리 방식으로 동작하는 함수들 : setTimeout(), setInterver(), HTTP 요청 , 이벤트 핸들러
 */


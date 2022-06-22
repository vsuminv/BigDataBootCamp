
const xhr = new XMLHttpRequest();
let idn = document.getElementsByClassName('id1');
let title = document.getElementsByClassName('title');

idn = Array.from(idn);
xhr.open('GET', 'https://jsonplaceholder.typicode.com/users/1');
xhr.onreadystatechange = () =>{
    // 데이터 응답 완료와 같음 == onload
    if(xhr.readyState == 4 && xhr.status ==200 ){
        console.log(`response data:${xhr.responseText}`);
        const parsing = JSON.parse(xhr.responseText);
        console.log(parsing);
        let arr1= new Array();
        let arr2= new Array();
        let i = 0;
        for (var obj in parsing) {
            arr1[i] = parsing[obj];
            title.innerHTML = parsing;
            
            i++;
        }
        console.log(arr1);
        let j = 0
        idn.forEach(element => {
            console.log(element);
            element.innerHTML = arr1[j];
            j++;
        });
    }
}
xhr.send();
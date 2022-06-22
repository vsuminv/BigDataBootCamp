const xhr = new XMLHttpRequest();
const button = document.getElementById('btn');
const txt = document.getElementById('text');

// 요청을 보낼 준비
xhr.open('GET','https://jsonplaceholder.typicode.com/users');  // CRUC(create, Read, Update, Delete)
// "GET" : 서버의 데이터를 조회하고 싶을 떄
// console.log(xhr.readyState); //1출력
console.log(`OPENED,${xhr.readyState}`);//OPENED, 1 출력



// xhr.onreadystatechange = () => {
//     // if(xhr.readyState == 2)
//     //     console.log(`HEADERS_RECEIVED  ${xhr.readyState}`);
//     // }s
    
//     // 데이터 응답(로딩) 완료와 같은 == onload
//     button.addEventListener('click',()=>{
//         if(xhr.readyState == 4 && xhr.status == 200){
//             console.log(`DONE, ${xhr.readyState}`); 
//             console.log(xhr.responseText);

//             const responseData = xhr.responseText;
//             const parseData = JSON.parse(responseData);
//             console.log(parseData)
            
//             // const htmltxt = JSON.parse(txt1);
//             // txt.textContent = htmltxt
//             // txt.textContent = htmltxt[1][2];
//             // for (let i = 0; i< htmltxt.length; i++) {
//             //     const element = htmltxt[i];
//             //     txt.textContent = element;
                
//             // }
            
           
            
//         }
//     });
// }



xhr.onreadystatechange = () => {
    // if(xhr.readyState == 2)
    //     console.log(`HEADERS_RECEIVED  ${xhr.readyState}`);
    // }s
    
    // 데이터 응답(로딩) 완료와 같은 == onload
    button.addEventListener('click',()=>{
        if(xhr.readyState == 4 && xhr.status == 200){
            console.log(`DONE, ${xhr.readyState}`); 
            console.log(xhr.responseText);

            const responseData = xhr.responseText;
            // const parseData = JSON.parse(responseData);
            // console.log(parseData)
            
            // const htmltxt = JSON.parse(txt1);
            // txt.textContent = htmltxt
            
            // for (let i = 0; i< responseData.length; i++) {
            //     const element = responseData[i];
            //     txt.textContent = element;
                
            // }
            
           
            
        }
    });
}



xhr.send();

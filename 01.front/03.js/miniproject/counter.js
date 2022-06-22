const decreasebtn = document.getElementById('decrease');
const resetbtn = document.getElementById('reset');
const increasebtn = document.getElementById('increase');
const resultnumber = document.getElementById('number');
let count = 0;

increasebtn.addEventListener('click',() =>{
    const cnumber = resultnumber.innerText;
    let count =  resultnumber.innerText = parseInt(cnumber) + 1;
    colorChange(count);
});

decreasebtn.addEventListener('click', () => {
    const cnumber = resultnumber.innerText;
    let count = resultnumber.innerText = parseInt(cnumber) - 1;
    colorChange(count);

});
resetbtn.addEventListener('click',() => {
    let count = resultnumber.innerText = 0;
    colorChange(count);


});

function colorChange(count){
    if (count > 0)
        resultnumber.style.color = 'blue';
    else if (count == 0 )
        resultnumber.style.color = 'lightgray';
    else   
        resultnumber.style.color = 'red';
    

}


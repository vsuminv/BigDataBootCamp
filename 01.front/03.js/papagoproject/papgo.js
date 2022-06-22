const leftText = document.getElementsByClassName('Section_input_left').value;
const rightText = document.getElementById('Section_input_right');

leftText.addEventListener('keyup',function(e){
    document.getElementById('Section_input_right').innerText =e.value;
});


// function printText() {
//     const text = document.getElementById('input').value;

//     document.getElementById('output').innerText = text.value;
// }

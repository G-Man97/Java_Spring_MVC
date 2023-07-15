let today = new Date();

let year = today.getFullYear();
let month = today.getMonth();
let day = today.getDay();

if(month < 10) {month = '0' + month;}
if(day < 10) {day = '0' + day;}

let max = (year - 18) + '-' + month + '-' + day;
let min = (year - 60) + '-' + month + '-' + day;

const fDate = document.querySelector('#fDate');
const sDate = document.querySelector('#sDate');

fDate.min = min;
fDate.max = max;

sDate.max = max;

function check() {
    if(fDate.value > sDate.value) {
        sDate.value = fDate.value;
        sDate.min = fDate.value;
    }
}
function showMessage() {
    if(fDate.value != '' && sDate.value != '') {
        alert('There is employee who was born in ' + fDate.value + ' - ' + sDate.value);
    }
}
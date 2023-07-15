let today = new Date();

let year = today.getFullYear();
let month = today.getMonth();
let day = today.getDay();

if(month < 10) {month = '0' + month;}
if(day < 10) {day = '0' + day;}

let max = (year - 18) + '-' + month + '-' + day;
let min = (year - 60) + '-' + month + '-' + day;

const birthday = document.querySelector('#birthday');

birthday.min = min;
birthday.max = max;
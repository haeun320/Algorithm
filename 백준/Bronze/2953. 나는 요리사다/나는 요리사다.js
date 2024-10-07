const fs = require('fs');
// TODO: 제출 시 경로 변환 필수 ("/dev/stdin")
const input = fs.readFileSync(0).toString().trim().split('\n');
// const input = fs.readFileSync('test.txt').toString().trim().split('\n');

const array = input.slice(0).map(item => item.split(' ').map(Number).reduce((a,b) => a+b, 0));
const max = Math.max(...array);
const num = array.indexOf(max) + 1;

console.log(num, max);
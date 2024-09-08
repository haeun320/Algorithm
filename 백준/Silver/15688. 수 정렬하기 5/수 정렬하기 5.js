const fs = require('fs');
// TODO: 제출 시 경로 변환 필수 ("/dev/stdin")
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
// const input = fs.readFileSync('test.txt').toString().trim().split('\n');

const N = Number(input[0]);
const array = [];
for (let i = 1; i <= N; i++){
  array.push(Number(input[i]));
}

console.log(array.sort((a,b)=>a-b).join('\n'));
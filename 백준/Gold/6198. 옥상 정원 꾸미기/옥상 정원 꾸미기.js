const fs = require('fs');
// TODO: 제출 시 경로 변환 필수 ("/dev/stdin")
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
// const input = fs.readFileSync('test.txt').toString().trim().split('\n');

const N = Number(input[0]);
const heights = input.slice(1).map(Number);

let stack = [];
let result = 0;  

for (let h of heights) {
  while (stack.length > 0 && stack[stack.length - 1] <= h) {
    stack.pop();
  }
  result += stack.length;
  stack.push(h);
}

console.log(result); 
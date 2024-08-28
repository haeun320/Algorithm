const fs = require('fs');
// TODO: 제출 시 경로 변환 필수 ("/dev/stdin")
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
// const input = fs.readFileSync('test.txt').toString().trim().split('\n');

// 정리
const str = input[0];
let idx = 0;
let stack = [];

while (idx < str.length){
  if (str[idx] === "("){
    stack.push(str[idx++]);
  }
  else {
    stack.push(str[idx++]);
    if (stack[stack.length-2] === "(") {
      stack.pop();
      stack.pop();
    }
  }
}

console.log(stack.length);
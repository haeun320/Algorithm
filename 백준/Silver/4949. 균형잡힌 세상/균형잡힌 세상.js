const fs = require('fs');
// TODO: 제출 시 경로 변환 필수 ("/dev/stdin")
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
// const input = fs.readFileSync('test.txt').toString().trim().split('\n');

// 정리
const N = input.length-1;
let array = [];
for (let i = 0; i < N; i++){
  array.push(input[i]);
}

// 풀이
function solution(N, array) {
  for (let i = 0; i < N; i++){
    let str = array[i];
    let stack = [];

    for (let j = 0; j < str.length; j++){
      if (str[j] === "(" || str[j] === "["){
        stack.push(str[j]);
      }
      else if (str[j] === ")") {
        stack.push(str[j]);
        stack[stack.length-2] === "(" && stack.pop() && stack.pop();
      }
      else if (str[j] === "]"){
        stack.push(str[j]);
        stack[stack.length-2] === "[" && stack.pop() && stack.pop();
      }
    }

    stack.length === 0 ? console.log("yes") : console.log("no");
  }
}

solution(N, array);
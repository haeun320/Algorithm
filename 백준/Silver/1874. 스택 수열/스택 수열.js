const fs = require('fs');
// TODO: 제출 시 경로 변환 필수 ("/dev/stdin")
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
// const input = fs.readFileSync('test.txt').toString().trim().split('\n');

// 정리
const N = Number(input[0]);
let array = [];
for (let i = 1; i <= N; i++){
  array.push(Number(input[i]));
}

// 풀이
function solution(N, array) {
  let stack = [1];
  let inputNum = 1;
  let arrayIdx = 0;
  let outputArray = ["+"];

  while (inputNum <= N){
    // console.log("stack:", stack, " inputNum:", inputNum, " arrayIdx:", arrayIdx);
    if (stack[stack.length-1] === array[arrayIdx]){
      stack.pop();
      if (arrayIdx++ === N) break;
      outputArray.push("-");
    }
    else {
      stack.push(++inputNum);
      outputArray.push("+");
    }
  }

  if (stack.length === 0) {
  outputArray.forEach(item => console.log(item));
  }
  else {
    console.log("NO");
  }
}

solution(N, array);
const fs = require('fs');
// TODO: 제출 시 경로 변환 필수 ("/dev/stdin")
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
// const input = fs.readFileSync('test.txt').toString().trim().split('\n');

const N = Number(input[0]);
const heights = input[1].split(' ').map(item => Number(item));

let result = [0];
let stack = [[heights[0], 1]];

for (let i = 1; i < N; i++){
  while(stack.length > 0 && stack[stack.length-1][0] < heights[i]){
    stack.pop();
  }

  if (stack.length === 0){
    result.push(0);
    stack.push([heights[i], i+1]);
    continue;
  }

  result.push(stack[stack.length-1][1]);

  stack.push([heights[i], i+1]);
}

console.log(result.join(' '));
const fs = require('fs');
// TODO: 제출 시 경로 변환 필수 ("/dev/stdin")
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
// const input = fs.readFileSync('test.txt').toString().trim().split('\n');

// 정리
const N = Number(input[0]);
let command = [];
for (let i = 1; i <= N; i++){
  command.push(input[i].split(' ').map(item => Number(item)));
}

let result = []
function commandProcess(command, stack){
  const len = stack.length;
  switch(command[0]) {
    case 1:
      stack.push(command[1]);
      break;
    case 2:
      result += (stack.length > 0 ? stack.pop() : -1) + '\n';
      break;
    case 3:
      result += stack.length + '\n';
      break;
    case 4:
      result += (stack.length === 0 ? 1 : 0) + '\n';
      break;
    case 5:
      result += (stack.length > 0 ? stack[stack.length - 1] : -1) + '\n';
      break;
  }
}

let stack = [];
for (let i = 0; i < N; i++){
  commandProcess(command[i], stack);
}

console.log(result);
const fs = require('fs');
// TODO: 제출 시 경로 변환 필수 ("/dev/stdin")
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
// const input = fs.readFileSync('test.txt').toString().trim().split('\n');

// 정리
const str = input[0];
let idx = 0;
let result = [];

while (idx < str.length){
  if (str[idx] == "<"){
    while (str[idx] != ">"){
      result.push(str[idx++]);
    }
    result.push(str[idx++]);
  }
  else {
    let stack = [];
    while (str[idx] >= 'a' && str[idx] <= 'z' || str[idx] >= '0' && str[idx] <= '9'){
      stack.push(str[idx++]);
    }
    let len = stack.length;
    for (let i = 0; i <= len; i++){
      result.push(stack.pop());
    }
    if (str[idx] === " "){
      result.push(str[idx++]);
    }
  }
}

console.log(result.join(""))
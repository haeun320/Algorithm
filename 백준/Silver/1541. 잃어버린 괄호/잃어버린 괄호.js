const fs = require('fs');
// TODO: 제출 시 경로 변환 필수 ("/dev/stdin")
const input = fs.readFileSync(0).toString().trim();
// const input = fs.readFileSync('test.txt').toString().trim();

let result = "";
let stack = [];
let n = 0;

for (const x of input) {
  if (x === '+' || x === '-') {
    stack.push(n);
    n = 0;
    if (x === '-') {  
      result += stack.reduce((a,b)=>a+b, 0) + "-";
      stack = [];
    }
  }
  else {
    n *= 10;
    n += Number(x);
  }
}
stack.push(n);
result += stack.reduce((a,b)=>a+b, 0);

console.log(eval(result));
const fs = require('fs');
// TODO: 제출 시 경로 변환 필수 ("/dev/stdin")
const input = fs.readFileSync(0).toString().trim().split('\n');
// const input = fs.readFileSync('test.txt').toString().trim().split('\n');

let X = input[0];
let cnt = 0;

while(X.length > 1) {
  X = X.split('').map(Number).reduce((a,b) => a+b, 0).toString();
  cnt++;
}

X = Number(X);
const result = X % 3 === 0 ? "YES" : "NO";

console.log(cnt + "\n" + result);
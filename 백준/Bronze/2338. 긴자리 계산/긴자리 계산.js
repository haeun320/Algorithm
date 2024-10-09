const fs = require('fs');
// TODO: 제출 시 경로 변환 필수 ("/dev/stdin")
const input = fs.readFileSync(0).toString().trim().split('\n');
// const input = fs.readFileSync('test.txt').toString().trim().split('\n');

const A = BigInt(input[0]);
const B = BigInt(input[1]);

console.log((A+B).toString());
console.log((A-B).toString());
console.log((A*B).toString());
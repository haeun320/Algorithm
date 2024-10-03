const fs = require('fs');
// TODO: 제출 시 경로 변환 필수 ("/dev/stdin")
const input = fs.readFileSync(0).toString().trim().split('\n');
// const input = fs.readFileSync('test.txt').toString().trim().split('\n');

const [a, b] = input[0].split(' ').map(Number);
const A = new Set(input[1].split(' ').map(Number));
const B = new Set(input[2].split(' ').map(Number));

const AB = [...A].filter(item => !B.has(item)).length;
const BA = [...B].filter(item => !A.has(item)).length;

console.log(AB + BA);
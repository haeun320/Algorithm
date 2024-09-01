const fs = require('fs');
// TODO: 제출 시 경로 변환 필수 ("/dev/stdin")
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
// const input = fs.readFileSync('test.txt').toString().trim().split('\n');

// 정리
const n = Number(input[0]);

if (n === 0){
  console.log(0);
  return;
}

let opinion = [];
for (let i = 1; i <= n; i++){
  opinion.push(Number(input[i]));
}

const del = Math.round(n * 0.15);
opinion = opinion.sort((a, b) => a - b);
const delOpinion = opinion.slice(del, -del || undefined);

const sum = delOpinion.reduce((a, b) => a + b, 0);
const avg = Math.round(sum / delOpinion.length);

console.log(avg);
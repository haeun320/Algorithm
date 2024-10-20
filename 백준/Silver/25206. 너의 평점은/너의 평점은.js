const fs = require('fs');
// TODO: 제출 시 경로 변환 필수 ("/dev/stdin")
const input = fs.readFileSync(0).toString().trim().split('\n');
// const input = fs.readFileSync('test.txt').toString().trim().split('\n');

const score = {
  'A+': 4.5,
  A0: 4.0,
  'B+': 3.5,
  B0: 3.0,
  'C+': 2.5,
  C0: 2.0,
  'D+': 1.5,
  D0: 1.0,
  F: 0.0,
};

let sumScore = 0;
let sumCredit = 0;

for (let i = 0; i < input.length; i++) {
  const [subject, credit, grade] = input[i].split(' ');
  if (grade === 'P') continue;

  sumScore += Number(credit) * score[grade];
  sumCredit += Number(credit);
}

console.log(sumScore / sumCredit);

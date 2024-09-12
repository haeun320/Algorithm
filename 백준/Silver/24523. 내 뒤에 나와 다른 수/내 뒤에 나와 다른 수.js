const fs = require('fs');
// TODO: 제출 시 경로 변환 필수 ("/dev/stdin")
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
// const input = fs.readFileSync('test.txt').toString().trim().split('\n');

const N = Number(input[0]);
const array = input[1].split(' ').map((item) => Number(item));
const answer = [];
let j = 1;

for (let i = 0; i < N; i++) {
  while (array[i] === array[j]) {
    if (j === N) {
      break;
    }
    j++;
  }

  answer.push(j === N ? -1 : j + 1);
}

console.log(answer.join(' '));

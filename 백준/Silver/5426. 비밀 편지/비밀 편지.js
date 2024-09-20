const fs = require('fs');
// TODO: 제출 시 경로 변환 필수 ("/dev/stdin")
const input = fs.readFileSync(0).toString().trim().split('\n');
// const input = fs.readFileSync('test.txt').toString().trim().split('\n');

const T = Number(input[0]);
for (let i = 0; i < T; i++) {
  const letter = input[i+1];
  const len = Math.sqrt(letter.length);
  const square = [];

  for (let i = 0; i < len; i++) {
    square.push(letter.slice(i*len, (i+1)*len).split(''));
  }
  
  let result = '';
  for (let i = len - 1; i >= 0; i--) {
    for (let j = 0; j < len; j++) {
      result += square[j][i];
    }
  }
  console.log(result);
}
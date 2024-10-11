const fs = require('fs');
// TODO: 제출 시 경로 변환 필수 ("/dev/stdin")
const input = fs.readFileSync(0).toString().trim().split('\n');
// const input = fs.readFileSync('test.txt').toString().trim().split('\n');

const [N, M] = input[0].split(' ').map(Number);
const array = input.slice(1).map(e => e.split(''));

for (let i = 0; i < N; i++) {
  for (let j = 0; j < M; j++) {
    if (array[i][j] !== '.') 
      array[i][M-1-j] = array[i][j];
  }
}

console.log(array.map(e => e.join('')).join('\n'));
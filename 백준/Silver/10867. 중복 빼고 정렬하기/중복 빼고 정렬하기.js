const fs = require('fs');
// TODO: 제출 시 경로 변환 필수 ("/dev/stdin")
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
// const input = fs.readFileSync('test.txt').toString().trim().split('\n');

// 정리
const N = Number(input[0]);
let array = input[1].split(' ').map(item => Number(item));

// 풀이
function solution(N, array) {
  let set = new Set(array);
  console.log([...set].sort((a, b) => a - b).join(' '));
}

solution(N, array);
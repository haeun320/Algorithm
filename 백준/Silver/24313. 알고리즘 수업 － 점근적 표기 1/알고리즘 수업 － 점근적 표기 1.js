const fs = require('fs');
// TODO: 제출 시 경로 변환 필수 ("/dev/stdin")
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
// const input = fs.readFileSync('test.txt').toString().trim().split('\n');

// 정리
const [a1, a0] = input[0].split(' ').map(item => Number(item));
const c = Number(input[1]);
const n0 = Number(input[2]);

// 풀이
function solution(a1, a0, c, n0) {
  // console.log(a1, a0, c, n0);
  if (a1 > c) return 0;
  else if (a1 === c) {
    return (a0 > 0) ? 0 : 1;
  }
  else {
    const contact = (a0 / (c - a1));
    return Number(n0 >= contact);
  }
}

console.log(solution(a1, a0, c, n0));
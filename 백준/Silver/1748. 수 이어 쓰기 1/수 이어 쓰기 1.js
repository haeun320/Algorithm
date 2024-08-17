const fs = require('fs');
// TODO: 제출 시 경로 변환 필수 ("/dev/stdin")
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
// const input = fs.readFileSync('test.txt').toString().trim().split('\n');
// 정리
const N = input[0];

// 풀이
function solution(N) {
  let digit = N.toString().length;

  let answer = 0;
  for (let i = 1; i < digit; i++){
    let end = Number("9".repeat(i));
    let start = Number("1" + "0".repeat(i-1));
    answer += (end - start + 1) * i;
  }

  let end = N;
  let start = Number("1" + "0".repeat(digit-1));
  answer += (end - start + 1) * digit;
  console.log(answer);
}

solution(N);
const fs = require('fs');
// TODO: 제출 시 경로 변환 필수 ("/dev/stdin")
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
// const input = fs.readFileSync('test.txt').toString().trim().split('\n');

// 정리
const [N, M] = input[0].split(' ').map(item => Number(item));

const notHeard = [];
for (let i = 1; i <= N; i++){
  notHeard.push(input[i].toString().trim());
}

const notSeen = [];
for (let i = N + 1; i <= N + M; i++){
  notSeen.push(input[i].toString().trim());
}

// 풀이
function solution(notHeard, notSeen) {
  const A = new Set(notHeard);
  const B = new Set(notSeen);
  
  const notHeardAndSeen = [...A].filter(item => B.has(item)).sort();

  const len = notHeardAndSeen.length
  console.log(len);

  for (let i = 0; i < len; i++){
    console.log(notHeardAndSeen[i]);
  }
}

solution(notHeard, notSeen);
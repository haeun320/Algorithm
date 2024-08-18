const fs = require('fs');
// TODO: 제출 시 경로 변환 필수 ("/dev/stdin")
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
// const input = fs.readFileSync('test.txt').toString().trim().split('\n');

// 정리
const N = input[0];
let array = [];
for (let i = 1; i <= N; i++){
  array.push(Number(input[i]));
}

// 풀이
function solution(N, array) {
  array.sort((a,b) => a - b);
  //console.log(array);

  const avg = Math.round(array.reduce((a,b) => a+b, 0) / N);
  const mid = array[Math.floor(N/2)];
  const range = array[N-1] - array[0];

  let cnt = new Map();

  for (let i = 0; i < N; i++){
    cnt.set(array[i], (cnt.get(array[i]) || 0)+1);
  }

  cnt = [...cnt].sort((a,b) => b[1]-a[1]);
  
  //const min = (cnt[0][1] === cnt[1][1]) ? cnt[1][0] : cnt[0][0];
  let min = cnt[0][0];
  if (N > 1 && cnt[0][1] === cnt[1][1]) min = cnt[1][0];

  console.log(avg + "\n" + mid + "\n" + min + "\n" + range);
}

solution(N, array);
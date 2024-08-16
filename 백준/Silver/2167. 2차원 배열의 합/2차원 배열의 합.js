const fs = require('fs');
// TODO: 제출 시 경로 변환 필수 ("/dev/stdin")
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
// 정리
const [N, M] = input[0].split(' ').map(item => Number(item));

const arr = [];
for (let i = 1; i < N+1; i++){
  arr.push(input[i].split(' ').map(item=>Number(item)));
}

const K = Number(input[N+1]);

const pos = [];
for (let i = N + 2; i < N + 2 + K; i++){
  pos.push(input[i].split(' ').map(item=>Number(item)));
}

// 풀이
function solution(N, M, arr, K, pos) {
  for (let k = 0; k < K; k++){
    const [i, j, x, y] = pos[k];

    let sum = 0;
    for (let p = i; p < x + 1; p++){
      for (let q = j; q < y + 1; q++){
        sum += arr[p-1][q-1];
      }
    }

    console.log(sum);
  }
}

solution(N, M , arr, K, pos);
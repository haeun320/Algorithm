const fs = require('fs');
// TODO: 제출 시 경로 변환 필수 ("/dev/stdin")
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
// const input = fs.readFileSync('test.txt').toString().trim().split('\n');

// 정리
const [N, M] = input[0].split(' ').map(item => Number(item));
let dic = new Map();
let reverseDic = new Map();

for (let i = 1; i <= N; i++){
  dic.set(i, input[i]);
  reverseDic.set(input[i], i);
}

for (let i = N + 1; i <= N + M; i++){
  if (input[i][0] >= '0' && input[i][0] <= '9') {
    console.log(dic.get(Number(input[i])));
  }
  else {
    console.log(reverseDic.get(input[i]));
  }
}
const fs = require('fs');
// TODO: 제출 시 경로 변환 필수 ("/dev/stdin")
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
// const input = fs.readFileSync('test.txt').toString().trim().split('\n');

const [N, M] = input[0].split(' ').map(Number);

const password = new Map();
for (let i = 1; i <= N; i++){
  const [site, pw] = input[i].split(' ');
  password.set(site, pw);
}

for (let i = N+1; i <= N+M; i++){
  const site = input[i];
  console.log(password.get(site));
}
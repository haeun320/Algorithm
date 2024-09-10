const fs = require('fs');
// TODO: 제출 시 경로 변환 필수 ("/dev/stdin")
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
// const input = fs.readFileSync('test.txt').toString().trim().split('\n');

const N = input[0].split('').map(item => Number(item));
const m = new Map();
for (let i = 0; i < N.length; i++){
  m.set(N[i], (m.get(N[i]) || 0) + 1);
}

const six = Math.ceil(((m.get(6)||0) + (m.get(9)||0)) / 2);
m.set(6, six);
m.delete(9);

const max = Math.max(...m.values());
console.log(max);
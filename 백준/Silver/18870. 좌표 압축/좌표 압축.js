const fs = require('fs');
// TODO: 제출 시 경로 변환 필수 ("/dev/stdin")
const input = fs.readFileSync(0).toString().trim().split('\n');
// const input = fs.readFileSync('test.txt').toString().trim().split('\n');

const N = Number(input[0]);
const array = input[1].split(' ').map(Number);

const sortedSet = [...new Set(array)].sort((a,b)=>a-b);

const index = new Map();
sortedSet.forEach((v, i) => {
  index.set(v, i);
});

const result = array.map(a => index.get(a));
console.log(result.join(' '))
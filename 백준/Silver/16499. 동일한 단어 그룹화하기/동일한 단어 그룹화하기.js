const fs = require('fs');
// TODO: 제출 시 경로 변환 필수 ("/dev/stdin")
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
// const input = fs.readFileSync('test.txt').toString().trim().split('\n');

// 정리
const N = Number(input[0]);
let words = [];
for (let i = 1; i <= N; i++){
  words.push(input[i].toString());
}

// 풀이
function makeGroup(word){
  let group = new Map();
  const array = [...word].sort();
  for (let i = 0; i < array.length; i++){
    group.set(array[i], group.get(array[i]) + 1 || 1);
  }
  return group;
}

function solution(N, words) {
  let array = words.map(item => makeGroup(item));
  let group = new Set(array.map(item => JSON.stringify([...item])));
  console.log(group.size);
}

solution(N, words);
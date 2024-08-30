const fs = require('fs');
// TODO: 제출 시 경로 변환 필수 ("/dev/stdin")
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
// const input = fs.readFileSync('test.txt').toString().trim().split('\n');

// 정리
const [N, C] = input[0].split(' ').map(item => Number(item));
let message = input[1].split(' ').map(item => Number(item));

let map = new Map();
for (let i = 0; i < N; i++){
  let num = message[i];
  map.get(num) > 0 ? map.set(num, map.get(num) + 1) : map.set(num, 1);
}

let array = [...map].sort((a, b) => b[1] - a[1]);
let string = "";
for (let i = 0; i < array.length; i++){
  string += (array[i][0].toString() + " ").repeat(array[i][1]);
}
console.log(string.trim());

const fs = require('fs');
// TODO: 제출 시 경로 변환 필수 ("/dev/stdin")
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
// const input = fs.readFileSync('test.txt').toString().trim().split('\n');

// 정리
const n = Number(input[0]);
let student = [];
for (let i = 1; i <= n; i++){
  student.push(input[i].split(' '));
}

let array = []
for (let i = 0; i < n; i++){
  array.push([student[i][0], (student[i][3] + student[i][2].padStart(2, '0') + student[i][1].padStart(2, '0'))]);
}

array.sort((a, b) => b[1] - a[1]);

console.log(array[0][0]);
console.log(array[n-1][0])